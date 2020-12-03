package com.myProject.Location.forestStates;

import java.util.ArrayList;

public abstract class LocInstance {
    private String name;
    private String description;
    private boolean objectiveAchieved;
    private ArrayList<Character> characters;

    public String getName() { return name; }
    public String getDescription() { return description; }
    public ArrayList<Character> getCharacters() { return characters; }
    public boolean isObjectiveAchieved() { return objectiveAchieved; }
}
