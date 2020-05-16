import java.util.ArrayList;

/**
 * Write a description of class Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Game
{
    ArrayList<GameListener> listeners;
    ArrayList<Command> commands;
    protected Player p1;
    protected Player p2;
    //add list of commands
    
    public Game(){
        this.listeners = new ArrayList<>();
        this.commands = new ArrayList<>();
        p1 = new Player("Player 1");
        p2 = new Player("Player 2");
    }
    
    public void registerListener(GameListener listener) {
        listeners.add(listener);
    }
    
    public void beforeMatch(Match match){
        for (GameListener listener : listeners) {
            listener.beforeMatch(match);
        }
    }
    
    public void afterMatch(Player winner, Match match){
        for (GameListener listener : listeners) {
            listener.afterMatch(winner, match);
        }
    }
    
    protected Player gameWinner(){
        if(p1.getLives() == 0){
            return p2;
        }else{
            return p1;
        }
    }
    
    protected void alive(Player player){
        if(p1 == player){
            p2.die();
        } else if(p1 == player) {
            p1.die();
        }
    }
    
    protected boolean continueGame(){
        return p1.getLives() > 0 && p2.getLives() > 0;
    }
    
    public Player play()
    {
        while(this.continueGame()){
            Match match = new Match(this.p1, this.p2);
            beforeMatch(match);
            Player winner = match.play();

            this.alive(winner);
            
            afterMatch(winner, match);
        }
        
        Player gameWinner = this.gameWinner();
        return gameWinner;
    }
}
