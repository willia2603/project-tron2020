import java.util.ArrayList;
/**
 * Write a description of class Snake here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Snake
{
    // instance variables - replace the example below with your own
    private ArrayList<Coordinate> body;
    private Direction direction;

    /**
     * Constructor for objects of class Snake
     */
    public Snake(Direction direction, Coordinate init)
    {
        this.direction = direction;
        body = new ArrayList<>();
        body.add(init);
    }
    
    public Coordinate getHead(){
        return body.get(body.size() - 1);
    }
    
    public void nextPosition(){
        Coordinate prevHead = getHead();
        int newX = prevHead.getX() + direction.actionOnX();
        int newY = prevHead.getY() + direction.actionOnY();
        Coordinate newHead = new Coordinate(newX, newY);
        body.add(newHead);
    }

    public void setDirection(Direction newDirection)
    {
        direction = newDirection;
    }
    
    public ArrayList<Coordinate> getBody(){
        return body;
    }
}
