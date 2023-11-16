package lab2;
import lab1.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCarTransport {

    private CarTransport carTransport;
    private Volvo240 volvo;
    private Saab95 saab;

    @Before
    public void init() {
        carTransport = new CarTransport();
        volvo = new Volvo240();
        saab = new Saab95();
    }

    @Test
    public void testUnloadVehicle(){

    }

    @Test
    public void testLoadVehicle(){
        carTransport.stopEngine();
        carTransport.raiseTruckBed(true);
    }

    @Test
    public void testPositionChangeSame() throws LoaderException {
        Volvo240 volvo = new Volvo240();
        carTransport.load(volvo);
        carTransport.startEngine();
        carTransport.move();

        Position transportPos = carTransport.getPosition();
        Position carPos = volvo.getPosition();

        assertTrue(((transportPos.getX() == carPos.getX()) && (transportPos.getY() == carPos.getY())));
    }

    @Test
    public void testLoadIncorrectVehicle() throws LoaderException {
        CarTransport secondTransport = new CarTransport();
        Volvo240 volvo = new Volvo240();
        //carTransport.load(secondTransport);
        assertThrows(LoaderException.class, ()->{carTransport.load(volvo);});

    }

    @Test
    public void testUnloadVehicle() throws LoaderException {
        Volvo240 volvo = new Volvo240();
        Saab95 saab = new Saab95();
        carTransport.raiseTruckBed(true);
        carTransport.load(volvo);
        carTransport.load(saab);
        Loadable unloaded = carTransport.unload();
        assertTrue(unloaded.equals(saab) && carTransport.getLoadCarrier().sizeOfCargo() == 1);

    }




}

