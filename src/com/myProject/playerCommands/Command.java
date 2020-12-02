package com.myProject.playerCommands;

import com.hogwarts.Location;
import com.hogwarts.spellInterfaces.spellAct;
import com.myProject.Main.Console;
import com.myProject.Main.Player;

public interface Command {
   public void execute(Console console, Player player, String act);
   void undo();
}
