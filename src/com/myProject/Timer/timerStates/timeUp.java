package com.myProject.Timer.timerStates;

import com.myProject.Timer.Counter;

public class timeUp implements State {
    public timeUp() {
        printStatus();
        System.exit(1);
    }

    @Override
    public void prev(Counter context) { }

    @Override
    public void next(Counter context) { }

    @Override
    public void printStatus() {
        System.out.println("You have been caught and Marauder's map has been confiscated...");
    }
}
