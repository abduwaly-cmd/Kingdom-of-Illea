package com.myProject.Location.locationStrategies;

import com.myProject.Character.Character;
import com.myProject.Character.Pixie;
import com.myProject.Character.Troll;
import com.myProject.Quests.Quest;
import com.myProject.Quests.Riddle;

public class DemonKingdomV implements LocInstance {

    private final Quest quest;
    private final String name;
    private final String description;
    private final Character enemy;
    private final Character character;

    public DemonKingdomV() {
        this.name = "Niadale Forest (Night)";
        this.enemy = new Troll();
        this.quest = new Riddle();
        this.character = new Pixie();
        this.description = "Early morning in the forest eh ;)";
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
