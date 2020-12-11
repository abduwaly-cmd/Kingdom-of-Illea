package com.myProject.Location.locationStrategies;

import com.myProject.Character.Character;
import com.myProject.Quests.Quest;

public interface LocInstance {
    Quest getQuest();
    String getName();
    String getDescription();
    String getSoundFile();
    Character getEnemy();
    Character getCharacter();
}
