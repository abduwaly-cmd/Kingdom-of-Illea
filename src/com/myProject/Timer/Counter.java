package com.myProject.Timer;

import com.myProject.Timer.timerStates.*;

public class Counter implements Runnable {
    private int sSec;
    private int seconds;
    private State state;
    private Thread thread;
    private boolean running;

    Counter(int seconds) {
        this.sSec = this.seconds = seconds;
        this.state = new defaultTimerState();
        this.thread = new Thread(this);
        this.running = true;
        this.thread.start();
    }

    public void setRunning(boolean running) { this.running = running; }
    public boolean isRunning() { return this.running; }
    public synchronized void setSeconds(int n) {
        this.sSec = this.seconds = n;
    }
    public synchronized boolean isTimeUp() { return this.seconds < 0; }

    public void nextState() { state.next(this); }
    public void printStatus() { state.printStatus(); }
    public void setState(State state) { this.state = state;}

    @Override
    public void run() {
        while (running) {
            while (this.seconds >= 0 && running) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.seconds -= 1;
                if (seconds % 60 == 0 && this.sSec / 60 != 0)
                    System.out.print("\n" + (this.sSec / 60 - seconds / 60) + " minutes passed, you have " + seconds / 60 + " left...\n> ");
            }
            nextState();
            printStatus();
        }
    }
}