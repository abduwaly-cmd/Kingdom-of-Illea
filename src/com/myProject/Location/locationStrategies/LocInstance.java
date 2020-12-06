package com.myProject.Location.locationStrategies;

import com.myProject.Character.Character;
import com.myProject.Quests.Quest;

public interface LocInstance {
    public Quest getQuest();
    public String getName();
    public String getDescription();
    public String getSoundFile();
    public Character getEnemy();
    public Character getCharacter();
}
