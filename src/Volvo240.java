import java.awt.*;

public class Volvo240 extends Car {

    public final static double trimFactor = 1.25;

    public Volvo240(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "src.vehicle.Volvo240";
        stopEngine();
    }

    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    // Math.min ensures that currentSpeed cannot reach above enginePower
    protected void incrementSpeed(double amount) {
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    // Math.max ensures that currentSpeed cannot reach below 0
    protected void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }


}
