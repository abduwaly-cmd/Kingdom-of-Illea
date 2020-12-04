package com.myProject.Location.forestStrategies;

import com.myProject.Quests.Quest;
import com.myProject.Quests.Riddle;
import com.myProject.Character.*;
import com.myProject.Character.Character;

import java.util.ArrayList;

public class nightForest implements LocInstance {

    private final Quest quest;
    private final String name;
    private final String description;
    private final Character enemy;
    private final ArrayList<Character> characters = new ArrayList<>();

    public nightForest() {
        this.name = "Niadale Forest (Night)";
        this.enemy = new Troll();
        this.quest = new Riddle();
        this.description = "Early morning in the forest eh ;)";
        this.characters.add(new Pixie());
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
    public ArrayList<Character> getCharacters() { return this.characters; }
}
