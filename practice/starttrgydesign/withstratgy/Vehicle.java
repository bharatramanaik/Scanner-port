package starttrgydesign.withstratgy;

import starttrgydesign.withstratgy.stratgy.DriveStrtergy;

public class Vehicle {
    DriveStrtergy driveStrtergy;
    public Vehicle (DriveStrtergy driveStrtergy){
        this.driveStrtergy = driveStrtergy;
    }

    public void drive(){
        driveStrtergy.drive();
    }
}
