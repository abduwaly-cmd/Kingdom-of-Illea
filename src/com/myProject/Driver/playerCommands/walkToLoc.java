package com.myProject.Driver.playerCommands;

import com.myProject.Location.Location;
import com.myProject.Driver.Console;
import com.myProject.Driver.Player;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class walkToLoc implements Command {
    @Override
    public void execute(Console console, Player player, String[] act) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if(player.getLocation().isObjDone()) {
            Location nextLoc = player.getMap().next(act[1]);
            if (nextLoc.toString().toLowerCase().contains("forest")) nextLoc.switchInstance();
            else if (nextLoc.toString().toLowerCase().contains("demon") && player.getTime() > 300) nextLoc.switchInstance();
            player.setLocation(nextLoc, player.getMap().getNext());
        } else System.out.println("You didnt achieve the required objectives in this location");
    }

    @Override
    public void undo() { }
}
