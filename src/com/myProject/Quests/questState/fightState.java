package com.myProject.Quests.questState;

import com.myProject.Character.Character;
import com.myProject.Driver.Player;
import com.myProject.Driver.SoundPlayer;
import com.myProject.Quests.Quest;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Random;

public class fightState implements State {
    private String prevAttack = "";
    private Character enemy;
    private boolean attacking;
    private Random rd = new Random();

    public fightState(Character enemy) {
        this.enemy = enemy;
        this.attacking = false;
    }

    @Override
    public void next(Quest quest, Player player, String[] str) throws InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException {
        if(str[0].equals("socket")) {
            if(player.getHealth() > 0 && enemy.getHealth() > 0) {
                int damage = (rd.nextInt(10));
                if ((str[4].equals("Retreating") || (str[4].equals("Stationary")) && !prevAttack.equals(str[4])) ) {
                    player.setHealth(player.getHealth() - (int) (damage * player.getVulnerability()));
                    System.out.println(enemy + " hit you -" + damage + " [" + player.getHealth() + "]");
                } else if (str[4].equals("Swinging") && !prevAttack.equals(str[4])) {
                    enemy.setHealth(enemy.getHealth() - (int) ((damage + 10) * player.getStrength()));
                    new SoundPlayer("Sword", false);
                    System.out.println("You hit " + enemy + " -" + damage + " [" + enemy.getHealth() + "]");
                } else if (!prevAttack.equals(str[4]) && player.getHealth()<100) {
                    player.setHealth(player.getHealth() + 1);
                    System.out.println("You healed +1 [" + player.getHealth() + "]");
                }
                prevAttack = str[4];
            }
            if(player.getHealth() > 0 && enemy.getHealth() <= 0) {
                //player won
                player.getLocation().setQuestDone();
                player.switchConsoleToTerminal();
            } else if (player.getHealth() <= 0 && enemy.getHealth() > 0) {
                //player died
                quest.setActive(false);
                System.out.println("You Lost to " + enemy);
                quest.setState(new defaultState());
                System.out.println("Type [start] to try Again");
                player.setHealth(100);
                player.switchConsoleToTerminal();
            }
        } else {
            player.switchConsoleToSocket();
        }
        Thread.sleep(100);
    }

    @Override
    public void printStatus() {
        System.out.println("Prepare to fight by swinging your phone!");
        System.out.println("make sure to also use any item you want :)");
        System.out.println("Type [aight] when ready!");
    }
}
