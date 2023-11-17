package lab2;

import lab1.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestWorkshop {

    private Saab95 saab;
    private Volvo240 volvo;
    private Scania scania;
    private CarTransport carTransport;
    @Before
    public void init(){
        saab = new Saab95();
        volvo = new Volvo240();
    }
    @Test
    public void testCreateWorkshop() throws LoaderException{
        AutomotiveWorkshop<Volvo240> workshop = new AutomotiveWorkshop<>(10);
        workshop.add(volvo);
    }

   @Test
    public void testCreateWorkshopUnlimited() throws LoaderException {
        AutomotiveWorkshop<Volvo240> workshop = new AutomotiveWorkshop<>(12);
        workshop.add(volvo);
    }

    @Test
    public void testSaabWorkshop(){
        AutomotiveWorkshop<Saab95> workshop = new AutomotiveWorkshop<>(10);

    }

    @Test
    public void testAddTooManyCars() throws LoaderException {
        AutomotiveWorkshop<Vehicle> smallWorkshop = new AutomotiveWorkshop<>(1);
        smallWorkshop.add(saab);
        assertThrows(LoaderException.class, ()-> smallWorkshop.add(volvo));
    }

    @Test
    public void testCheckOut() throws LoaderException {
        AutomotiveWorkshop<Vehicle> workshop = new AutomotiveWorkshop<>(5);
        workshop.add(volvo);
        workshop.add(saab);
        workshop.checkOut(volvo);
        assertThrows(LoaderException.class, ()->workshop.checkOut(volvo));
    }



}
