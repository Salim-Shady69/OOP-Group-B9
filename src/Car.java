
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Car implements Movable {

    protected int nrDoors;
    protected double enginePower;
    protected double currentSpeed = 0;
    protected Color color;
    protected String modelName;
    protected double xPos = 0;
    protected double yPos = 0;
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

    protected double speedFactor(){
        return enginePower * 0.01;
    }

    protected void incrementSpeed(double amount) {}

    protected void decrementSpeed(double amount) {}

    // TODO fix this method according to lab pm :)
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }

    @Override
    public void move() {
        switch(direction) {
            case 0: // increase x
                xPos += getCurrentSpeed();
            case 90: // increase y
                yPos += getCurrentSpeed();
            case 180: // decrease x
                xPos -= getCurrentSpeed();
            case 270: // decrease y
                yPos -= getCurrentSpeed();
        }
    }

    @Override
    public void turnLeft() {
        direction = (direction + 90) % 360;
    }

    @Override
    public void turnRight() {
        //direction = (direction - 90) % 360;
        direction = ((direction - 90) % 360 + 360) % 360;
    }

    @Override
    public Map<String, Double> getPosition(){
        Map<String, Double> coordinates = new HashMap<>();
        coordinates.put("x", xPos);
        coordinates.put("y", yPos);
        return coordinates;
    }

    @Override
    public int getDirection() { return direction; }
}
