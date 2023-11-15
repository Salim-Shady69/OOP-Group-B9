package lab2;
import lab1.Position;

import java.awt.*;

public class CarTransport extends FlakFordon implements ILoader {

    private Loader loaderHelper = new Loader();
    private int maxUnitWeight;

    public CarTransport() {
        nrDoors = 2;
        enginePower = 700;
        color = Color.darkGray;
        modelName = "Scania T144";
        weight = 14000;
        flak = new Flak(30000, 1);
        maxUnitWeight = 3000;
    }


    public boolean isLoadable() {
        return getFlakAngle() == 0;
    }

    private boolean checkWeightOfLoad(IsLoadable vehicle){
        return (vehicle.getWeight() + flak.getCurrentWeight() <= flak.getMaxWeight() && vehicle.getWeight() <= maxUnitWeight);
    }

    private boolean checkDistanceToLoad(IsLoadable vehicle){
        return getPosition().absDistance(vehicle.getPosition()) <= 5.0;
    }

    public void load(IsLoadable vehicle) {
        if (isNotMoving() && checkWeightOfLoad(vehicle) && checkDistanceToLoad(vehicle)) {
            flak.raiseFlak(true);
            flak.modifyCurrentWeight(vehicle.getWeight());
            loaderHelper.load(vehicle);
            flak.lowerFlak(true);
        }
    }

    public void unload(IsLoadable vehicle) {
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
        for (IsLoadable v : loaderHelper.getCargo()){
            v.getPosition().setX(newPosition.getX());
            v.getPosition().setY(newPosition.getY());
            v.setDirection(newDirection);
        }
    }
}

