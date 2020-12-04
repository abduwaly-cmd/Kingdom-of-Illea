package com.myProject.Quests.questState;

import com.myProject.Driver.Player;
import com.myProject.Quests.Quest;

public class riddleState implements State {
    private String ans;
    private String riddle;

    public riddleState(String riddle, String ans) {
        this.ans = ans;
        this.riddle = riddle;
    }

    @Override
    public void next(Quest quest) { }

    @Override
    public void next(Quest quest, Player player, String[] str) {
        if(str[0].equals(this.ans)) player.getLocation().setQuestDone("nymph");
        else System.out.println("wrong answer, try again...");
    }

    @Override
    public void printStatus() {
        System.out.println(riddle);
    }
}
