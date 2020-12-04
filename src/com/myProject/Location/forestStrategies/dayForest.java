package com.myProject.Location.forestStrategies;

import com.myProject.Character.Nymph;
import com.myProject.Character.Wizard;
import com.myProject.Character.Character;
import com.myProject.Quests.Quest;
import com.myProject.Quests.Riddle;

import java.util.ArrayList;

public class dayForest implements LocInstance {
    private final Quest quest;
    private final String name;
    private final String description;
    private final Character enemy;
    private final ArrayList<Character> characters = new ArrayList<>();

    public dayForest() {
        this.name = "Niadale Forest (Day)";
        this.enemy = null;
        this.quest = new Riddle();
        this.description = "Its a sunny day, and you are resting under an apple tree." +
                "\nA wizard is approaching you, you can talk to him...";
        this.characters.add(new Wizard());
        this.characters.add(new Nymph());
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
