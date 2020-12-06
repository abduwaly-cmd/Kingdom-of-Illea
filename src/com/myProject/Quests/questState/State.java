package com.myProject.Quests.questState;

import com.myProject.Driver.Player;
import com.myProject.Quests.Quest;

public interface State {
    public void next(Quest quest, Player player, String[] str) throws InterruptedException;
    public void printStatus();
}