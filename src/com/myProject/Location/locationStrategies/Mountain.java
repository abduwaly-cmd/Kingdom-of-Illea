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
        this.description = "You arrive at Mount Daein, it is huge and your eyes can't see the top"
        		+"\nThis mountain is said to be the home to the Dwarves that hold the Air Sphere."
        		+"\nHowever no one has seen the dwarves in many years due to the many traps set at then entrance of the mountain" +
                "\n\nAt the entrance of the mountain you glimpse a small hat making its way through"
                +"\nIt must be a dwarf!"
                + "\nIn order to be able to obtain the Air Sphere, you must find your way through" +
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
