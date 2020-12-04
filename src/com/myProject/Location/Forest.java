package com.myProject.Location;

import com.myProject.Character.Character;
import com.myProject.Location.forestStrategies.dayForest;
import com.myProject.Location.forestStrategies.nightForest;

import java.util.ArrayList;

public class Forest extends Location {
	private Location instance;

	public Forest() {
		super(new dayForest());
	}

	@Override
	public void switchInstance() {
		if(super.toString().toLowerCase().contains("night")) switchInstance(new dayForest());
		else switchInstance(new nightForest());
	}

}
