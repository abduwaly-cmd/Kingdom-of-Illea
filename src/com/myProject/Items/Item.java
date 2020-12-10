package com.myProject.Items;

import com.myProject.Driver.Player;
import com.myProject.Items.itemStrategy.itemUse;

public class Item {
    private String name;
    private itemUse use;
    Item(String name) { this.name = name; }
    Item(String name, itemUse use) {
        this.use = use;
        this.name = name;
    }
    public void use(Player player) { use.use(player); }
    public String getName() { return name; }

    @Override
    public String toString() { return name; }
}
