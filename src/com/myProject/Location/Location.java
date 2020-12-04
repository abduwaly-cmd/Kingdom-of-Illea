package com.myProject.Location;

import com.myProject.Character.Character;
import com.myProject.Driver.Player;
import com.myProject.Location.forestStrategies.LocInstance;
import com.myProject.Quests.Quest;

import java.util.ArrayList;
import java.util.Queue;

public class Location {
	private Quest quest;
	private String name;
	private String description;
	private boolean objDone;
	private Character enemy;
	private ArrayList<Character> characters;
	private Location[] nextLocations = null;

	Location(LocInstance inst) { switchInstance(inst); }

	public void switchInstance(LocInstance inst) {
		this.name = inst.getName();
		this.quest = inst.getQuest();
		this.enemy = inst.getEnemy();
		this.objDone = false;
		this.characters = inst.getCharacters();
		this.description = inst.getDescription();
	}

	public void setDone() {
		if(!this.quest.isDone()) return;
		this.objDone = true;
		if(nextLocations == null);
		else if(nextLocations.length == 2)
			System.out.println("You can now walk left to " + nextLocations[0] + " or walk right to " + nextLocations[1]);
		else System.out.println("You can now walk to " + nextLocations[0]);
	}

	public void talk(String ch, String[] in) {
		for(Character character: characters) {
			if (character.getRace().toLowerCase().equals(ch)) {
				if(in == null) System.out.println(character.speek());
				else System.out.println(character.talk(in));
				return;
			}
		}
		System.out.println("Character un-available");
	}


	public Quest getQuest() { return this.quest; }
	public String printDescription() { return this.description; }
	public void setNextLocations(Location[] nextLocations) { this.nextLocations = nextLocations; }

	public void setQuestDone(String character) {
		this.quest.setDone();
		if(character != null) talk(character, null);
		else setDone();
	}

	public void switchInstance() { }

	@Override
	public String toString() {
		return name;
	}
}