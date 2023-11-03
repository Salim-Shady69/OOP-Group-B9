package src;

import java.awt.*;

public class Car extends Movable {

    protected int nrDoors;
    protected double enginePower;
    protected double currentSpeed;
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

    public void setColor(Color clr){
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

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }

    @Override
    void move() {
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
    void turnLeft() {
        direction = (direction + 90) % 360;
    }

    @Override
    void turnRight() {
        direction = (direction - 90) % 360;
    }
}
