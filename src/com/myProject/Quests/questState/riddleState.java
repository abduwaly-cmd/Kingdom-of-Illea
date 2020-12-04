package com.myProject.Quests.questState;

import com.myProject.Driver.Player;
import com.myProject.Quests.Quest;

public class riddleState implements State {
    private String ans;
    private String riddle;

    public riddleState(String ans, String riddle) {
        this.ans = ans;
        this.riddle = riddle;
        printStatus();
    }

    @Override
    public void next(Quest quest) { }

    @Override
    public void next(Quest quest, Player player, String[] str) {
        if(str[0].equals(this.ans)) player.getLocation().setQuestDone("Nymph");
        else System.out.println("wrong answer, try again...");
    }

    @Override
    public void printStatus() {
        System.out.println(riddle);
    }
}
