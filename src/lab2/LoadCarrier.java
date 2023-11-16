package lab2;

import java.util.LinkedList;

public class LoadCarrier<T> {
    private final LinkedList<T> cargo = new LinkedList<>();

    public void load(T vehicle){
        cargo.add((vehicle));
    }

    public T unload(int index){
        return cargo.remove(index);
    }

    public T unloadLast() {
        return cargo.removeLast();
    }

    public LinkedList<T> getCargo(){
        return cargo;
    }

    public int sizeOfCargo(){
        return cargo.size();
    }

    // A loader helper that does the loading functions per request of the cargo-holder
}