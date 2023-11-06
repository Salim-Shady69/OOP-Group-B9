import java.awt.*;
import java.util.Map;

interface Movable {
     void move();
     void turnLeft();
     void turnRight();
     Map<String, Double> getPosition();
     int getDirection();
}
