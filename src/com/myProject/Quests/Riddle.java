package com.myProject.Quests;

import com.myProject.Quests.questState.*;

public class Riddle extends Quest {
    public Riddle() {
        super("Riddle");
        String ans = "human";
        String riddle = "What goes on four legs in the morning, on two legs at noon, and on three legs in the evening?";
        setNextState(new riddleState(riddle, ans));
    }

    @Override
    public void setDone() {
        super.setDone();
        System.out.println();
    }
}
