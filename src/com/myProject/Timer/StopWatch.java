package com.myProject.Timer;

public class StopWatch implements Runnable {
    private int seconds;
    private Thread thread;
    private boolean running;

    public StopWatch() {
        this.thread = new Thread(this);
        this.seconds = 0;
        this.running = true;
        this.thread.start();
    }

    public int getSeconds() { return (seconds/60); }
    public void setSeconds(int seconds) { this.seconds = seconds; }

    @Override
    public void run() {
        while(running) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.seconds += 1;
        }
    }
}
