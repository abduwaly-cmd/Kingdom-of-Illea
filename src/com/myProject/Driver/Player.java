package com.myProject.Driver;

import com.myProject.Location.Location;
import com.myProject.Observer.*;
import com.myProject.Timer.StopWatch;
import com.myProject.playerCommands.Command;
import com.myProject.playerCommands.ControlPanel;
import com.myProject.playerCommands.walkToLoc;

//enum commands {
//	walk(0),
//	look(1),
//	time(2)
//}

public class Player extends ConcreteObserver {
	private Map map;
	private int health;
	private String name;
	//private Quest currentQuest;
	private String dialogue;
	private StopWatch timer;
	private Location currentLocation;
	private ControlPanel controlPanel;
	private static Player instance;

	private Player(Subject subject, String name) {
		super(subject);
		this.map = new Map();
		this.name = name;
		this.timer = new StopWatch();
		Command[] cmds = new Command[] {new walkToLoc()};
		this.controlPanel = new ControlPanel(cmds);
		setLocation(this.map.getCurrentLocation(), this.map.getNext());
	}
	
	public static synchronized Player getInstance(Subject subject, String name) {
		if (instance == null)
			instance = new Player(subject, name);
		return instance;
	}

	int getHealth() {
		return health;
	}
	String getDialogue() {
		return dialogue;
	}
	void setHealth(int i) {
		health = i;
	}
	void setDialogue(String s) { dialogue = s; }

	public Map getMap() { return this.map; }
	public int getTime() { return this.timer.getSeconds(); }
	public String toString() { return name; }
	public Location getLocation() { return currentLocation; }
	public void setLocation(Location loc, Location[] nextLocs) {
		currentLocation = loc;
		currentLocation.setNextLocations(nextLocs);
	}

	@Override
	public void update(String[] in, Console console) {
		switch(in[0]) {
			case "test":
				console.switchTerminaltoSocketInput();
				break;
			case "walk":
				controlPanel.execute(0, console, this, in[1]);
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
				System.out.println("interesting...");
				//currentQuest.update(console, in[1]);
				System.out.println(in[1]);
				console.switchSockettoTerminalInput();
				break;
			case "watch":
				System.out.println(this.timer.getSeconds());
			case "talk":
			case "stop":
			case "use":
			default:
				break;
		}
	}
}
