package lab2;

import lab1.Vehicle;

public class AutomotiveWorkshop<T extends Vehicle>{
    private final LoadCarrier<T> loadCarrier;

    public AutomotiveWorkshop() {
        loadCarrier = new LoadCarrier<>();
    }

    public void add(T vehicle){
        loadCarrier.load(vehicle);
    }
}

