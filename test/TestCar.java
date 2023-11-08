import org.junit.*;
import static org.junit.Assert.*;

import java.awt.*;

public class TestCar {

    private Saab95 saab;
    private Volvo240 volvo;


    @Before
    public void init() {
        saab = new Saab95();
        volvo = new Volvo240();
    }

    @Test
    public void testSetColor() {
        Color volvoCol = volvo.getColor();
        Color saabCol = saab.getColor();

        volvo.setColor(Color.green);
        saab.setColor(Color.pink);

        assertTrue(!(volvoCol.equals(volvo.getColor())) && !(saabCol.equals((saab.getColor()))));
    }

    @Test
    public void testStartEngine(){
        volvo.startEngine();
        saab.startEngine();
        assertTrue((volvo.getCurrentSpeed() > 0) && (saab.getCurrentSpeed() > 0));
    }

    @Test
    public void testStopEngine() {
        volvo.startEngine();
        saab.startEngine();

        assertTrue((volvo.getCurrentSpeed() != 0) && (saab.getCurrentSpeed() != 0));
    }

    @Test
    public void testNrOfDoors() {
        int volvoDoors = volvo.getNrDoors();
        int saabDoors = saab.getNrDoors();

        assertTrue((volvoDoors == 4) && (saabDoors == 2));
    }

    @Test
    public void testEnginePower() {
        double volvoPower = volvo.getEnginePower();
        double saabPower = saab.getEnginePower();

        assertTrue((volvoPower == 100) && (saabPower == 125));
    }

    @Test
    public void testMoveDirection0(){
        volvo.startEngine();
        double volvoSpeed = volvo.getCurrentSpeed();
        double expectedX = 0 + volvoSpeed;
        double expectedY = 0;
        volvo.move();
        Position newPosition = volvo.getPosition();

        assertTrue((newPosition.getX() == expectedX) && (newPosition.getY() == expectedY));
    }

    @Test
    public void testMoveDirection90(){
        volvo.startEngine();
        volvo.turnLeft();
        double volvoSpeed = volvo.getCurrentSpeed();
        double expectedX = 0;
        double expectedY = 0 + volvoSpeed;
        volvo.move();
        Position newPosition = volvo.getPosition();

        assertTrue((newPosition.getX() == expectedX) && (newPosition.getY() == expectedY));
    }

    @Test
    public void testMoveDirection180(){
        volvo.startEngine();
        volvo.turnLeft();
        volvo.turnLeft();
        double volvoSpeed = volvo.getCurrentSpeed();
        double expectedX = 0 - volvoSpeed;
        double expectedY = 0;
        volvo.move();
        Position newPosition = volvo.getPosition();

        assertTrue((newPosition.getX() == expectedX) && (newPosition.getY() == expectedY));
    }

    @Test
    public void testMoveDirection270(){
        volvo.startEngine();
        volvo.turnRight();
        double volvoSpeed = volvo.getCurrentSpeed();
        double expectedX = 0;
        double expectedY = 0 - volvoSpeed;
        volvo.move();
        Position newPosition = volvo.getPosition();

        assertTrue((newPosition.getX() == expectedX) && (newPosition.getY() == expectedY));
    }

    @Test
    public void testTurnLeft() {
        volvo.turnLeft();
        saab.turnLeft();

        assertTrue((volvo.getDirection() == 90) && (saab.getDirection() == 90));
    }

    @Test
    public void testTurnRight() {
        volvo.turnRight();
        saab.turnRight();

        assertTrue((volvo.getDirection() == 270) && (saab.getDirection() == 270));
    }

    @Test
    public void testTurnFullRotationLeft(){
        volvo.turnLeft();
        volvo.turnLeft();
        volvo.turnLeft();
        volvo.turnLeft();

        assertEquals(0, volvo.getDirection(), 0);
    }
    @Test
    public void testTurnFullRotationRight(){
        volvo.turnRight();
        volvo.turnRight();
        volvo.turnRight();
        volvo.turnRight();

        assertEquals(0, volvo.getDirection(), 0);
    }
}
