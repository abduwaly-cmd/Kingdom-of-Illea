package com.myProject.Items.potionTemplates;

import com.myProject.Items.itemStrategy.healingPotionUse;

public class healingPotion extends Potions {

    public healingPotion() {
        super("Healing Potion", new healingPotionUse());
    }

    @Override
    protected void opt() {

    }

    @Override
    protected void stir() {

    }

    @Override
    protected void add() {

    }
}
