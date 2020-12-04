package com.myProject.playerCommands;

import com.myProject.Driver.Console;
import com.myProject.Driver.Player;

public class pickUpCommand implements Command {
    @Override
    public void execute(Console console, Player player, String act) { }

    @Override
    public void execute(Console console, Player player, String itemName, String[] in) {
        player.getLocation().takeItem(player, itemName);
    }

    @Override
    public void undo() { }
}
