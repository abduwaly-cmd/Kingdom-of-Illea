package com.myProject.Timer.timerStates;

import com.myProject.Timer.Counter;

public class mapClosed implements State {
    public mapClosed() {
        printStatus();
        System.exit(1);
    }

    @Override
    public void prev(Counter context) { }

    @Override
    public void next(Counter context) { }

    @Override
    public void printStatus() {
        System.out.println("Hiding map contents...end.");
    }
}
