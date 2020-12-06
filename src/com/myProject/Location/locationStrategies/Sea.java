package com.myProject.Location.locationStrategies;

import com.myProject.Character.Character;
import com.myProject.Character.Siren;
import com.myProject.Character.Wizard;
import com.myProject.Quests.Quest;
import com.myProject.Quests.noQuest;

public class Sea implements LocInstance {
    private final Quest quest;
    private final String name;
    private final String description;
    private final Character enemy;
    private final Character character;

    public Sea() {
        this.name = "Lakes Of Darya";
        this.enemy = null;
        this.quest = new noQuest();
        this.character = new Siren();
        this.description = "You arrive at the Lakes of Darya, however the once glittering waters are muddy and dirty, you wonder what could have caused such a tragedy";
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