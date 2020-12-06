package com.myProject.Character;

import java.util.LinkedList;
import java.util.Queue;

import com.myProject.Items.AirSphere;
import com.myProject.Items.EarthSphere;
import com.myProject.Items.Item;

public class Dwarf extends Character {
	public Dwarf() {
        super("Agir", "Dwarf");

        Queue<Item> items = new LinkedList<>();
            items.add(new AirSphere());
        setItems(items);

        Queue<String> speech = new LinkedList<>();
            speech.add("Welcome to Mount Daein traveller," +
                    "\nFor your quick wit and strength I present you with the Air sphere" +
                    "\nMay it guide and protect you on your perilous journey");
                    "\nType [take sphere] to obtain " + getItem() + " and add it to your inventory!");
            speech.add("Thank you for your help young prince....");
        setSpeech(speech);
    }
}
