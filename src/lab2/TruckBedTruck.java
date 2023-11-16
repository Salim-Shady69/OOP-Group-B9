package lab2;
import lab1.*;

public class TruckBedTruck extends Vehicle {
    
    private int currentAngle;
    private int maxAngle;
    private int maxLoadWeight;
    private int currentLoadWeight;

    public TruckBedTruck(int maxLoadWeight, int maxAngle) {
        this.currentAngle = 0;
        this.maxLoadWeight = maxLoadWeight;
        this.maxAngle = maxAngle;
    }

    public boolean isTruckBedSecured() {
        return getCurrentAngle() == 0;
    }


    public boolean isNotMoving() {
        return currentSpeed == 0;
    }

    @Override
    public void move(){
        if (isTruckBedSecured())
            super.move();
    }

    public int getCurrentAngle() {
        return currentAngle;
    }

    public int getMaxLoadWeight() {
        return maxLoadWeight;
    }

    public int getCurrentLoadWeight() {return currentLoadWeight;}

    public void modifyCurrentWeight(int currentWeight){
        this.currentLoadWeight += currentWeight;
    }

    public void raiseTruckBed(boolean complete) {
        if (isNotMoving()) currentAngle = maxAngle;
    }

    public void raiseTruckBed(int angle){
        if (currentAngle + angle > maxAngle)
            currentAngle = maxAngle;
        else
            currentAngle += angle;
    }

    public void lowerTruckBed(boolean complete) {
        currentAngle = 0;
    }

    public void lowerTruckBed(int angle) {
        if (currentAngle - angle < 0)
            currentAngle = 0;
        else
            currentAngle -= angle;
    }
}
