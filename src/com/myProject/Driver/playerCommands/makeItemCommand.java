package com.myProject.Driver.playerCommands;

import com.myProject.Driver.Player;
import com.myProject.Items.potionTemplates.cleansingPotion;
import com.myProject.Items.potionTemplates.healingPotion;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class makeItemCommand implements Command {
    @Override
    public void execute(Player player, String[] act) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        if(act[1].equals("healing potion")) {
            player.addItem(new healingPotion());
            player.getLocation().talk();
        }
        else if(act[1].equals("cleansing potion")){
            player.addItem(new cleansingPotion());
            player.getLocation().talk();
        }
    }

    @Override
    public void undo() { }
}
