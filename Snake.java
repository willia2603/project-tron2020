import java.util.ArrayList;
/**
 * Write a description of class Snake here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Snake
{
    private ArrayList<Coordinate> body;//AL of rectangles? easier to draw + easier collision detection
    private Direction direction;
    //private int width = 10 width of rectangle in case it gets implemented
    
    /**
     * Constructor for objects of class Snake
     */
    public Snake(Direction direction, Coordinate init) {
        this.direction = direction;
        body = new ArrayList<>();
        body.add(init);
    }
    
    /**
     * Get the head of the snake.
     * @return the head of the snake.
     */
    public Coordinate getHead() {
        return body.get(body.size() - 1);
    }
    
    /**
     * Compute next position.
     */
    public void nextPosition() {
        Coordinate prevHead = getHead();
        int newX = prevHead.getX() + direction.actionOnX();
        int newY = prevHead.getY() + direction.actionOnY();
        Coordinate newHead = new Coordinate(newX, newY);
        body.add(newHead);
    }
    
    /**
     * Change direction.
     */
    public void setDirection(Direction newDirection) {
        direction = newDirection;
    }

    public Direction getDirection() {
        return direction;
    }
    
    /**
     * Get the body of the snake.
     * @return body of the snake.
     */
    public ArrayList<Coordinate> getBody() {
        return body;
    }
}
