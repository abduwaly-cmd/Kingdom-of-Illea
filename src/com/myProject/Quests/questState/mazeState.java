package com.myProject.Quests.questState;

import com.myProject.Driver.Player;
import com.myProject.Quests.Quest;

import java.util.Queue;

public class mazeState implements State {
    private Queue<String> path1;
    private Queue<String> path2;

//    String [] solution1 = {"Straight", "Left", "Right", "Straight", "Right", "Left"};
//    String [] solution2 = {"Straight", "Right", "Left", "Straight", "Left" ,"Right"};

    // Straight ->
    // Left     ->
    // Right    ->

    @Override
    public void next(Quest quest, Player player, String[] str) {
        if(!str[0].equals("socket")) player.switchConsoleToSocket();
        else {

        }
    }

    @Override
    public void printStatus() { System.out.println("Follow the dwarf through this maze to catch him!"); }
}
