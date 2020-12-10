package com.myProject.Location.locationStrategies;

import com.myProject.Quests.Fight;
import com.myProject.Quests.Quest;
import com.myProject.Quests.Riddle;
import com.myProject.Character.*;
import com.myProject.Character.Character;

public class nightForest implements LocInstance {

    private final Quest quest;
    private final String name;
    private final String description;
    private final String soundFile;
    private final Character enemy;
    private final Character character;

    public nightForest() {
        this.name = "Niadale Forest (Night)";
        this.enemy = new Troll();
        this.quest = new Fight(enemy);
        this.soundFile = "Nidala Forest (Night)";
        this.character = new Pixie();
        this.description = " I’m a bit tired. I think it’s time for me to hit the hay and continue" +
                "\nlooking for the spheres at the crack of dawn. I’ll take shelter by that tree." +
                "\n\n\t\t\t--- goes to sleep ---" +
                "\n\n*SHOUTING NEARBY* HELP! HELP! THE PIXIES ARE UNDER ATTACK!" +
                "\nType [start] to help the pixies...";
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
