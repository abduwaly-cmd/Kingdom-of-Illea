package com.myProject.Quests.questState;

import com.myProject.Driver.Player;
import com.myProject.Quests.Quest;

public interface State {
    public void next(Quest quest);
    public void next(Quest quest, Player player, String[] str);
    public void printStatus();
}