import java.awt.*;

public class Volvo240 extends Vehicle {

    public final static double trimFactor = 1.25;

    public Volvo240(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "src.vehicle.Volvo240";
        stopEngine();
    }

    @Override
    public double speedFactor(){
        return enginePower * trimFactor * 0.01;
    }



}
