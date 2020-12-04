package com.myProject.Location.locationStrategies;

import com.myProject.Quests.Quest;
import com.myProject.Character.*;
import com.myProject.Character.Character;
import com.myProject.Quests.noQuest;
import com.myProject.Quests.questState.defaultState;

public class HumanKingdom implements LocInstance {
    private final Quest quest;
    private final String name;
    private final String description;
    private final Character enemy;
    private final Character character;

    public HumanKingdom() {
        this.name = "Human Kingdom";
        this.enemy = null;
        this.quest = new noQuest();
        this.character = new Wizard();
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
