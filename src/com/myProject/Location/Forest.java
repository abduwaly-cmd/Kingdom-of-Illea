package com.myProject.Location;

import com.myProject.Location.locationStrategies.dayForest;
import com.myProject.Location.locationStrategies.nightForest;

public class Forest extends Location {

	public Forest() { super(new nightForest()); }

	@Override
	public void switchInstance() {
		if(super.toString().toLowerCase().contains("night")) super.switchInstance(new dayForest());
		else super.switchInstance(new nightForest());
	}

}
