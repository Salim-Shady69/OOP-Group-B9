package lab2;

import lab1.*;

import java.util.List;

public class CarTransport extends FlakFordon implements Loadable {

    private List<LoadableObject> cargo;

    public void init() {
        flak = new Flak(30000, 1);
    }

    public boolean isLoadable() {
        return getFlakAngle() == 0;
    }

    public void load(LoadableObject object) {

    }
    public void unload(LoadableObject object){
        unload(1);
    }

    public void unload(int amount) {

    }

    public void checkCargo() {

    }

    /*
    public class Bilverkstad {

        Cartransport billager;

        billager.unload(kjawdjka);

        billager.load(adbwke);

     */

}

