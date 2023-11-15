package lab2;
import lab1.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCarTransport {

    public CarTransport carTransport;

    @Before
    public void init() {carTransport = new CarTransport();}

    @Test
    public void testUnloadVehicle(){

    }

    @Test
    public void testLoadVehicle(){
        carTransport.stopEngine();
        carTransport.raiseFlak(true);
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

