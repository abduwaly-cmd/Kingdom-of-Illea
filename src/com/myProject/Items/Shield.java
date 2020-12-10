package com.myProject.Items;

import com.myProject.Items.itemStrategy.*;

public class Shield extends Item {
    public Shield() {
        super("Shield", new shieldUse());
    }
}
