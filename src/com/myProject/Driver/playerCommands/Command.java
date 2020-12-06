package com.myProject.Driver.playerCommands;

import com.myProject.Driver.Console;
import com.myProject.Driver.Player;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public interface Command {
   void execute(Player player, String[] act) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException;
   void undo();
}
