package lab2;

import java.awt.*;

public class Scania extends FlakFordon {
    
    public Scania() {
        nrDoors = 2;
        enginePower = 420;
        color = Color.darkGray;
        modelName = "Scania";
        weight = 14000;
        flak = new Flak(18000, 70);
    }
}
