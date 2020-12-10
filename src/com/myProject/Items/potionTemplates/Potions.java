package com.myProject.Items.potionTemplates;

import com.myProject.Items.Item;
import com.myProject.Items.itemStrategy.itemUse;

public abstract class Potions extends Item {

    public Potions(String name, itemUse use) {
        super(name, use);
        preparePotion();
    }

    final void preparePotion() {
        add();
        stir();
        heat();
        opt();
    }

    protected void heat() {
        System.out.println("Heat at high temperature.");
    }

    protected void opt() { System.out.println("Place the potion in a vile."); }

    protected abstract void stir();

    protected abstract void add();
}
