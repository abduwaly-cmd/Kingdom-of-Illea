package com.myProject.Character;

import java.util.LinkedList;
import java.util.Queue;

import com.myProject.Items.AirSphere;
import com.myProject.Items.Item;

public class Dwarf extends Character {
	public Dwarf() {
        super("Agir", "Dwarf");

        Queue<Item> items = new LinkedList<>();
            items.add(new AirSphere());
        setItems(items);

        Queue<String> speech = new LinkedList<>();
            speech.add("Hello, my name is " + getName() + "." +
                    "\n\t\tNot many humans have made it this far into the mountain before,"
                    +"\n\t\tI am most impressed with your quick wit and strength, and for that I present you with the Air sphere" +
                    "\n\t\tMay it guide and protect you on your perilous journey" +
                    "\nType [take sphere] to obtain " + getItem() + " and add it to your inventory!");
            speech.add("Good luck young prince....");
        setSpeech(speech);
    }
}
