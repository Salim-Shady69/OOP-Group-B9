package lab2;

import org.junit.*;
import static org.junit.Assert.*;


public class TestScaniaFlak {

    private Flak flak;
    @Before
    public void init(){
        flak = new Flak(18000, 70);
    }

    @Test
    public void testRaiseFlak() {
        flak.raiseFlak(55);
        assertEquals(55, flak.getCurrentAngle());
    }

    @Test
    public void testLowerFlak() {
        flak.raiseFlak(70);
        flak.lowerFlak(30);
    }
}
