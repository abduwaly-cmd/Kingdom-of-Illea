package com.myProject.Quests;

import java.util.Arrays;
import java.util.List;

public class Maze extends Quest {
    public Maze() {
        super("Maze");
        //The correct solutions on solving the maze
        String [] solution1 = {"Straight", "Left", "Right", "Straight", "Right", "Left"};
        String [] solution2 = {"Straight", "Right", "Left", "Straight", "Left" ,"Right"};

        //Storing them in a list so we can compare it to the user input
        List<String> list1 = Arrays.asList(solution1);
        List<String> list2 = Arrays.asList(solution2);
    }
}
