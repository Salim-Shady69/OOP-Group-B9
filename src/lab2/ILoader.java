package lab2;
import lab1.Vehicle;

public interface ILoader {

    void load(Loadable vehicle);
    void unload(Loadable vehicle);
    void unloadLast();
    void checkCargo();
}
