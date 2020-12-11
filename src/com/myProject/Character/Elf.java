package com.myProject.Character;

import com.myProject.Items.AirSphere;
import com.myProject.Items.Item;
import com.myProject.Items.LifeSphere;

import java.util.LinkedList;
import java.util.Queue;

public class Elf extends Character {
    public Elf() {
        super("Ysildea", "Elf");

        Queue<Item> items = new LinkedList<>();
        items.add(new LifeSphere());
        setItems(items);

        Queue<String> speech = new LinkedList<>();
        speech.add("Hello, my name is " + getName() + "." +
                "\n\t\tI heard that you are searching for the 5 spheres to defeat Valadar and Typhon... Am I right? " +
                "\n\t\tIt is the most powerful sphere out of them all... " +
                "\n\t\tPerhaps a creating a healing potion will help me " +
                "\n\t\tdecide whether or not your worthy of the sphere." +
                "\nType [make healing potion] to create the healing potion...");
        speech.add("well, you have proven yourself so here is the sphere. Use your new powers wisely." +
                "\nType [take sphere] to obtain " + getItem() + " and add it to your inventory!");
        speech.add("It was nice meeting you young prince. I wish all the best in your future endeavors.");

        setSpeech(speech);
    }
}

