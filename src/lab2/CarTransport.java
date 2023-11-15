package lab2;
import lab1.Position;
import lab1.Vehicle;

import java.awt.*;

public class CarTransport extends FlakFordon implements ILoader {

    private Loader loaderHelper = new Loader();

    public CarTransport() {
        nrDoors = 2;
        enginePower = 530;
        color = Color.darkGray;
        modelName = "Scania T144";
        weight = 14000;
        flak = new Flak(30000, 1);
    }


    public boolean isLoadable() {
        return getFlakAngle() == 0;
    }

    public void load(Loadable vehicle) {
        if (!(vehicle instanceof CarTransport)) {
            if (isNotMoving()) {
                if (vehicle.getWeight() + flak.getCurrentWeight() <= flak.getMaxWeight()) {
                    if (getPosition().absDistance(vehicle.getPosition()) <= 5.0) {
                        flak.raiseFlak(true);
                        flak.modifyCurrentWeight(vehicle.getWeight());
                        loaderHelper.load(vehicle);
                        flak.lowerFlak(true);
                    }
                }
            }
        }
    }

    public void unload(Loadable vehicle) {
        unloadLast();
    }

    public void unloadLast() {
        flak.raiseFlak(true);
        //flak.modifyCurrentWeight(-vehicle.getWeight());)
        loaderHelper.unloadLast();

        flak.lowerFlak(true);
    }

    public void checkCargo() {

    }
    @Override
    public void move(){
        super.move();
        Position newPosition = getPosition();
        int newDirection = getDirection();
        for (Loadable v : loaderHelper.getCargo()){
            v.getPosition().setX(newPosition.getX());
            v.getPosition().setY(newPosition.getY());
            v.setDirection(newDirection);
        }
    }
}

