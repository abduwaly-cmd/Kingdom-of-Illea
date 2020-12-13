package com.myProject.Items.potionTemplates;

import com.myProject.Items.itemStrategy.cleansingPotionUse;

public class cleansingPotion extends Potions{

    public cleansingPotion() {
        super("Cleansing Potion", new cleansingPotionUse());
    }

    @Override
    protected void stir() {
        System.out.println("Stir three times clockwise.");
    }

    @Override
    protected void add() {
        System.out.println("Add tears of a siren, detol, and half a cup clorox.");
    }
}
