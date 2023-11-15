package lab2;

import java.util.ArrayList;

public class Loader {
    private ArrayList<IsLoadable> cargo = new ArrayList<>(20); // Loading capacity 20 vehicles

    public void load(IsLoadable vehicle){
        cargo.add((vehicle));
    }

    public void unload(IsLoadable vehicle){
        cargo.remove(vehicle);
    }

    public void unloadLast() {
        cargo.removeLast();
    }

    public ArrayList<IsLoadable> getCargo(){
        return cargo;
    }

    public void checkCargo(){
        for (IsLoadable v : cargo){
            System.out.println(v.getModelName());
        }
    }
    // A loader helper that does the loading functions per request of the cargo-holder
}