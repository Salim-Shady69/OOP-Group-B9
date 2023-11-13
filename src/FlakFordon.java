public class FlakFordon extends Vehicle {

    protected Flak flak;
    protected boolean flakRaised;

    public boolean isFlakRaised() {
        return flakRaised;
    }

    @Override
    public void move(){
        if (!isFlakRaised())
            super.move();
    }

}
