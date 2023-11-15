package lab2;

import lab1.Vehicle;

public interface Loadable {

    void load(LoadableObject object);

    void unload(LoadableObject object);

    void checkCargo();

}
