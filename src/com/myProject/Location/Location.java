package com.myProject.Location;

import com.myProject.Character.Character;
import com.myProject.Location.forestStrategies.LocInstance;

import java.util.ArrayList;

public class Location {
	String name;
//	Quest quest;
//	Item [] objects;
	private Location[] nextLocations = null;
	private ArrayList<Character> characters;

	Location(String name){
		this.name = name;
//		this.objects = objects;
//		this.quest = quest;
	}

	Location(LocInstance inst) {
		this.name = inst.getName();
	}

	public void setName(String name) { this.name = name; }
	public void setCharacters (ArrayList<Character> characters) { this.characters = characters; }
	public void setNextLocations(Location[] nextLocations) { this.nextLocations = nextLocations; }

	@Override
	public String toString() {
		return name;
	}
}