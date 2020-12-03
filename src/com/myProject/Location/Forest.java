package com.myProject.Location;

import com.myProject.Character.Character;
import com.myProject.Location.forestStates.dayForest;

import java.util.ArrayList;

public class Forest extends Location {
	private ArrayList<Character> characters = new ArrayList<Character>();
	private Location instance;

	public Forest() {
		super(new dayForest());
		this.instance = new dayForest();
	}
}
