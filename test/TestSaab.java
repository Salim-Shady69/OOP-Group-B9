import org.junit.*;
import static org.junit.Assert.*;

public class TestSaab {

    private Saab95 saab;

    @Before
    public void init() {
        saab = new Saab95();

    }

    @Test
    public void testSetSaabTurboOn() {
        boolean startValue = saab.getTurbo();

        saab.setTurboOn();

        assertTrue(startValue != saab.getTurbo());
    }


    @Test
    public void testSetSaabTurboOff() {
        saab.setTurboOn();
        boolean startValue = saab.getTurbo();
        saab.setTurboOff();

        assertTrue(startValue != saab.getTurbo());
    }

    @Test
    public void testSaabSpeedFactorTurboOn() {
        saab.setTurboOn();
        double Factor = saab.speedFactor();
        assertEquals(1.625, Factor, 0);
    }

    @Test
    public void testSaabSpeedFactorTurboOff() {
        saab.setTurboOff();
        double Factor = saab.speedFactor();
        assertEquals(1.25, Factor, 0);
    }

    @Test
    public void testSaabIncrementSpeedTurboOff(){
        saab.setTurboOff();
        saab.incrementSpeed(10);
        assertEquals(12.5, saab.getCurrentSpeed(), 0);
    }

    @Test
    public void testSaabIncrementSpeedTurboOn(){
        saab.setTurboOn();
        saab.incrementSpeed(10);
        assertEquals(16.25, saab.getCurrentSpeed(), 0);
    }

    @Test
    public void testSaabDecrementSpeedTurboOff(){
        saab.setTurboOff();
        saab.incrementSpeed(10);
        saab.decrementSpeed(5);
        assertEquals(6.25, saab.getCurrentSpeed(), 0);
    }

    @Test
    public void testSaabDecrementSpeedTurboOn(){
        saab.setTurboOn();
        saab.incrementSpeed(10);
        saab.decrementSpeed(5);
        assertEquals(8.125, saab.getCurrentSpeed(), 0.01);
    }

    @Test
    public void testSaabGasTurboOn() {
        saab.setTurboOn();
        saab.gas(10);
        assertEquals(16.25, saab.getCurrentSpeed(), 0);
    }

    @Test
    public void testSaabGasTurboOff() {
        saab.setTurboOff();
        saab.gas(10);
        assertEquals(12.5, saab.getCurrentSpeed(), 0);
    }

    @Test
    public void testSaabBrakeTurboOn() {
        saab.setTurboOn();
        saab.gas(10);
        saab.brake(5);
        assertEquals(8.125, saab.getCurrentSpeed(), 0);
    }

    @Test
    public void testSaabBrakeTurboOff() {
        saab.setTurboOff();
        saab.gas(10);
        saab.brake(5);
        assertEquals(6.25, saab.getCurrentSpeed(), 0);
    }

    @Test
    public void testSaabCrazySpeed(){
        saab.gas(10000);
        assertTrue(saab.getCurrentSpeed() <= saab.getEnginePower());
    }

    @Test
    public void testSaabHighGasTurboOn(){
        saab.setTurboOn();
        saab.gas(1);
        double cappedGas = saab.getCurrentSpeed();
        saab.gas(10);
        assertTrue(saab.getCurrentSpeed() == 3.25);
    }

    @Test
    public void testSaabHighGasTurboOff(){
        saab.setTurboOff();
        saab.gas(1);
        double cappedGas = saab.getCurrentSpeed(); //1.25
        saab.gas(10);
        assertTrue(saab.getCurrentSpeed() == 2.5);
    }

}
