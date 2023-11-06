package slask;

public enum Direction {
    EAST(0),
    NORTH(90),
    WEST(180),
    SOUTH(270);
    private final int angle;

    Direction(int angle){
        this.angle = angle;
    }

    public int getAngle() {
        return angle;
    }


}
