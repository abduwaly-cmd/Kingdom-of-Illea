package com.myProject.Location.locationStrategies;

import com.myProject.Character.Character;
import com.myProject.Character.Pixie;
import com.myProject.Character.Troll;
import com.myProject.Character.Validar;
import com.myProject.Quests.Fight;
import com.myProject.Quests.Quest;
import com.myProject.Quests.Riddle;

public class DemonKingdomV implements LocInstance {

    private final Quest quest;
    private final String name;
    private final String description;
    private final String soundFile;
    private final Character enemy;
    private final Character character;

    public DemonKingdomV() {
        this.name = "The Dooms of Valm";
        this.enemy = new Validar();
        this.quest = new Fight(enemy);
        this.soundFile = "Demon Kingdom";
        this.character = null;
        this.description = "You have made it in time for Validar has not resurrected Typhon yet; " +
                "\ntherefore, you must only fight one of them and save the kingdom." +
                "\nType [start] to fight Validar.";
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
