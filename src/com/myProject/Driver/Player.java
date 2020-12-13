package com.myProject.Driver;

import com.myProject.Items.Item;
import com.myProject.Items.*;
import com.myProject.Location.Location;
import com.myProject.Observer.*;
import com.myProject.Timer.StopWatch;
import com.myProject.Driver.playerCommands.*;

import javax.sound.sampled.*;
import java.io.IOException;
import java.util.ArrayList;

enum commands {
	walk,
	talk,
	startQuest,
	takeItem,
	useItem,
	makeItem
}

public class Player extends ConcreteObserver {
	private Map map;
	private int health;
	private double vulnerability;
	private String name;
	private Console console;
	private Location currentLocation;
	private StopWatch timer;
	private SoundPlayer soundPlayer;
	private ControlPanel controlPanel;
	private ArrayList<Item> items = new ArrayList<>();
	private ArrayList<Item> spheres = new ArrayList<>();
	private static Player instance;

	private Player(Console console, String name) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		super((Subject) console);
		this.map = new Map();
		this.name = name;
		this.timer = new StopWatch();
		this.health = 100;
		this.console = console;
		this.items.add(new Sword());
		this.items.add(new Shield());
		this.vulnerability = 1;
		Command[] cmds = new Command[] { new walkToLoc(), new talkToCommand(), new startQuest(), new pickUpCommand(), new useItemCommand(), new makeItemCommand()};
		this.controlPanel = new ControlPanel(cmds);
		setLocation(this.map.getCurrentLocation(), this.map.getNext());
		soundPlayer = new SoundPlayer(this.currentLocation.getSoundFile());
	}

	public static synchronized Player getInstance(Console console, String name) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		if (instance == null)
			instance = new Player(console, name);
		return instance;
	}

	public int getTime() { return this.timer.getSeconds(); }
	public String toString() { return name; }
	public double getStrength() { return spheres.size()/4.0; }
	public Location getLocation() { return currentLocation; }
	public double getVulnerability() { return this.vulnerability; }
	public ArrayList<Item> getItems() { return this.items; }
	public synchronized int getHealth() { return this.health; }
	public SoundPlayer getSoundPlayer() { return this.soundPlayer; }

	public synchronized void setHealth(int n) {
		this.health += n;
		if(this.health < 0) this.health = 0;
		else if(this.health > 100) this.health = 100;
		else if(n > 0 && n != 100) System.out.println("> You Healed +" + n + " [" + this.health + "]");
		else if(n < 0) System.out.println("> You have been attacked " + n + " [" + this.health + "]");
	}

	public void addItem(Item item) {
		if(item.toString().toLowerCase().contains("sphere")) {
			this.spheres.add(item);
			System.out.println("> " + item + " has been added to your amulet...");
		} else {
			this.items.add(item);
			System.out.println("> " + item + " has been added to your inventory...");
		}
	}
	public void useItem(String itemName) {
		for(Item item:items)
			if(item.getName().toLowerCase().equals(itemName)) {
				item.use(this);
				return;
			}
		System.out.println("You do not possess this item");
	}

	public void walk(String faceOrhead, String pos) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		if(pos != null && pos.equals(faceOrhead)) {
			Location nextLoc = map.next("");
			setLocation(nextLoc, map.getNext());
		} else if(faceOrhead.equals("Right") || faceOrhead.equals("Left")) {
			Location nextLoc = map.next(faceOrhead);
			setLocation(nextLoc, map.getNext());
		}
	}

	private void setLocation(Location loc, Location[] nextLocs) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		if (loc.toString().toLowerCase().contains("forest")) loc.switchInstance();
		else if (loc.toString().equals("The Dooms of Valm") && getTime() > 300) loc.switchInstance();
		currentLocation = loc;
		System.out.println("\n[Map] You are now in " + currentLocation);
		if(soundPlayer != null) soundPlayer.change(this.currentLocation.getSoundFile());
		System.out.println("[" + currentLocation + "] " + currentLocation.printDescription());
		currentLocation.setNextLocations(nextLocs);
		switchConsoleToTerminal();
	}
	public void setVulnerability(double vulnerability) { this.vulnerability = vulnerability; }

	public void switchConsoleToSocket() { console.switchTerminaltoSocketInput(); }
	public void switchConsoleToTerminal() { console.switchSockettoTerminalInput(); }

	@Override
	public void update(String[] in) throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException {
		if(in != null)
			switch (in[0]) {
				case "walk":
					controlPanel.execute(commands.walk.ordinal(), this, in);
					break;
				case "talk":
					controlPanel.execute(commands.talk.ordinal(), this, in);
					break;		
				case "start":
					if(!currentLocation.getQuest().isActive()) 
						controlPanel.execute(commands.startQuest.ordinal(), this, null);
					break;
				case "take":
					controlPanel.execute(commands.takeItem.ordinal(), this, in);
					break;
				case "use":
					controlPanel.execute(commands.useItem.ordinal(), this, in);
					break;
				case "make":
					controlPanel.execute(commands.makeItem.ordinal(), this, in);
					break;
				case "socket":
					if(currentLocation.getQuest().isActive())
						controlPanel.execute(commands.startQuest.ordinal(), this, in);
					else controlPanel.execute(commands.walk.ordinal(), this, in);
					break;
				case "inventory":
					if(items.isEmpty()) System.out.println("Your inventory is empty :)");
					else for(Item item: items) System.out.print("\t> " + item.toString());
					break;
					
				default:
					if(currentLocation.getQuest().isActive())
						controlPanel.execute(commands.startQuest.ordinal(), this, in);
					else System.out.println("Please type in a valid command");
					break;
			}
	}
}
