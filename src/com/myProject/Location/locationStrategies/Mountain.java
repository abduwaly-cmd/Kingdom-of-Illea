package com.myProject.Location.locationStrategies;

import com.myProject.Character.Character;
import com.myProject.Character.Dwarf;
import com.myProject.Character.Wizard;
import com.myProject.Quests.Quest;
import com.myProject.Quests.noQuest;

public class Mountain implements LocInstance {
    private final Quest quest;
    private final String name;
    private final String description;
    private final Character enemy;
    private final Character character;

    public Mountain() {
        this.name = "Mount Daein";
        this.enemy = null;
        this.quest = new Maze();
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
    public String getDescription() { return this.description; }
    @Override
    public Character getCharacter() { return this.character; }
}
