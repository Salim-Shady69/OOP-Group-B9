package lab2;

import lab1.Vehicle;

import java.util.ArrayList;

public class Loader {
    private ArrayList<Loadable> cargo = new ArrayList<>(20); // Loading capacity 20 vehicles

    public void load(Loadable vehicle){
        cargo.add((vehicle));
    }

    public void unload(Loadable vehicle){
        cargo.remove(vehicle);
    }

    public void unloadLast() {
        cargo.removeLast();
    }

    public ArrayList<Loadable> getCargo(){
        return cargo;
    }

    public void checkCargo(){
        for (Loadable v : cargo){
            System.out.println(v.getModelName());
        }
    }
    // A loader helper that does the loading functions per request of the cargo-holder
}