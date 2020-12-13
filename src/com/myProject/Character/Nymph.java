package com.myProject.Character;

import com.myProject.Items.*;

import java.util.LinkedList;
import java.util.Queue;

public class Nymph extends Character {

    public Nymph() {
        super("Pherousa", "Nymph");

        Queue<Item> items = new LinkedList<>();
            items.add(new EarthSphere());
        setItems(items);

        Queue<String> speech = new LinkedList<>();
            speech.add("Hello, my name is " + getName() + "." +
                    "\n\t\tYou are here for the earth sphere I presume."
                    + "\n Only the brightes of minds can control the earth sphere" +
                    "\n\t\tTherefor in order to obtain the earth sphere you must " +
                    "\n\t\tsolve the following riddle…\n" +
                    "\nType [start] to initiate mission");
            speech.add("Correct!" +
                    "\nType [take sphere] to obtain " + getItem() + " and add it to your inventory!");
            speech.add("Good luck young prince for oyu are embaring on a most dangerous journey....");
        setSpeech(speech);
    }

}
