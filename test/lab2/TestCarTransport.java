package lab2;
import lab1.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestCarTransport {

    public CarTransport carTransport;

    @Before
    public void init() {carTransport = new CarTransport();}

    @Test
    public void testUnloadEmptyLast(){
        carTransport.unloadLast();


    }

    @Test
    public void testLoadVehicle(){
        carTransport.raiseFlak(true);
    }

    @Test
    public void testCargoDirection() {
        Volvo240 karusellEnjoyer = new Volvo240();
        carTransport.raiseFlak(true);
        carTransport.load(karusellEnjoyer);
        for (int i = 0; i < 17; i++)
            carTransport.turnLeft();
        assertEquals(carTransport.getDirection(), karusellEnjoyer.getDirection());
    }

    @Test
    public void testLoadFarAway(){
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

        carTransport.raiseFlak(true);
        carTransport.load(saab);
        carTransport.load(volvo);
        carTransport.load(noWheels);

        //assertTrue(!carTransport.loaderHelper.getCargo.contains(saab) &&
        // !carTransport.loaderHelper.getCargo.contains(volvo) &&
        // carTransport.loaderHelper.getCargo.contains(noWheels));
        // Är vad jag hade velat skriva, men ty private loaderHelper så kan jag ej det
    }

    @Test
    public void testMoveWhenRaised(){
        Position initialPos = carTransport.getPosition();
        carTransport.startEngine();
        carTransport.raiseFlak(true);
        carTransport.move();
        assertEquals(initialPos, carTransport.getPosition());
    }
    @Test
    public void testLoadWithSpeed(){
        Saab95 saab = new Saab95();
        carTransport.startEngine();
        carTransport.load(saab);
        //assertFalse(carTransport.loaderHelper.getCargo.contains(saab));
        //Ovan är vad jag hade velat skriva, men eftersom loaderHelper är privat så kan jag inte det >:(
    }

    @Test
    public void testPositionChangeSame(){
        Volvo240 volvo = new Volvo240();
        carTransport.load(volvo);
        carTransport.startEngine();
        carTransport.move();

        Position transportPos = carTransport.getPosition();
        Position carPos = volvo.getPosition();

        assertTrue(((transportPos.getX() == carPos.getX()) && (transportPos.getY() == carPos.getY())));
    }

}

