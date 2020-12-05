package com.myProject.Driver.playerCommands;

import com.myProject.Driver.Console;
import com.myProject.Driver.Player;

public interface Command {
   void execute(Console console, Player player, String[] act);
   void undo();
}
