package lab2;

public class Flak {

    private int currentAngle;
    private int maxAngle;
    private int maxWeight;
    private int currentWeight;


    public Flak(int maxWeight, int maxAngle) {
        this.currentAngle = 0;
        this.maxWeight = maxWeight;
        this.maxAngle = maxAngle;
    }

    public int getCurrentAngle() {
        return currentAngle;
    }


    public int getMaxWeight() {
        return maxWeight;
    }

    public int getCurrentWeight() {return currentWeight;}

    public void modifyCurrentWeight(int currentWeight){
        this.currentWeight += currentWeight;
    }


    public void raiseFlak(boolean complete) {
        currentAngle = maxAngle;
    }

    public void raiseFlak(int angle){
        if (currentAngle + angle > maxAngle)
            currentAngle = maxAngle;
        else
            currentAngle += angle;
    }

    public void lowerFlak(boolean complete) {
        currentAngle = 0;
    }

    public void lowerFlak(int angle) {
        if (currentAngle - angle < 0)
            currentAngle = 0;
        else
            currentAngle -= angle;
    }

}
