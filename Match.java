
/**
 * Write a description of class Match here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Match
{
    // instance variables - replace the example below with your own
    private Player p1;
    private Player p2;
    private float speed = 1;
    private float tickPerSecond = 30;

    /**
     * Constructor for objects of class Match
     */
    public Match(Player p1, Player p2)
    {
        Coordinate p1Coord = new Coordinate(10, 10);
        Coordinate p2Coord = new Coordinate(20, 10);
        Direction p1Dir = new Right();
        Direction p2Dir = new Left();
        Snake p1Snake = new Snake(p1Dir, p1Coord);
        Snake p2Snake = new Snake(p2Dir, p2Coord);
        
        p1.setSnake(p1Snake);
        p2.setSnake(p1Snake);
    }

    public Player tick()
    {
        // update snake
        p1.getSnake().nextPosition();
        p2.getSnake().nextPosition();
        // check collision
        // todo, check collision between p1 and p2
        // return winner
        // special case: two heads collides(?)
        if(p1.checkCollision(p2)){
            
        }
        
        // draw
        return null;
    }
    
    public Player play()
    {
        while(true){
            long tickStart = System.currentTimeMillis();
            // return the winner player when a player wins
            tick();
            long tickEnd = System.currentTimeMillis();
            
            long ellapsedTime = tickEnd - tickStart;
            long sleep = (long)(1000 / (tickPerSecond * speed)) - ellapsedTime;
            if(sleep < 0){
                sleep = 0;
            }
            
            speed += 0.001;
            try
            {
                Thread.sleep(sleep);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
            
            break; // temp
        }
        return p1;
    }
}
