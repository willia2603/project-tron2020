
/**
 * Write a description of class Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Game
{
    public static Player newGame(){
        Player p1 = new Player();
        Player p2 = new Player();
        
        while(p1.getLives() > 0 && p2.getLives() > 0){
            Match match = new Match(p1, p2);
            Player winner = match.play();
            
            //if winner ==  null just start over
            if(p1 == winner){
                p2.die();
            }else if(p2 == winner){
                p1.die();
            }
        }
        
        if(p1.getLives() == 0){
            return p2;
        }else{
            return p1;
        }
        
    }
}
