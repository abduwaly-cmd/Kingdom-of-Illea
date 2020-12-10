package com.myProject.Quests;

import com.myProject.Driver.Player;
import com.myProject.Quests.questState.mazeState;

import java.util.LinkedList;
import java.util.Queue;

public class Maze extends Quest {
    public Maze() {
        super("Maze");
        // The correct solutions on solving the maze
        Queue<String> path = new LinkedList<>();
            path.add("Up");
            path.add("Left");
            path.add("Right");
            path.add("Up");
            path.add("Right");
            path.add("Left");

        setNextState(new mazeState(path));
    }

    @Override
    public void nextState(Player player, String[] in) throws InterruptedException {
        super.nextState(player, in);
    }
}
