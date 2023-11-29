package lab2;
import lab1.Vehicle;

public abstract class Truck extends Vehicle {

    Truckbed truckbed;

    public Truck(int maxLoadWeight, int maxAngle) {
        truckbed = new Truckbed(maxLoadWeight, maxAngle);
    }

    public boolean isNotMoving() {
        return currentSpeed == 0;
    }

    @Override
    public void move(){
        if (truckbed.isTruckBedSecured())
            super.move();
    }

    public void modifyCurrentWeight(int currentWeight){
        truckbed.modifyCurrentWeight(currentWeight);
    }

    public void raiseTruckBed() {
        if (isNotMoving())
            truckbed.raiseTruckBed();
    }

    public void lowerTruckBed(boolean complete) {
        if (isNotMoving())
            truckbed.lowerTruckBed();
    }

}
