package com.myProject.Items.itemStrategy;

import com.myProject.Driver.Player;

public class cleansingPotionUse implements itemUse {

    @Override
    public void use(Player player) {
        System.out.println("You cleansed the " + player.getLocation());
        player.getLocation().talk();
    }
}