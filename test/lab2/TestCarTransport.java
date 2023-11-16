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
    public void testPositionChangeSame(){
        Volvo240 volvo = new Volvo240();
        carTransport.load(volvo);
        carTransport.startEngine();
        carTransport.move();

        Position transportPos = carTransport.getPosition();
        Position carPos = volvo.getPosition();

        assertTrue(((transportPos.getX() == carPos.getX()) && (transportPos.getY() == carPos.getY())));
    }

    @Test
    public void testLoadIncorrectVehicle(){
        CarTransport secondTransport = new CarTransport();
        Volvo240 volvo = new Volvo240();
        //carTransport.load(secondTransport);
        carTransport.load(volvo);
    }

}

