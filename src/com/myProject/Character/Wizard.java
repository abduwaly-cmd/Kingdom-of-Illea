 package com.myProject.Character;

import com.myProject.Items.Amulet;
import com.myProject.Items.Item;

import java.util.LinkedList;
import java.util.Queue;

public class Wizard extends Character {
    Queue<String> speech = new LinkedList<>();

    public Wizard() {
        super("Gwydion", "Wizard");

        Queue<Item> items = new LinkedList<>();
            items.add(new Amulet());
        setItems(items);

        speech.add("Chrom! Sir, please help for there is a threat against the kingdom of Illea." +
                    "\n\t\tA new evil has risen and he goes by the name Valadar. He is trying to resurrect" +
                    "\n\t\tthe great beast Typhon! You must collect all 5 magical spheres in order to save the Kingdom!" +
                    "\n\t\tMy prince, here is an amulet to store the spheres in."+
                    "\nType [take amulet] to take it...");
        speech.add("Great, now that you have it!You must hurry and find the first sphere (Earth Sphere) which" +
                    "\n\t\tis located in the Nidale Forest with the Nymphs...");
        setSpeech(speech);
    }
}
