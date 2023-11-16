package lab2;

import java.util.LinkedList;

public class LoadCarrier<T> {
    private LinkedList<T> cargo = new LinkedList<>();

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


    // A loader helper that does the loading functions per request of the cargo-holder
}