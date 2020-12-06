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
        speech.add("Welcome to the Lakes of Darya. My name is Railira." +
                "\nI've heard you are seeking the ater sphere young prince." +
                "\nUnder normal circumstances I would not entertain such a request. "
                + "But as you can see our lake is not at it it's best condition as of late." +
                "\n…Fortunately for you I am in need of assistance, in exchange for your help I will give you the water sphere\n"
                + "There are ingredients by the shore that will help you in preparing a potion that will cleanse our lake, make the potion accurately and I will grant you that which you seek\n" +
                "\nType [start] to initiate mission");
        speech.add("Correct!" +
                "\nType [take sphere] to obtain " + getItem() + " and add it to your inventory!");
        speech.add("Thanks for your help mate :)");
    setSpeech(speech);
}
}
