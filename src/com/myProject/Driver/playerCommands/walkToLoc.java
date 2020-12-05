package com.myProject.Driver.playerCommands;

import com.myProject.Location.Location;
import com.myProject.Driver.Console;
import com.myProject.Driver.Player;

public class walkToLoc implements Command {
    @Override
    public void execute(Console console, Player player, String[] act) {
        if(player.getLocation().isObjDone()) {
            Location nextLoc = player.getMap().next(act[1]);
            if (nextLoc.toString().toLowerCase().contains("forest")) nextLoc.switchInstance();
            if (nextLoc.toString().toLowerCase().contains("demon"))
                if(player.getTime() > 300) nextLoc.switchInstance();
            player.setLocation(nextLoc, player.getMap().getNext());
        } else System.out.println("You didnt achieve the required objectives in this location");
    }

    @Override
    public void undo() { }
}
