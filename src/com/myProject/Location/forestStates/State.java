package com.myProject.Location.forestStates;

import com.myProject.Driver.Player;
import com.myProject.Location.Location;

public interface State {
    public void next(Player player);
    public void prev();
    public void printStatus();
}