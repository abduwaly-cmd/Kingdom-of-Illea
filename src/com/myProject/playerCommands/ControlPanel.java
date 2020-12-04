package com.myProject.playerCommands;

import com.myProject.Driver.Console;
import com.myProject.Driver.Player;

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

	public void execute(int i, Console console, Player player, String act, String[] in) {
		slots[i].execute(console, player, act, in);
		last = slots[i];
	}
	
	void undo() {
		last.undo();
	}
}
