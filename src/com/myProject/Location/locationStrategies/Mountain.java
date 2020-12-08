package com.myProject.Location.locationStrategies;

import com.myProject.Character.Character;
import com.myProject.Character.Dwarf;
import com.myProject.Quests.Maze;
import com.myProject.Quests.Quest;

public class Mountain implements LocInstance {
    private final Quest quest;
    private final String name;
    private final String soundFile;
    private final String description;
    private final Character enemy;
    private final Character character;

    public Mountain() {
        this.name = "Mount Daein";
        this.enemy = null;
        this.quest = new Maze();
        this.soundFile = "Mount Daein (Maze)";
        this.character = new Dwarf();
        this.description = "This location is home to the Dwarves that hold the Air Sphere." +
                "\nIn order to be able to attain the Air Sphere, you must walk through" +
                "\nthis maze and find their underground city."+
                "\nType [start] to walk through the maze...";
    }

    @Override
    public Quest getQuest() { return this.quest; }
    @Override
    public String getName() { return this.name; }
    @Override
    public Character getEnemy() { return this.enemy; }
    @Override
    public String getSoundFile() { return this.soundFile; }
    @Override
    public String getDescription() { return this.description; }
    @Override
    public Character getCharacter() { return this.character; }
}
