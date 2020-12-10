package com.myProject.Driver.playerCommands;

import com.myProject.Driver.Player;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class useItemCommand implements Command {
    @Override
    public void execute(Player player, String[] act) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        if(act.length>=2) player.useItem(act[1]);
    }

    @Override
    public void undo() {

    }
}
