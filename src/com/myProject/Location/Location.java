package com.myProject.Location;

import com.myProject.Character.Character;
import com.myProject.Driver.Player;
import com.myProject.Location.locationStrategies.LocInstance;
import com.myProject.Quests.Quest;

public class Location {
	private Quest quest;
	private String name;
	private String description;
	private String soundFile;
	private boolean objDone;
	private Character npc;
	private Character enemy;
	private Location[] nextLocations = null;

	public Location(LocInstance inst) { switchInstance(inst); }

	// Overloaded function for switching between *SAME* location instances
	public void switchInstance() { }
	public void switchInstance(LocInstance inst) {
		this.npc = inst.getCharacter();
		this.name = inst.getName();
		this.quest = inst.getQuest();
		this.enemy = inst.getEnemy();
		this.objDone = false;
		this.soundFile = inst.getSoundFile();
		this.description = inst.getDescription();
	}

	// Talks to players
	public void talk(String charName) {
		if(charName.equals(this.npc.getRace().toLowerCase()))
			System.out.println(this.npc.speak());
		else System.out.println("Character un-available");
	}

	// Takes the item from a character and gives it to the player
	public void takeItem(Player player, String itemName) {
		if(this.npc.giveItem(player, itemName)) {
			setDone();
			return;
		}
		System.out.println("Invalid item :/");
	}

	// Getters
	public Quest getQuest() { return this.quest; }
	public boolean isObjDone() { return this.objDone; }
	public String getSoundFile() { return this.soundFile; }
	public Character getCharacters() { return this.npc; }
	public String printDescription() { return this.description; }

	// Setters
	public void setNextLocations(Location[] nextLocations) { this.nextLocations = nextLocations; }
	public void setQuestDone(String characterSpecies) {
		this.quest.setDone();
		if(characterSpecies != null) talk(characterSpecies);
		else setDone();
	}
	// checks and sets the current location to done so the player can move forward to the next locations
	public void setDone() {
		if(!this.quest.isDone()) return;
		this.objDone = true;
		if(nextLocations == null);
		else if(nextLocations.length == 2)
			System.out.println("You can now walk left to " + nextLocations[0] + " or walk right to " + nextLocations[1]);
		else System.out.println("You can now walk to " + nextLocations[0]);
	}

	@Override
	public String toString() { return name; }
}