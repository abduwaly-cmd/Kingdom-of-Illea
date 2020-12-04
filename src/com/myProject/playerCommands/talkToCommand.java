package com.myProject.playerCommands;

import com.myProject.Driver.Console;
import com.myProject.Driver.Player;

public class talkToCommand implements Command {
    @Override
    public void execute(Console console, Player player, String[] act) {
        player.getLocation().talk(act[1]);
    }

    @Override
    public void undo() { }
}
