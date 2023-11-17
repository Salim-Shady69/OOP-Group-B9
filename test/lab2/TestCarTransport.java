package lab2;
import lab1.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestCarTransport {

    public CarTransport carTransport;

    @Before
    public void init() {carTransport = new CarTransport(30000, 12);}

    @Test
    public void testUnloadEmptyLast() throws LoaderException {
        assertThrows(LoaderException.class, ()->{carTransport.unload();});
    }

    @Test
    public void testLoadVehicle() throws LoaderException{
        Volvo240 volvo = new Volvo240();
        carTransport.raiseTruckBed(true);
        carTransport.load(volvo);
        assertTrue(carTransport.getLoadCarrier().getCargo().contains(volvo));
    }

    @Test
    public void testCargoDirection() throws LoaderException {
        Volvo240 karusellEnjoyer = new Volvo240();
        carTransport.raiseTruckBed(true);
        carTransport.load(karusellEnjoyer);
        for (int i = 0; i < 17; i++)
            carTransport.turnLeft();
        carTransport.turnRight();
        assertEquals(carTransport.getDirection(), karusellEnjoyer.getDirection());
    }

    @Test
    public void testLoadFarAway() throws LoaderException {
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();
        Saab95 noWheels = new Saab95();
        saab.turnRight();
        volvo.turnLeft();

        for (int i = 0; i < 10; i++) {
            saab.gas(1);
            volvo.gas(0.5);
            saab.move();
            volvo.move();
        } //Now they should be godtyckligt far away for testing purposes

        carTransport.raiseTruckBed(true);
        carTransport.load(noWheels);
        assertThrows(LoaderException.class, ()->{carTransport.load(saab);});
        assertThrows(LoaderException.class, ()->{carTransport.load(volvo);});
    }

    @Test
    public void testMoveWhenRaised(){
        Position initialPos = carTransport.getPosition();
        carTransport.startEngine();
        carTransport.raiseTruckBed(true);
        carTransport.move();
        assertEquals(initialPos, carTransport.getPosition());
    }

    @Test
    public void testLoadWithSpeed() throws LoaderException {
        Saab95 saab = new Saab95();
        carTransport.raiseTruckBed(1);
        carTransport.startEngine();
        assertThrows(LoaderException.class,()->{carTransport.load(saab);});
    }

    @Test
    public void testPositionChangeSame() throws LoaderException {
        Volvo240 volvo = new Volvo240();
        carTransport.raiseTruckBed(10);
        carTransport.load(volvo);
        carTransport.lowerTruckBed(10);
        carTransport.startEngine();
        for (int i = 0; i < 11; i++) {
           carTransport.move();
        }

        Position transportPos = carTransport.getPosition();
        Position carPos = volvo.getPosition();

        assertTrue(((transportPos.getX() == carPos.getX()) && (transportPos.getY() == carPos.getY())));
    }

    @Test
    public void testPositionDuringMove() throws LoaderException {
        Saab95 saab = new Saab95();
        carTransport.raiseTruckBed(true);
        carTransport.load(saab);
    }


    @Test
    public void testLoadIncorrectVehicle() throws LoaderException {
        CarTransport secondTransport = new CarTransport(12000, 6);
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

    @Test
    public void testUnloadSpecificVehicle() throws LoaderException {
        Saab95 garbage = new Saab95();
        carTransport.raiseTruckBed(1);
        carTransport.load(garbage);
        assertThrows(LoaderException.class, ()->carTransport.unload(garbage));
    }



}

