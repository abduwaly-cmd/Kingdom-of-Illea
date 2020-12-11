package com.myProject.Location.locationStrategies;

import com.myProject.Character.Character;
import com.myProject.Character.Pixie;
import com.myProject.Character.Troll;
import com.myProject.Character.Typhon;
import com.myProject.Quests.Fight;
import com.myProject.Quests.Quest;
import com.myProject.Quests.Riddle;

public class DemonKingdomT implements LocInstance {

    private final Quest quest;
    private final String name;
    private final String description;
    private final String soundFile;
    private final Character enemy;
    private final Character character;

    public DemonKingdomT() {
        this.name = "The Dooms of Valm";
        this.enemy = new Typhon();
        this.quest = new Fight(enemy);
        this.soundFile = "Demon Kingdom";
        this.character = null;
        this.description = "You are too late! Validar has resurrected Typhon; " +
                "\ntherefore, you must only fight Typhon in order to save the kingdom." +
                "\nMake sure to use shield and Healing Potion if your health is low.." +
                "\nType [start] to fight Typhon.";
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
