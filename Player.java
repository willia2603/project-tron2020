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

    /**
     * Constructor for objects of class Player
     */
    public Player() {
        lives = 3;
    }
    
    /**
     * Assign snake to a player.
     * @param snake the snake to be set to a player.
     */
    public void setSnake(Snake snake) {
        this.snake = snake;
    }
    
    /**
     * return the snake of the player.
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
}
