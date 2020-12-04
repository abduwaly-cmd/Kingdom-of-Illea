package com.myProject.Character;

import com.myProject.Items.*;
import com.myProject.Items.Item;

import java.util.LinkedList;
import java.util.Queue;

public class Pixie extends Character {

    public Pixie() {
        super("Asteria", "Pixie");

        Queue<Item> items = new LinkedList<>();
            items.add(new Rope());
            items.add(new FireSphere());
        setItems(items);

        Queue<String> speech = new LinkedList<>();
            speech.add("Oh thank you! Thank you so so so much!" +
                    "\nMy name is Asteria and for your bravery and" +
                    "\ncourage I shall grant you the Fire Sphere." +
                    "\nType [take] to pick up the Fire Sphere...\n");
        setSpeech(speech);

    }

}
