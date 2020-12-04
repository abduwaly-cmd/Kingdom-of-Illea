package com.myProject.Location;

import com.myProject.Location.locationStrategies.dayForest;
import com.myProject.Location.locationStrategies.nightForest;

public class Forest extends Location {

	public Forest() {
		super(new dayForest());
	}

	@Override
	public void switchInstance() {
		if(super.toString().toLowerCase().contains("night")) switchInstance(new dayForest());
		else switchInstance(new nightForest());
	}

}
