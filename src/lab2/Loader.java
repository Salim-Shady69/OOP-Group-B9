package lab2;

import lab1.Vehicle;

import java.util.ArrayList;

public class Loader {
    private ArrayList<Vehicle> cargo = new ArrayList<>(20); // Loading capacity 20 vehicles

    public void load(Vehicle vehicle){
        cargo.add((vehicle));
    }

    public void unload(Vehicle vehicle){
        cargo.remove(vehicle);
    }

    public void unloadLast() {
        cargo.removeLast();
    }

    public ArrayList<Vehicle> getCargo(){
        return cargo;
    }

    public void checkCargo(){
        for (Vehicle v : cargo){
            System.out.println(v.getModelName());
        }
    }
    // A loader helper that does the loading functions per request of the cargo-holder
}