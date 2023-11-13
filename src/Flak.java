public class Flak {

    private int tippingAngle;
    private int maxWeight;
    private int currentWeight;


    public Flak(int maxWeight) {
        this.tippingAngle = 0;
        this.maxWeight = maxWeight;
    }

    public int getTippingAngle() {
        return tippingAngle;
    }

    public void setTippingAngle(int tippingAngle) {
        this.tippingAngle = tippingAngle;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public int getCurrentWeight() {return currentWeight;}

    public void setCurrentWeight(int currentWeight){
        this.currentWeight = currentWeight;
    }




    public void raiseFlak() {
    }

    public void lowerFlak() {}

}
