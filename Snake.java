import java.util.ArrayList;

/**
 * Write a description of class Snake here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Snake {
    // head is last element of AL
    private ArrayList<Coordinate> body;
    private Direction direction;

    /**
     * Constructor for objects of class Snake.
     * 
     * @param direction the direction of the snake.
     * @param init      The initial coordinate of the snake.
     */
    public Snake(final Direction direction, final Coordinate init) {
        this.direction = direction;
        body = new ArrayList<>();
        body.add(init);
    }

    /**
     * Copy constructor.
     * 
     * @param snake The snake that need to be copied.
     */
    public Snake(final Snake snake) {
        this.direction = snake.direction;
        // cast since clone() returns Object type.
        this.body = (ArrayList<Coordinate>) snake.body.clone();
    }

    /**
     * Get the head of the snake.
     * 
     * @return the head of the snake.
     */
    public Coordinate getHead() {
        return body.get(body.size() - 1);
    }

    /**
     * Compute next position.
     */
    public void nextPosition() {
        final Coordinate prevHead = getHead();
        final int newX = prevHead.getX() + direction.actionOnX();
        final int newY = prevHead.getY() + direction.actionOnY();
        final Coordinate newHead = new Coordinate(newX, newY);
        body.add(newHead);
    }

    /**
     * Change direction.
     * 
     * @param newDirection The new direction of the snake.
     */
    public void setDirection(final Direction newDirection) {
        direction = newDirection;
    }

    /**
     * Get direction.
     * 
     * @return direction of the snake.
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Get the body of the snake.
     * 
     * @return body of the snake.
     */
    public ArrayList<Coordinate> getBody() {
        return body;
    }

    /**
     * Print the body of the snake.
     */
    public void print() {
        for (final Coordinate coor : body) {
            System.out.print(coor + " ");
        }
        System.out.println();
    }
}
