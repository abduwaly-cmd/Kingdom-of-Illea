package com.myProject.playerCommands;

import com.myProject.Location.Location;
import com.myProject.Main.Console;
import com.myProject.Main.Player;

public class walkToLoc implements Command {
    @Override
    public void execute(Console console, Player player, String act) {
        Location nextLoc = player.getMap().next(act);
        System.out.println("walked from " + player.getLocation() + " to " + nextLoc);
    }

    @Override
    public void undo() { }
}
