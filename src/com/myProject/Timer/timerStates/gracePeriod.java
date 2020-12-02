package com.myProject.Timer.timerStates;

import com.myProject.Timer.Counter;

public class gracePeriod implements State {

    @Override
    public void prev(Counter timer) { }

    @Override
    public void next(Counter timer) {
        if(!timer.isTimeUp()) timer.setState(new mapClosed());
        else {
            timer.setRunning(true);
            timer.setState(new timeUp());
        }
    }

    @Override
    public void printStatus() {
        System.out.print("Time is up... You have 10 seconds to hide map contents before you get caught!");
    }
}
