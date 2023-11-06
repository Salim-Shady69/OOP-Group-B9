import org.junit.*;
import static org.junit.Assert.*;

import java.awt.*;

public class SaabMekaniker {

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


}
