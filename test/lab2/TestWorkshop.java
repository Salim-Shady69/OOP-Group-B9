package lab2;

import lab1.*;
import org.junit.Before;
import org.junit.Test;

public class TestWorkshop {

    private Saab95 saab;
    private Volvo240 volvo;
    @Before
    public void init(){
        saab = new Saab95();
        volvo = new Volvo240();
    }
    @Test
    public void testCreateWorkshop(){
        AutomotiveWorkshop<Volvo240> workshop = new AutomotiveWorkshop<>();
        workshop.add(volvo);
    }
}
