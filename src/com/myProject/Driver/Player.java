package com.myProject.Driver;

import com.myProject.Items.Item;
import com.myProject.Items.*;
import com.myProject.Location.Location;
import com.myProject.Observer.*;
import com.myProject.Quests.Quest;
import com.myProject.Timer.StopWatch;
import com.myProject.Driver.playerCommands.*;

import javax.sound.sampled.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

//enum commands {
//	walk(0),
//	look(1),
//	time(2)
//}

public class Player extends ConcreteObserver {
	private Map map;
	private int health;
	private Quest currentQuest;
	private String name;
	private String dialogue;
	private Console console;
	private boolean reading;
	private String[] prevCommand;
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
		this.reading = true;
		this.console = console;
		this.items.add(new Sword());
		this.currentQuest = null;
		Command[] cmds = new Command[] { new walkToLoc(), new talkToCommand(), new startQuest(), new pickUpCommand()};
		this.controlPanel = new ControlPanel(cmds);
		setLocation(this.map.getCurrentLocation(), this.map.getNext());
		soundPlayer = new SoundPlayer(this.currentLocation.getSoundFile());
	}

	public static synchronized Player getInstance(Console console, String name) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		if (instance == null)
			instance = new Player(console, name);
		return instance;
	}

	public Map getMap() { return this.map; }
	public int getTime() { return this.timer.getSeconds(); }
	public String toString() { return name; }
	public Location getLocation() { return currentLocation; }
	public ArrayList<Item> getItems() { return this.items; }
	public void addItem(Item item) {
		if(item.toString().contains("sphere")) {
			this.spheres.add(item);
			System.out.println("This " + item + " has been added to your amulet...");
		} else {
			this.items.add(item);
			System.out.println("This " + item + " has been added to your inventory...");
		}
	}
	public void setLocation(Location loc, Location[] nextLocs) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		currentLocation = loc;
		System.out.println("You are now in " + currentLocation);
		if(soundPlayer != null)
			soundPlayer.change(this.currentLocation.getSoundFile());
		System.out.println(currentLocation.printDescription());
		currentLocation.setNextLocations(nextLocs);
	}

	public void switchConsoleToSocket() { console.switchTerminaltoSocketInput(); }
	public void switchConsoleToTerminal() { console.switchSockettoTerminalInput(); }

	@Override
	public void update(String[] in) throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException {
		switch (in[0]) {
			case "walk":
				controlPanel.execute(0, this, in);
				break;
			case "talk":
				controlPanel.execute(1, this, in);
				break;
			case "start":
				controlPanel.execute(2, this, null);
				break;
			case "take":
				controlPanel.execute(3, this, in);
				break;
			case "test":
				switchConsoleToSocket();
				break;
			case "exit":
				System.out.println("You're leaving :c");
				break;
			case "look":
				break;
			case "tomato":
				System.out.println("TOMATO POTATO");
				break;
			case "socket":
//				if(currentLocation.getQuest().isActive())
//					controlPanel.execute(2, this, in);
				//System.out.print("Testing :)");
				//currentQuest.update(console, in[1]);
				System.out.println("\t> " + Arrays.toString(in));
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			case "watch":
				System.out.println(this.timer.getSeconds());
				break;
			case "inventory":
				if(items.isEmpty()) System.out.println("Your inventory is empty :)");
				for(Item item: items)
					System.out.print("\t> " + item.toString());
				break;
			case "stop":
			case "use":
			default:
				if(currentLocation.getQuest().isActive())
					controlPanel.execute(2, this, in);
				else System.out.println("Invalid :c");
				break;
		}
		prevCommand = in;
	}
}
