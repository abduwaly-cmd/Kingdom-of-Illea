package com.myProject.Character;

import java.util.LinkedList;
import java.util.Queue;

import com.myProject.Items.EarthSphere;
import com.myProject.Items.Item;
import com.myProject.Items.WaterSphere;

public class Siren extends Character {
     public Siren() {
        super("Railira", "Siren");

        Queue<Item> items = new LinkedList<>();
            items.add(new WaterSphere());
        setItems(items);

        Queue<String> speech = new LinkedList<>();
            speech.add("Hello, my name is " + getName() + "." +
                    "\n\t\tI've heard you are seeking the water sphere young prince." +
                    "\n\t\tUnder normal circumstances I would not entertain such a request. " +
                    "\n\t\tBut as you can see our lake is not at it it's best condition as of late..." +
                    "\n\t\tFortunately for you I am in need of assistance, in exchange for your help " +
                    "\n\t\tI will give you the water sphere. There are ingredients by the shore that " +
                    "\n\t\twill help you in preparing a potion that will cleanse our lake," +
                    "\n\t\tmake the potion accurately and I will grant you that which you seek" +
                    "\nType [make cleansing potion] to initiate mission");
            speech.add("Please use the potion to cleanse the Lakes of Darya" +
                    "\nType [use cleansing potion] to cleanse the Lake");
            speech.add("Thank you so much kind prince! Here is the " + getItem() + " as a token of our appreciation" +
                    "\nType [take sphere] to obtain " + getItem() + " and add it to your inventory!");
            speech.add("Thanks for your help mate :)");
        setSpeech(speech);
    }
}
