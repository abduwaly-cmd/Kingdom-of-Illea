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
        this.description = "Early morning in the Kingdom eh ;)";
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
