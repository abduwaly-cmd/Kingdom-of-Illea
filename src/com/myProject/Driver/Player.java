package com.myProject.Driver;

import com.myProject.Items.Item;
import com.myProject.Items.*;
import com.myProject.Location.Location;
import com.myProject.Observer.*;
import com.myProject.Quests.Quest;
import com.myProject.Timer.StopWatch;
import com.myProject.Driver.playerCommands.*;

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
	private boolean reading;
	private String[] prevCommand;
	private Location currentLocation;
	private StopWatch timer;
//	private SoundPlayer soundPlayer;
	private ControlPanel controlPanel;
	private ArrayList<Item> items = new ArrayList<>();
	private ArrayList<Item> spheres = new ArrayList<>();
	private static Player instance;

	private Player(Subject subject, String name) {
		super(subject);
		this.map = new Map();
		this.name = name;
		this.timer = new StopWatch();
		this.reading = true;
		this.items.add(new Sword());
		this.currentQuest = null;
		Command[] cmds = new Command[] { new walkToLoc(), new talkToCommand(), new startQuest(), new pickUpCommand()};
		this.controlPanel = new ControlPanel(cmds);
		setLocation(this.map.getCurrentLocation(), this.map.getNext());
//		soundPlayer = new SoundPlayer(this.currentLocation.getSoundFile());
//		soundPlayer.change(this.currentLocation.getSoundFile());
	}

	public static synchronized Player getInstance(Subject subject, String name) {
		if (instance == null)
			instance = new Player(subject, name);
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
	public void setLocation(Location loc, Location[] nextLocs) {
		currentLocation = loc;
		System.out.println("You are now in " + currentLocation);
		System.out.println(currentLocation.printDescription());
		currentLocation.setNextLocations(nextLocs);
	}

	public void switchConsoleToSocket() { switchConsoleToSocket(); }
	public void switchConsoleToTerminal() { switchConsoleToTerminal(); }

	@Override
	public void update(String[] in, Console console) {
		switch (in[0]) {
			case "walk":
				controlPanel.execute(0, console, this, in);
				break;
			case "talk":
				controlPanel.execute(1, console, this, in);
				break;
			case "start":
				controlPanel.execute(2, console, this, null);
				break;
			case "take":
				controlPanel.execute(3, console, this, in);
				break;
			case "test":
				console.switchTerminaltoSocketInput();
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
				System.out.print("Testing :)");
				//currentQuest.update(console, in[1]);
				System.out.println("\t> " + Arrays.toString(in));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//console.switchSockettoTerminalInput();
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
					controlPanel.execute(2, console, this, in);
				else System.out.println("Invalid :c");
				break;
		}
		prevCommand = in;
	}
}
