package com.myProject.Character;

import com.myProject.Driver.Player;
import com.myProject.Items.Item;

import java.util.Queue;

public class Character {
    private int health;
    private int iHealth;
    private Queue<Item> items;
    private Queue<String> speech;
    private final String name;
    private final String race;

    public Character(String name, String race) {
        this.name = name;
        this.race = race;
        this.health = 100;
        this.iHealth = health;
    }

    public Character(String name, String race, int health) {
        this.name = name;
        this.race = race;
        this.health = health;
        this.iHealth = health;
    }

    // The character gives up its item and adds it to the player
    public boolean giveItem(Player player, String itemName) {
        if(this.items.element().toString().toLowerCase().contains(itemName)) {
            player.addItem(this.items.remove());
            return true;
        }
        return false;
    }

    // Getters
    public Item getItem() { return this.items.element(); }
    public String speak() { return (!speech.isEmpty()) ? this.name + ": " + speech.remove() : null; }
    public String getRace() { return this.race; }
    public String getName() { return this.name; }
    public boolean isCanNotSpeak() { return this.speech.isEmpty(); }
    public synchronized int getHealth() { return this.health; }

    // Setters
    public void setItems(Queue<Item> items) { this.items = items; }
    public synchronized void resetHealth() { this.health = this.iHealth; }
    public void setSpeech(Queue<String> speech) { this.speech = speech; }
    public synchronized void setHealth(int n) {
        this.health += n;
        if(this.health < 0) this.health = 0;
        System.out.println("> " + name + " has been hit " + n + " [" + health + "]");
    }

    @Override
    public String toString() { return name; }
}
