import org.junit.*;
import static org.junit.Assert.*;

public class TestVolvo {

    private Volvo240 volvo;

    @Before
    public void init() {
        volvo = new Volvo240();
    }


    @Test
    public void testVolvoSpeedFactor(){
        double Factor = volvo.speedFactor();
        assertEquals(1.25, Factor, 0);
    }



}


