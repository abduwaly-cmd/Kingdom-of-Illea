package com.myProject.Driver.playerCommands;

import com.myProject.Driver.Console;
import com.myProject.Driver.Player;

public class startQuest implements Command {
    @Override
    public void execute(Console console, Player player, String[] in) {
        player.getLocation().getQuest().nextState(player, in);
    }

    @Override
    public void undo() { }
}
