package com.myProject.Driver;


import com.myProject.Observer.*;
import com.myProject.Driver.inputStrategies.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Scanner;

public class Console extends ConcreteSubject implements Runnable {

    private Thread thread;
    private boolean running;
    private socketInput socketIn;
    private inputStream inputStream;
    private terminalInput terminalIn;
    private static Scanner in = null;

    Console() {
        in =  new Scanner(System.in);
        this.terminalIn = new terminalInput(in);
        this.inputStream = this.terminalIn;
        this.thread = new Thread(this);
        this.running = true;
        this.thread.start();
    }

    public synchronized void switchTerminaltoSocketInput() { this.inputStream = this.socketIn; }
    public synchronized void switchSockettoTerminalInput() { this.inputStream = this.terminalIn; }
    public synchronized void setSocket(String host, int port) { this.socketIn = new socketInput(host, port); }

//    private synchronized void setConsoleStatus(boolean status) { this.running = status; }
//    private synchronized boolean getConsoleStatus() { return this.running; }

    @Override
    public void run() {
        while(running) {
            try {
                notifyObservers(inputStream.getInput());
            } catch (InterruptedException | LineUnavailableException | IOException | UnsupportedAudioFileException e) {
                e.printStackTrace();
            }
        }
    }
}
