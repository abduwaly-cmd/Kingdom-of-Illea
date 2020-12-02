package com.myProject.Location;

import com.myProject.Character.*;
import com.myProject.Character.Character;

import java.util.ArrayList;

public class Location {
	String name;
	private ArrayList<Character> characters;
///	Item [] objects;
//	Quest quest;

	Location(String name){
		this.name = name;
//		this.objects = objects;
//		this.quest = quest;
	}
	public void setCharacters (ArrayList<Character> characters) {
		this.characters = characters;
	}

	@Override
	public String toString() {
		return "Location{" +
				"name='" + name + '\'' +
				'}';
	}
}