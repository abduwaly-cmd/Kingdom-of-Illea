package com.myProject.Timer.timerStates;

import com.myProject.Timer.Counter;

public interface State {
    public void prev(Counter timer);
    public void next(Counter timer);
    public void printStatus();
}