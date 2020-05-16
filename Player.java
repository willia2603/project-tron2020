import java.util.ArrayList;

/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    private Snake snake;
    private int lives;
    private String name;

    /**
     * Constructor for objects of class Player
     */
    public Player(String name) {
        lives = 3;
        this.name = name;
    }
    
    /**
     * 
     * @param direction The direction fo the snake.
     * @param init The initial coordinate of the snake.
     */
    public void createSnake(Direction direction, Coordinate init) {
        this.snake = new Snake(direction, init);
    }
    
    /**
     * Return the snake of the player.
     * @return the snake of the player.
     */
    public Snake getSnake() {
        return snake;
    }
    
    /**
     * Check if current player collides with another player.
     * @param other The other player.
     * @return true if collision happens, false otherwise.
     */
    public boolean checkCollision(Player other) {
        Coordinate head = this.snake.getHead();
        ArrayList<Coordinate> otherBody = other.getSnake().getBody();
        for (Coordinate c : otherBody) {
            if (head.equals(c)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Check if I collide into myself.
     * @return true if collision happens, false otherwise.
     */
    public boolean checkCollisionSelf() {
        Coordinate head = this.snake.getHead();
        ArrayList<Coordinate> myBody = this.getSnake().getBody();

        for (int i = 0; i < myBody.size() - 1; i++) {
            Coordinate c = myBody.get(i);
            if (head.equals(c)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Compute next position of the player.
     */
    public void nextPosition() {
        this.snake.nextPosition();
    }
    
    /**
     * Make player turn left.
     */
    public void turnLeft() {
        Direction dir = this.snake.getDirection();
        if (dir instanceof Left) {
            this.snake.setDirection(new Down());
        } else if (dir instanceof Down) {
            this.snake.setDirection(new Right());
        } else if (dir instanceof Right) {
            this.snake.setDirection(new Up());
        } else if (dir instanceof Up) {
            this.snake.setDirection(new Left());
        }
    }
    
    /**
     * Make player turn right.
     */
    public void turnRight() {
        Direction dir = this.snake.getDirection();
        if (dir instanceof Left) {
            this.snake.setDirection(new Up());
        } else if (dir instanceof Up) {
            this.snake.setDirection(new Right());
        } else if (dir instanceof Right) {
            this.snake.setDirection(new Down());
        } else if (dir instanceof Down) {
            this.snake.setDirection(new Left());
        }
    }
    
    /**
     * Remove a life from the player.
     */
    public void die() {
       lives--; 
    }
    
    /**
     * Get the numbers of lives of a player.
     * @return the number of lives of the player.
     */
    public int getLives() {
        return lives;
    }
    
    /**
     * Print the snake of the player.
     */
    public void printSnake() {
        snake.print();
    }
    
    @Override
    /**
     * Return the name of the player.
     * @return the name of the player.
     */
    public String toString() {
        return this.name;
    }
    
}
