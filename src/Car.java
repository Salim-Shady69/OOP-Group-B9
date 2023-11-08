import java.awt.*;

public abstract class Car implements Movable {

    protected int nrDoors;
    protected double enginePower;
    protected double currentSpeed = 0;
    protected Color color;
    protected String modelName;
    protected Position position = new Position(0,0);
    protected int direction = 0;

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    protected abstract double speedFactor();

    protected abstract void incrementSpeed(double amount);

    protected abstract void decrementSpeed(double amount);

    //Math.x lines ensures that speed cannot be increased by >1 or <0
    public void gas(double amount){
        double upperCheck = Math.min(amount, 1);
        double adjustedAmount = Math.max(upperCheck, 0);
        incrementSpeed(adjustedAmount);
    }

    //Math.x lines ensures that speed cannot be decreased by >1 or <0
    public void brake(double amount){
        double upperCheck = Math.min(amount, 1);
        double adjustedAmount = Math.max(upperCheck, 0);
        decrementSpeed(adjustedAmount);
    }

    @Override
    public void move() {
        switch(direction) {
            case 0: // increase x
                position.setX(position.getX() + getCurrentSpeed());
                break;
            case 90: // increase y
                position.setY(position.getY() + getCurrentSpeed());
                break;
            case 180: // decrease x
                position.setX(position.getX() - getCurrentSpeed());
                break;
            case 270: // decrease y
                position.setY(position.getY() - getCurrentSpeed());
                break;
        }
    }

    // Modulo 360 to ensure that values over 360 are not possible
    @Override
    public void turnLeft() {
        direction = (direction + 90) % 360;
    }

    @Override
    public void turnRight() {
        direction = ((direction - 90) % 360 + 360) % 360; // Java modulo negative numbers does not return expected value. This is a workaround.
    }

    @Override
    public Position getPosition() { return position; }

    @Override
    public int getDirection() { return direction; }
}
