
/**
 * Write a description of class Match here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TextMatch extends Match
{
    private Parser parser;
    
    public TextMatch(Player p1, Player p2){
        super(p1, p2);
        parser = new Parser();
    }
    
    /**
     * Compute the winner of the match. 
     * @return winner of the match.
     */
    public int tick() {
        // update snake
        this.updateSnake();
        
        int result = this.checkCollision();
        
        return result;
    }
    
    private boolean processCommand(MenuCommand command, Player player) {
        boolean wantToQuit = false;
        switch (command) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                //printHelp();
                break;

            case PLAY:
                //play();
                break;

            case QUIT:
                return true;
        }
        return wantToQuit;
    }
    
    private boolean updateSnakeDirection(){
        System.out.println("Direction of Player 1");
        MenuCommand commandP1 = parser.getCommand();
        processCommand(commandP1, p1);
        System.out.println("Direction of Player 2");
        MenuCommand commandP2 = parser.getCommand();
        processCommand(commandP2, p2);
        
        return false;
    }
   
    /**
     * Start the match. 
     * @return winner of the match.
     */
    public Player play() {
        while (true) {
            // read command
            // todo want to quit
            boolean wantToQuit = updateSnakeDirection();
            
            int result = tick();
            switch(result){
                case -1: 
                    return null;
                case 1:
                    return this.p1;
                case 2:
                    return this.p2;
            }
            
        }
    }
}
