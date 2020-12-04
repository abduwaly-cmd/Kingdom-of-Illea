package com.myProject.Location;

import com.myProject.Location.locationStrategies.*;

public class DemonKingdom extends Location {

    public DemonKingdom() { super(new DemonKingdomV()); }

    @Override
    public void switchInstance() {
        super.switchInstance(new DemonKingdomT());
    }

}
