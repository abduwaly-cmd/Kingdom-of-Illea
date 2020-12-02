package com.myProject.playerCommands;

import com.myProject.Main.Console;
import com.myProject.Main.Player;

public interface Command {
   void execute(Console console, Player player, String act);
   void undo();
}
