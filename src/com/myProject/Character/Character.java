package com.myProject.Character;

import com.myProject.Driver.Player;
import com.myProject.Items.Item;

import java.util.Queue;

public class Character {
    private int health;
    private Queue<Item> items;
    private Queue<String> speech;
    private final String name;
    private final String race;
    private boolean canSpeak;

    public Character(String name, String race) {
        this.name = name;
        this.race = race;
        this.health = 100;
        this.canSpeak = true;
    }

    public String speek() { return (!speech.isEmpty()) ? this.name + ": " + speech.remove() : null; }
    public String talk(String[] in) { return (!speech.isEmpty()) ? this.name + ": " + speech.element() : null; }

    public boolean isLocked() { return this.canSpeak; }

    public void giveItem(Player player) { player.addItem(this.items.remove()); }
    public void setItems(Queue<Item> items) { this.items = items; }

    public void setSpeech(Queue<String> speech) { this.speech = speech; }
    public void nextSpeech() { this.speech.remove(); }
    public Item getItem() { return this.items.element(); }

    public String  getRace() { return this.race; }


    @Override
    public String toString() { return name; }

}
