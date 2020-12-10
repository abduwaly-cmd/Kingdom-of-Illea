package com.myProject.Character;

import com.myProject.Items.*;
import com.myProject.Items.Item;

import java.util.LinkedList;
import java.util.Queue;

public class Pixie extends Character {
    public Pixie() {
        super("Asteria", "Pixie");

        Queue<Item> items = new LinkedList<>();
            items.add(new FireSphere());
        setItems(items);

        Queue<String> speech = new LinkedList<>();
            speech.add("Oh thank you! Thank you so so so much!" +
                    "\n\t\tMy name is " + getName() + " and for your bravery and" +
                    "\n\t\tcourage I shall grant you the Fire Sphere." +
                    "\nType [take sphere] to pick up the Fire Sphere...");
            speech.add("Again, we cannot stress enough how thankful we are for" +
                    "\n\t\tgracing us with your bravery and saving us..." +
                    "\n\t\tBest of luck in your future adventures :)");
        setSpeech(speech);

    }
}
