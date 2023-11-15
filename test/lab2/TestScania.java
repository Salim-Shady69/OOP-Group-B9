package lab2;

import lab1.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestScania {

    public ScaniaP124 scania;

    @Before
    public void init() {
        scania = new ScaniaP124();
    }

    @Test
    public void testRaiseFlakWithSpeed() {
        scania.startEngine();
        scania.raiseFlak(20);
        assertEquals(0, scania.getFlakAngle());
    }

    @Test
    public void testMoveWithFlakNotSecured() {
        Position initial = scania.getPosition();
        scania.flak.raiseFlak(true);
        scania.startEngine();
        scania.move();
        assertEquals(initial, scania.getPosition());
    }
    @Test
    public void testRaiseFlak() {
        scania.flak.raiseFlak(55);
        assertEquals(55, scania.getFlakAngle());
    }

    @Test
    public void testLowerFlak() {
        scania.flak.raiseFlak(70);
        scania.flak.lowerFlak(30);
        assertEquals(40, scania.getFlakAngle());
    }

    @Test
    public void testRaiseHigh() {
        scania.raiseFlak(1000);
        assertEquals(70, scania.getFlakAngle());
    }

    @Test
    public void testLowerLow() {
        scania.lowerFlak(1000);
        assertEquals(0, scania.getFlakAngle());
    }
    @Test
    public void testFlakMax(){
        scania.raiseFlak(true);
        assertEquals(70,scania.getFlakAngle());
    }
    @Test
    public void testFlakMin(){
        scania.lowerFlak(true);
        assertEquals(0,scania.getFlakAngle());
    }
}
