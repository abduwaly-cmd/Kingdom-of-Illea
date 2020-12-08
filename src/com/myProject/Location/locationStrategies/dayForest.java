package com.myProject.Location.locationStrategies;

import com.myProject.Character.Nymph;
import com.myProject.Character.Character;
import com.myProject.Quests.Quest;
import com.myProject.Quests.Riddle;

public class dayForest implements LocInstance {
    private final Quest quest;
    private final String name;
    private final String description;
    private final String soundFile;
    private final Character enemy;
    private final Character character;

    public dayForest() {
        this.name = "Niadale Forest (Day)";
        this.enemy = null;
        this.quest = new Riddle();
        this.soundFile = "Nidala Forest (Day)";
        this.description = "The Nymphs are approaching...";
        // this.character.add(new Wizard());
        this.character = new Nymph();
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
