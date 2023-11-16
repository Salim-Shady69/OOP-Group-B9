package lab2;
import lab1.Position;

import java.awt.*;

public class CarTransport extends TruckBedTruck implements ILoader {

    private LoadCarrier loadCarrier = new LoadCarrier();
    private int maxUnitWeight;
    private int maxNumOfUnits;

    public CarTransport() {
        super(30000, 1);
        nrDoors = 2;
        enginePower = 700;
        color = Color.darkGray;
        modelName = "Scania T144";
        weight = 14000;
        maxUnitWeight = 3000;
        maxNumOfUnits = 12;
    }


    public boolean isLoadable() {
        return getCurrentAngle() == 0;
    }

    private boolean checkWeightOfLoad(Loadable vehicle){
        return (vehicle.getWeight() + getCurrentLoadWeight() <= getMaxLoadWeight() && vehicle.getWeight() <= maxUnitWeight);
    }

    private boolean checkDistanceToLoad(Loadable vehicle){
        return getPosition().absDistance(vehicle.getPosition()) <= 5.0;
    }

    public void load(Loadable vehicle) {
        if (isNotMoving() && checkWeightOfLoad(vehicle) && checkDistanceToLoad(vehicle)) {
            raiseTruckBed(true);
            modifyCurrentWeight(vehicle.getWeight());
            loadCarrier.load(vehicle);
            lowerTruckBed(true);
        }
    }

    public Loadable unload(Loadable vehicle) throws LoaderException {
        throw new LoaderException("Unsupported unload");
    }

    public Loadable unload() {
        raiseTruckBed(true);
        //modifyCurrentWeight(-vehicle.getWeight());)
        lowerTruckBed(true);
        return loadCarrier.unloadLast();
    }

    public void checkCargo() {

    }
    @Override
    public void move(){
        super.move();
        Position newPosition = getPosition();
        int newDirection = getDirection();
        for (Loadable v : loadCarrier.getCargo()){
            v.getPosition().setX(newPosition.getX());
            v.getPosition().setY(newPosition.getY());
            v.setDirection(newDirection);
        }
    }
}

