package com.myProject.Timer.timerStates;

import com.myProject.Timer.Counter;

public class defaultTimerState implements State {
    @Override
    public void prev(Counter timer) { }

    @Override
    public void printStatus() { }

    @Override
    public void next(Counter timer) { }
}
