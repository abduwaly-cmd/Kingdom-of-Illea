package com.myProject.Character;

import com.myProject.Items.*;

import java.util.LinkedList;
import java.util.Queue;

public class Nymph extends Character {

    public Nymph() {
        super("Pherousa", "Nymph");

        Queue<Item> items = new LinkedList<>();
            items.add( new EarthSphere());
        setItems(items);

        Queue<String> speech = new LinkedList<>();
            speech.add("Welcome to the Nidale Forest. My name is Pherousa." +
                    "\nYou are here for the earth sphere I presume." +
                    "\nIn order to attain the earth sphere you must " +
                    "\nsolve the following riddle…\n" +
                    "\nType [start] to initiate mission");
            speech.add("Correct!" +
                    "\nType [take] to obtain " + getItem() + " and add it to your inventory!");
            speech.add("Thanks for your help mate :)");
        setSpeech(speech);

    }

}
