package com.myProject.Location.locationStrategies;

import com.myProject.Quests.Quest;
import com.myProject.Character.*;
import com.myProject.Character.Character;
import com.myProject.Quests.noQuest;

public class HumanKingdom implements LocInstance {
    private final Quest quest;
    private final String name;
    private final String description;
    private final String soundFile;
    private final Character enemy;
    private final Character character;

    public HumanKingdom() {
        this.name = "Mecethea Kingdom";
        this.enemy = null;
        this.quest = new noQuest();
        this.soundFile = "Kingdom";
        this.character = new Wizard();
        this.description = "Its a sunny day, and you are resting under an apple tree." +
                "\nA wizard is approaching you, you can talk to him...";    }

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
