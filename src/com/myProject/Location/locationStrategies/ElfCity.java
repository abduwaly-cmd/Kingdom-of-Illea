package com.myProject.Location.locationStrategies;

import com.myProject.Character.Character;
import com.myProject.Character.Elf;
import com.myProject.Character.Wizard;
import com.myProject.Quests.Quest;
import com.myProject.Quests.noQuest;

public class ElfCity implements LocInstance {
    private final Quest quest;
    private final String name;
    private final String description;
    private final String soundFile;
    private final Character enemy;
    private final Character character;

    public ElfCity() {
        this.name = "Erilea Kingdom";
        this.enemy = null;
        this.quest = new noQuest();
        this.soundFile = "Erilia Kingdom";
        this.character = new Elf();
        this.description = "The Erilia kingdom is full of glittering monuments and crystal buildings, "
        		+"\nhowever as you approach the you are stopped by its residents the elves! " +
                "\nIt seems they are not happy with your presence in their kingdom "
                + "\nThe Elves would like to talk to you...";
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
