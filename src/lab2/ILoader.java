package lab2;

public interface ILoader {

    void load(IsLoadable vehicle);
    void unload(IsLoadable vehicle);
    void unloadLast();
    void checkCargo();
}
