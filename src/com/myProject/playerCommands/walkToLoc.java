package com.myProject.playerCommands;

import com.myProject.Location.Location;
import com.myProject.Driver.Console;
import com.myProject.Driver.Player;

public class walkToLoc implements Command {
    @Override
    public void execute(Console console, Player player, String act) {
        Location nextLoc = player.getMap().next(act);
        if(nextLoc.toString().toLowerCase().contains("forest")) nextLoc.switchInstance();
        player.setLocation(nextLoc, player.getMap().getNext());
    }

    @Override
    public void execute(Console console, Player player, String act, String[] in) { }

    @Override
    public void undo() { }
}
