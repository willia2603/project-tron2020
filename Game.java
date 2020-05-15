import java.util.ArrayList;
/**
 * Write a description of class Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Game
{
    protected Player p1;
    protected Player p2;
    //add list of commands
    ArrayList<GameListener> listeners;
    ArrayList<Command> commands;
    public Game(){
        listeners = new ArrayList<>();
        commands = new ArrayList<>();
        p1 = new Player();
        p2 = new Player();
    }
    
    public void play()
    {
        while(this.continueGame()){
            Match match = new TextMatch(this.p1, this.p2);
            Player winner = match.play();
            
            this.alive(winner);
        }
        showWinner();
        // Player gameWinner = this.gameWinner();
        
        // String winnerString;
        // if(gameWinner == this.p1){
            // winnerString = "Player 1";
        // }else{
            // winnerString = "Player 2";
        // }
        
        // System.out.println("And the winner is.... " + winnerString);
        
        // return gameWinner;
    }
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
    //continua qui!!!
    private void showWinner() {
        for (GameListener listener : listeners) {
            listener.showWinner(this);
        }
        //execute all current commands
        //loop over all commands
        //serve qui?
        for (Command command : commands) {
            command.execute();
        }
        commands.clear();
    }
    
    protected Player gameWinner(){
        if(p1.getLives() == 0){
            return p2;
        }else{
            return p1;
        }
    }
}
