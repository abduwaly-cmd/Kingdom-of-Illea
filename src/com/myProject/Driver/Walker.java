package com.myProject.Driver;

import com.myProject.Location.Location;

import java.util.Random;

public class Walker implements Runnable {
    Random rd = new Random();
    Player player;
    boolean foundLoc;
    int nextLocPos = -1;
    Location loc;
    String[] positions = new String[] { "North", "East", "West", "South"};

    public Walker(Player player) {
        this.player = player;
        this.foundLoc = false;
        if(this.player.getLocation().getNextLocs().length == 1) nextLocPos = rd.nextInt(3);
        Thread t = new Thread(this);
        t.start();
    }


    public Location getLoc() { return loc; }
    public boolean isFoundLoc() { return foundLoc; }

    public void update(String[] str) {
        if(nextLocPos != -1  && str[3].equals(positions[nextLocPos])) {
            foundLoc = true;
            loc = this.player.getLocation().getNextLocs()[0];
        } else {
            if(str[2].equals("Left")) {
                foundLoc = true;
                loc = this.player.getLocation().getNextLocs()[0];
            } else if(str[2].equals("Right")) {
                foundLoc = true;
                loc = this.player.getLocation().getNextLocs()[0];
            }
        }
    }
    @Override
    public void run() {
        while(!foundLoc) { }
    }
}
