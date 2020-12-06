package com.myProject.Driver.playerCommands;

import com.myProject.Driver.Player;

public class talkToCommand implements Command {
    @Override
    public void execute(Player player, String[] act) {
        player.getLocation().talk(act[1]);
    }

    @Override
    public void undo() { }
}
