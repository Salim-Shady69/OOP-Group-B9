package lab2;

import java.util.LinkedList;

public class LoadCarrier {
    private LinkedList<Loadable> cargo = new LinkedList<>();

    public void load(Loadable vehicle){
        cargo.add((vehicle));
    }

    public Loadable unload(int index){
        return cargo.remove(index);
    }

    public Loadable unloadLast() {
        return cargo.removeLast();
    }

    public LinkedList<Loadable> getCargo(){
        return cargo;
    }

    public void checkCargo(){
        for (Loadable v : cargo){
            System.out.println(v.getModelName());
        }
    }
    // A loader helper that does the loading functions per request of the cargo-holder
}