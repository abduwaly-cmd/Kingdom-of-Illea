package com.myProject.Quests;

import com.myProject.Quests.questState.mazeState;

import java.util.LinkedList;
import java.util.Queue;

public class Maze extends Quest {
    public Maze() {
        super("Maze");
        //The correct solutions on solving the maze
        Queue<String> path = new LinkedList<>();
            path.add("Straight");
            path.add("Left");
            path.add("Right");
            path.add("Straight");
            path.add("Right");
            path.add("Left");

        setNextState(new mazeState(path));
    }
}
