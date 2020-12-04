package com.myProject.Location.forestStrategies;

import com.myProject.Character.Character;
import com.myProject.Quests.Quest;

import java.util.ArrayList;

public interface LocInstance {
    public Quest getQuest();
    public String getName();
    public String getDescription();
    public Character getEnemy();
    public ArrayList<Character> getCharacters();
}
