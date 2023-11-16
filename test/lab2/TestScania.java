package lab2;

import lab1.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestScania {

    public Scania scania;

    @Before
    public void init() {
        scania = new Scania();
    }

    @Test
    public void testRaiseTruckBedWithSpeed() {
        scania.startEngine();
        scania.raiseTruckBed(20);
        assertEquals(0, scania.getCurrentAngle());
    }

    @Test
    public void testMoveWithTruckBedNotSecured() {
        Position initial = scania.getPosition();
        scania.raiseTruckBed(true);
        scania.startEngine();
        scania.move();
        assertEquals(initial, scania.getPosition());
    }
    @Test
    public void testRaiseTruckBed() {
        scania.raiseTruckBed(55);
        assertEquals(55, scania.getCurrentAngle());
    }

    @Test
    public void testLowerTruckBed() {
        scania.raiseTruckBed(70);
        scania.lowerTruckBed(30);
        assertEquals(40, scania.getCurrentAngle());
    }

    @Test
    public void testRaiseHigh() {
        scania.raiseTruckBed(1000);
        assertEquals(70, scania.getCurrentAngle());
    }

    @Test
    public void testLowerLow() {
        scania.lowerTruckBed(1000);
        assertEquals(0, scania.getCurrentAngle());
    }
    @Test
    public void testTruckBedMax(){
        scania.raiseTruckBed(true);
        assertEquals(70,scania.getCurrentAngle());
    }
    @Test
    public void testTruckBedMin(){
        scania.lowerTruckBed(true);
        assertEquals(0,scania.getCurrentAngle());
    }
}
