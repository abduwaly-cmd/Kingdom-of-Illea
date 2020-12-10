package com.myProject.Items.potionTemplates;

import com.myProject.Items.itemStrategy.healingPotionUse;

public class healingPotion extends Potions {

    public healingPotion() {
        super("Healing Potion", new healingPotionUse());
    }

    @Override
    protected void stir() {
        System.out.println("Stir three times anticlockwise.");
    }

    @Override
    protected void add() {
        System.out.println("Add fluxweed, cherries, and half a cup watermelon juice.");
    }
}
