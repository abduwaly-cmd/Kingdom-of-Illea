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
                    "\n\t\tYou are here for the earth sphere I presume." +
                    "\n\t\tIn order to attain the earth sphere you must " +
                    "\n\t\tsolve the following riddle…\n" +
                    "\nType [start] to initiate mission");
            speech.add("Correct!" +
                    "\nType [take sphere] to obtain " + getItem() + " and add it to your inventory!");
            speech.add("Thank you for your help young prince....");
        setSpeech(speech);
    }

}
