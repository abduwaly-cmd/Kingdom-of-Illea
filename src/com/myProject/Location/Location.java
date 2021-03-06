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

	// Talks to npc
	public void talk() {
		if(!this.npc.isCanNotSpeak())
			System.out.println("\n" + this.npc.speak());
		if(this.npc.isCanNotSpeak()) setDone();
	}
	public void talk(String charName) {
		if(charName.isEmpty()) talk();
		else if(charName.equals(this.npc.getRace().toLowerCase()))
			talk();
		else System.out.println("> Character un-available");
	}

	// Takes the item from a character and gives it to the player
	public void takeItem(Player player, String itemName) {
		if(this.npc.giveItem(player, itemName)) {
			talk();
			return;
		}
		System.out.println("> Invalid item, cant find it :/");
	}

	// Getters
	public Quest getQuest() { return this.quest; }
	public boolean isObjDone() { return this.objDone; }
	public Character getEnemy() { return this.enemy; }
	public String getSoundFile() { return this.soundFile; }
	public Character getCharacter() { return this.npc; }
	public Location[] getNextLocs() { return this.nextLocations; }
	public String printDescription() { return this.description; }

	// Setters
	public void setNextLocations(Location[] nextLocations) { this.nextLocations = nextLocations; }

	public void setQuestDone() {
		this.quest.setDone();
		setDone();
	}

	// checks and sets the current location to done so the player can move forward to the next locations
	public void setDone() {
		if(!this.quest.isDone()) return;
		this.objDone = true;
		if(this.npc != null && !this.npc.isCanNotSpeak()) { talk(); return; }
		if(nextLocations == null) { System.out.println("\n>> YOU SAVED THE KINGDOMS & WON! <<"); System.exit(1); }
		else if(nextLocations.length == 2)
			System.out.println("[Map] You can now walk left to " + nextLocations[0] + " or walk right to " + nextLocations[1] +
					"\nby simple having your phone face the desired destination :)");
		else System.out.println("[Map] You can now walk to " + nextLocations[0] + " by gently rotating your phone..");
		System.out.println("Type [Walk] to start");
	}

	@Override
	public String toString() { return name; }
}