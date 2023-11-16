package lab2;

public interface ILoader {

    void load(Loadable vehicle);
    Loadable unload(Loadable vehicle) throws LoaderException;
    Loadable unload();
    void checkCargo();
}
