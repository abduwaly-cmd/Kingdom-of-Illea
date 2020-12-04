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
                    "\n\t\tthe evil Typhon! You must collect all 5 spheres in order to save the Kingdom!" +
                    "\nType [yes] to help...");
            speech.add("My prince, here is an amulet to store the spheres in." +
                    "\nType [take] to take it...");
            speech.add("Great, now that you have it! I think we better go over to the Nymphs and see whats going on...");
            speech.add("Oh there the Nymphs are lets see what they're up to...");
        setSpeech(speech);
    }

    @Override
    public String talk(String[] in) {
        if(in == null) return super.talk(null);
        else if(in[0].equals("yes")) {
            nextSpeech();
            return talk(in);
        } else
            return "Oh... Thats a bummer :/";
    }

}
