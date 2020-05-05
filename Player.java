import java.util.ArrayList;
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    // instance variables - replace the example below with your own
    private Snake snake;
    private int lives;

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        lives = 3;
    }
    
    public void setSnake(Snake snake){
        this.snake = snake;
    }
    
    public Snake getSnake(){
        return snake;
    }
    
    public boolean checkCollision(Player other){
        Coordinate head = this.snake.getHead();
        ArrayList<Coordinate> otherBody = other.getSnake().getBody();
        for(Coordinate coord : otherBody){
            if(head.equals(coord)){
                return true;
            }
        }
        
        return false;
    }
    
    public void die(){
       lives--; 
    }
    
    public int getLives(){
        return lives;
    }

 
}
