package com.myProject.Driver.playerCommands;

import com.myProject.Driver.Player;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class startQuest implements Command {
    @Override
    public void execute(Player player, String[] in) throws InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException {
        player.getLocation().getQuest().nextState(player, in);
    }

    @Override
    public void undo() { }
}
