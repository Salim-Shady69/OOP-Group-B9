package lab2;

import lab1.Vehicle;

public class AutomotiveWorkshop<T extends Vehicle>{
    private final LoadCarrier<T> loadCarrier;

    public AutomotiveWorkshop(int maxUnits) {
        loadCarrier = new LoadCarrier<>(maxUnits);
    }
    public AutomotiveWorkshop() {
        loadCarrier = new LoadCarrier<>();
    }

    public void add(T vehicle) throws LoaderException {
        if (loadCarrier.sizeOfCargo() < loadCarrier.getMaxUnits())
            loadCarrier.load(vehicle);
        else
            throw new LoaderException("Workshop is full");
    }

    public T checkOut(T vehicle) throws LoaderException {
        return (loadCarrier.unload(vehicle));
    }
}

