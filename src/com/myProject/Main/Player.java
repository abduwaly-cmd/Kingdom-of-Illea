package com.myProject.Main;

import com.myProject.Location.Location;
import com.myProject.Observer.*;
import com.myProject.Timer.StopWatch;
//import locations.*;

public class Player extends ConcreteObserver {
	private Map map;
	private int health;
	private String name;
	//private Quest currentQuest;
	private String dialogue;
	private StopWatch timer;
	private Location currentLocation;
	private static Player instance;

	private Player(Subject subject, String name) {
		super(subject);
		this.map = new Map();
		this.name = name;
		this.timer = new StopWatch();
		this.currentLocation = this.map.current.location;
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
	Location getlocation() {
		return currentLocation;
	}
	public String toString() {
		return name;
	}
	void setDialogue(String s) {
		dialogue = s;
	}
	void setlocation(Location l) {
		currentLocation = l;
	}

	@Override
	public void update(String[] in, Console console) {
		switch(in[0]) {
			case "test":
				console.switchTerminaltoSocketInput();
				break;
			case "walk":
				Location nextLoc = this.map.next(in[1]);
				System.out.println("walked from " + currentLocation + " to " + nextLoc);
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
