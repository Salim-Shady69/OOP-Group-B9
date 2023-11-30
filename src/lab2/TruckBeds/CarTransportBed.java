package lab2.TruckBeds;

public class CarTransportBed extends AbstractBed {

    private int currentAngle;

    public CarTransportBed(int maxLoadWeight) {
        this.maxLoadWeight = maxLoadWeight;
        currentAngle = 0;
    }

    public void raiseTruckBed() {
        currentAngle = 1;
    }

    public void lowerTruckBed() {
        currentAngle = 0;
    }

    public int getCurrentAngle() {
        return currentAngle;
    }
}
