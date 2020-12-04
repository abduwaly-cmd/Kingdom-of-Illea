package com.myProject.playerCommands;

import com.myProject.Driver.Console;
import com.myProject.Driver.Player;

public class talkToCommand implements Command {
    @Override
    public void execute(Console console, Player player, String act) { }

    @Override
    public void execute(Console console, Player player, String act, String[] in) {
        player.getLocation().talk(act, in);
    }

    @Override
    public void undo() {

    }
}
