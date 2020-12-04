package com.myProject.Quests.questState;

import com.myProject.Driver.Player;
import com.myProject.Quests.Quest;

public class defaultState implements State {
    @Override
    public void next(Quest quest) { }

    @Override
    public void next(Quest quest, Player player, String[] str) {
        quest.setActive(true);
        quest.setState(quest.getNextState());
        quest.getState().printStatus();
    }

    @Override
    public void printStatus() {

    }
}
