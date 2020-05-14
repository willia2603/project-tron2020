
/**
 * Write a description of class Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Game
{
    protected Player p1;
    protected Player p2;
        
    public Game(){
        p1 = new Player();
        p2 = new Player();
    }
    
    public abstract Player play();
    
    protected boolean continueGame(){
        return p1.getLives() > 0 && p2.getLives() > 0;
    }
    
    protected void alive(Player player){
        if(p1 == player){
            p2.die();
        } else if(p1 == player) {
            p1.die();
        }
    }
    
    protected Player gameWinner(){
        if(p1.getLives() == 0){
            return p2;
        }else{
            return p1;
        }
    }
}
