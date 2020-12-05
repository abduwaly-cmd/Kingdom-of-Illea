package com.myProject.Driver.playerCommands;

import com.myProject.Driver.Console;
import com.myProject.Driver.Player;

public class pickUpCommand implements Command {
    @Override
    public void execute(Console console, Player player, String[] in) {
        player.getLocation().takeItem(player, in[1]);
    }

    @Override
    public void undo() { }
}
