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
    private final Character enemy;
    private boolean attacking;
    private final Random rd = new Random();

    public fightState(Character enemy) {
        this.enemy = enemy;
        this.attacking = false;
    }

    @Override
    public void next(Quest quest, Player player, String[] str) throws InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException {
        if(str[0].equals("socket")) {
            if(player.getHealth() > 0 && enemy.getHealth() > 0) {
                int damage = (rd.nextInt(10));
                if (str[4].equals("Retreating") && !prevAttack.equals(str[4])) {
                    player.setHealth(-(int) (damage * player.getVulnerability()));
                } else if (str[4].equals("Swinging") && !prevAttack.equals(str[4])) {
                    new SoundPlayer("Sword", false);
                    enemy.setHealth(-(int) ((damage + 10) * player.getStrength()));
                } else if (!prevAttack.equals(str[4])) {
                    if (!attacking) {
                        player.setHealth(-(int) (damage * player.getVulnerability()));
                    } else if (player.getHealth() < 100) {
                        player.setHealth(1);
                    }
                    attacking = rd.nextBoolean();
                }
                prevAttack = str[4];
            }
            if(player.getHealth() > 0 && enemy.getHealth() <= 0) {
                // player won
                System.out.println(">> You defeated " + enemy);
                player.getLocation().setQuestDone();
                player.switchConsoleToTerminal();
            } else if (player.getHealth() <= 0 && enemy.getHealth() > 0) {
                //player died
                System.out.println(">> " + enemy + " defeated you!");
                enemy.resetHealth();
                quest.setActive(false);
                quest.setState(new defaultState());
                System.out.println("> You have been resurrected");
                player.setHealth(100);
                player.switchConsoleToTerminal();
                System.out.println("> Type [start] to try Again");
            }
        } else if (str[0].equals("aight")) {
            if(enemy.getName().contains("Typhon")) player.getSoundPlayer().change("Typhon");
            player.switchConsoleToSocket();
        } else System.out.println("> Invalid input :/");
        Thread.sleep(100);
    }

    @Override
    public void printStatus() {
        System.out.println("Prepare to fight by swinging your phone!");
        System.out.println("If you'd like to use any of your items now is your chance! (the command is [inv]");
        System.out.println("Type [aight] when ready!");
    }
}
