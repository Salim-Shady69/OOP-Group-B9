import org.junit.*;
import static org.junit.Assert.*;

import java.awt.*;
import java.util.Map;

public class Mekaniker {

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
        double volvoStop = volvo.getCurrentSpeed();
        double saabStop = saab.getCurrentSpeed();

        volvo.startEngine();
        saab.startEngine();

        assertTrue((volvo.getCurrentSpeed() > 0) && (saab.getCurrentSpeed() > 0));
    }

    @Test
    public void testStopEngine() {
        double volvoStop = volvo.getCurrentSpeed();
        double saabStop = saab.getCurrentSpeed();

        volvo.startEngine();
        saab.startEngine();

        assertTrue((volvo.getCurrentSpeed() == 0) && (saab.getCurrentSpeed() == 0));


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
    public void testMove(){
        Map<String, Double> initialSaabPos = saab.getPosition();

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


}
