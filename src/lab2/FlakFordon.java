package lab2;
import lab1.*;

public class FlakFordon extends Vehicle {

    protected Flak flak;

    public boolean isFlakSecured() {
        return flak.getCurrentAngle() == 0;
    }

    public int getFlakAngle() { return flak.getCurrentAngle(); }

    public boolean isNotMoving() {
        return currentSpeed == 0;
    }

    @Override
    public void move(){
        if (isFlakSecured())
            super.move();
    }

    public void raiseFlak(boolean complete) {
        if (isNotMoving())
            flak.raiseFlak(complete);
    }
    public void raiseFlak(int angle){
        if (isNotMoving())
            flak.raiseFlak(angle);
    }
    public void lowerFlak(boolean complete) {
        if (isNotMoving())
            flak.lowerFlak(complete);
    }
    public void lowerFlak(int angle){
        if (isNotMoving())
            flak.lowerFlak(angle);
    }
}
