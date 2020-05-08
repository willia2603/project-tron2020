
/**
 * Write a description of class Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Game
{
    private int x;

    /**
     * Constructor for objects of class Game
     */
    public Game() {
        Player p1 = new Player();
        Player p2 = new Player();
        
        while(p1.getLives() > 0 && p2.getLives() > 0){
            Match match = new Match(p1, p2);
            Player winner = match.play();
            
            //needs to be changed
            if(p1 == winner){
                p2.die();
            }else if(p2 == winner){
                p1.die();
            }
            // else, died at the same time (return null)
        }
        
        // there is a winner of the whole game
       
    }
}
