package com.myProject.Items;

import com.myProject.Driver.Player;
import com.myProject.Items.itemStrategy.*;
import com.myProject.Items.itemStrategy.itemUse;

public class Item {
    private itemUse use;
    private String name;

    Item(String name) {
        this.use = new defaultUse();
        this.name = name;
    }

    public Item(String name, itemUse use) {
        this.use = use;
        this.name = name;
    }

    public String getName() { return name; }

    public void use(Player player) { use.use(player); }

    public void setName(String name) { this.name = name; }

    @Override
    public String toString() { return name; }
}
