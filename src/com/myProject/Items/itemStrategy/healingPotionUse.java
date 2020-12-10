package com.myProject.Items.itemStrategy;

import com.myProject.Driver.Player;

public class healingPotionUse implements itemUse {

    @Override
    public void use(Player player) {
        player.setHealth(100);
    }
}
