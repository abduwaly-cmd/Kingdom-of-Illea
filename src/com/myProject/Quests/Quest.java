package com.myProject.Quests;

import com.myProject.Driver.Player;
import com.myProject.Quests.questState.State;
import com.myProject.Quests.questState.defaultState;
import com.myProject.Quests.questState.doneState;

public class Quest {
    private State next;
    private State state;
    private String name;
    private boolean done;
    private boolean active;

    public Quest(String name) {
        this.name = name;
        this.done = false;
        this.state = new defaultState();
    }

    public State getState() { return this.state; }
    public State getNextState() { return this.next; }
    public boolean isDone() { return done; }
    public boolean isActive() { return active; }

    public void printStatus() { state.printStatus(); }
    public void setState(State state) { this.state = state; }
    public void setNextState(State state) { this.next = state; }
    public void nextState(Player player, String[] in) throws InterruptedException { state.next(this, player, in);}
    public void setActive(boolean state) { this.active = state; }

    public void setDone() {
        this.done = true;
        this.active = false;
        this.setState(new doneState());
    }
}
