package lab2;
import lab1.Vehicle;

public interface ILoader {

    void load(Vehicle vehicle);
    void unload(Vehicle vehicle);
    void unloadLast();
    void checkCargo();
}
