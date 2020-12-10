package com.myProject.Quests;

import com.myProject.Quests.questState.fightState;
import com.myProject.Character.Character;

public class Fight extends Quest {
    public Fight(Character enemy) {
        super("Fight");
        setNextState(new fightState(enemy));
    }
}
