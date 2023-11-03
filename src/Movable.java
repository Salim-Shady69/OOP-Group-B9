package src;

public abstract class Movable {

    protected double xPos;
    protected double yPos;
    protected double direction;

    abstract void move();
    abstract void turnLeft();
    abstract void turnRight();
}
