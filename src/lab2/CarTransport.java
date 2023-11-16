package lab2;
import lab1.Position;

import java.awt.*;

public class CarTransport extends TruckBedTruck implements ILoader {

    private final LoadCarrier<Loadable> loadCarrier = new LoadCarrier<>();
    private final int maxUnitWeight;
    private final int maxNumOfUnits;

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
        return getCurrentAngle() == 1 && isNotMoving();
    }

    private boolean checkLoadRestrictions(Loadable vehicle){
        return (vehicle.getWeight() + getCurrentLoadWeight() <= getMaxLoadWeight() && vehicle.getWeight() <= maxUnitWeight && loadCarrier.sizeOfCargo() < maxNumOfUnits);
    }

    private boolean checkDistanceToLoad(Loadable vehicle){
        return getPosition().absDistance(vehicle.getPosition()) <= 5.0;
    }

    public void load(Loadable vehicle) throws LoaderException {
        if (isLoadable() && checkLoadRestrictions(vehicle) && checkDistanceToLoad(vehicle)) {
            loadCarrier.load(vehicle);
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

    @Override
    public void turnLeft(){
        super.turnLeft();
        int newDirection = getDirection();
        for (Loadable v : loadCarrier.getCargo()){
            v.setDirection(newDirection);
        }
    }

    @Override
    public void turnRight(){
        super.turnRight();
        int newDirection = getDirection();
        for (Loadable v : loadCarrier.getCargo()){
            v.setDirection(newDirection);
        }
    }
}

