import java.util.ArrayList;
/**
 * Write a description of class Snake here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Snake
{
    //head is last element of AL
    private ArrayList<Coordinate> body;
    private Direction direction;
    
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
    
    /**
     * Get direction.
     * @return direction of the snake.
     */
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
    
    /**
     * Print the body of the snake.
     */
    public void print(){
        for(Coordinate coor : body){
            System.out.print(coor + " ");
        }
        System.out.println();
    }
}
