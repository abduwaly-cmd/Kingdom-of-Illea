package com.myProject.playerCommands;

import com.myProject.Location.Location;
import com.myProject.Driver.Console;
import com.myProject.Driver.Player;
import com.myProject.Driver.*;

public class walkToLoc implements Command {
    @Override
    public void execute(Console console, Player player, String act) {
        Location nextLoc = player.getMap().next(act);
        System.out.println("walked from " + player.getLocation() + " to " + nextLoc);
        //if(nextLoc.equals(Forest)) nextLoc.switchInstance();
        player.setLocation(nextLoc, player.getMap().getNext());
    }

    @Override
    public void undo() { }
}
