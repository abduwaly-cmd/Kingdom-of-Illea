package com.myProject.Location;

import com.myProject.Character.Character;
import com.myProject.Driver.Player;
import com.myProject.Location.locationStrategies.LocInstance;
import com.myProject.Quests.Quest;

import java.util.ArrayList;

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
		if(!this.quest.isDone() || !this.characters.isEmpty()) return;
		this.objDone = true;
		if(nextLocations == null);
		else if(nextLocations.length == 2)
			System.out.println("You can now walk left to " + nextLocations[0] + " or walk right to " + nextLocations[1]);
		else System.out.println("You can now walk to " + nextLocations[0]);
	}

	public void talk(String charName, String[] playerSpeech) {
		if(charName == null && playerSpeech == null && !this.characters.get(0).isCanNotSpeak()) {
			System.out.println(this.characters.get(0).speak());
			if(this.characters.get(0).isCanNotSpeak()) this.characters.remove(0);
			return;
		}
		for(Character character: characters)
			if (character.getRace().toLowerCase().equals(charName)) {
				if(!character.isCanNotSpeak()) {
					if (playerSpeech == null) System.out.println(character.talk(null));
					else System.out.println(character.talk(playerSpeech));
				}
				return;
			}
		System.out.println("Character un-available");
	}

	public ArrayList<Character> getCharacters() { return this.characters; }

	public Quest getQuest() { return this.quest; }
	public String printDescription() { return this.description; }
	public void setNextLocations(Location[] nextLocations) { this.nextLocations = nextLocations; }
	public void setQuestDone(String characterSpecies) {
		this.quest.setDone();
		if(characterSpecies != null) talk(characterSpecies, null);
		else setDone();
	}

	public void switchInstance() { }

	@Override
	public String toString() {
		return name;
	}

	public void takeItem(Player player, String itemName) {
		for(Character character: characters)
			if(character.giveItem(player, itemName)) {
				setDone();
				return;
			}
		System.out.println("Invalid item :/");
	}
}