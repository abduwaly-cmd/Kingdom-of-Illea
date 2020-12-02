package com.myProject.playerCommands;

import com.myProject.Main.Console;
import com.myProject.Main.Player;

public class ControlPanel {
	Command last;
	Command[] slots;

	public ControlPanel(Command[] slots){
		this.slots = slots;
	}
  
	public void execute(int i, Console console, Player player, String act) {
		slots[i].execute(console, player, act);
		last = slots[i];
	}
	
	void undo() {
		last.undo();
	}
}
