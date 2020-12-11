package com.myProject.Driver.playerCommands;

import com.myProject.Driver.Player;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Random;

public class walkToLoc implements Command {
    String pos = "";
    String[] positions = new String[] {"North", "East", "South", "West"};

    @Override
    public void execute(Player player, String[] str) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if(player.getLocation().isObjDone() && str[0].equals("socket")) {
            if(player.getLocation().getNextLocs().length == 1) player.walk(str[3], pos);
            else player.walk(str[2], null);
        } else if(!player.getLocation().isObjDone()) System.out.println("> You didnt achieve the required objectives in this location");
        else {
            player.getSoundPlayer().change("Steps on Leaves");
            this.pos = getRandom(positions);
            player.switchConsoleToSocket();
        }
    }

    public static String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    @Override
    public void undo() { }
}
