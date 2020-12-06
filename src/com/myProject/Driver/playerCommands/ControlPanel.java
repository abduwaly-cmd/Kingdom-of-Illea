package com.myProject.Driver.playerCommands;

import com.myProject.Driver.Console;
import com.myProject.Driver.Player;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class ControlPanel {
	Command last;
	Command[] slots;

	public ControlPanel(Command[] slots) { this.slots = slots; }
  
	public void execute(int i, Player player, String[] act) throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException {
		slots[i].execute(player, act);
		last = slots[i];
	}

	void undo() { last.undo(); }
}
