package com.myProject.Items.itemStrategy;

import com.myProject.Driver.Player;

public class shieldUse implements itemUse, Runnable {
    private Thread thread;
    private Player player;

    @Override
    public void use(Player player) {
        this.player = player;
        this.player.setVulnerability(0.4);
        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public void run() {
        System.out.println("Shield Activated, u r safe :)");
        try {
            thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Shield Deactivated, u r safe :)");
        this.player.setVulnerability(1.0);
    }
}
