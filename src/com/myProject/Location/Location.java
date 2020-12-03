package com.myProject.Location;

import com.myProject.Character.Character;
import com.myProject.Location.forestStates.LocInstance;
import com.myProject.Location.forestStates.dayForest;

import java.util.ArrayList;

public class Location {
	private String name;
//	Quest quest;
//	Item [] objects;
	private Location[] nextLocations = null;
	private ArrayList<Character> characters;

	public Location(String name){
		this.name = name;
//		this.objects = objects;
//		this.quest = quest;
	}

	Location(Location inst) {

	}

	public void setName(String name) { this.name = name; }
	public void setCharacters (ArrayList<Character> characters) { this.characters = characters; }
	public void setNextLocations(Location[] nextLocations) { this.nextLocations = nextLocations; }

	@Override
	public String toString() {
		return name;
	}
}