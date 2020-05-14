
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
    
    private void processCommand(MenuCommand command, Player player) {
        // boolean wantToQuit = false;
        // switch (command) {
            // case UNKNOWN:
                // System.out.println("I don't know what you mean...");
                // break;

            // case HELP:
                // //printHelp();
                // break;

            // case PLAY:
                // //play();
                // break;

            // case QUIT:
                // return true;
        // }
    }
    
    private void updateSnakeDirection(){
        System.out.println("Direction of Player 1");
        //MenuCommand commandP1 = parser.getCommand();
        //processCommand(commandP1, p1);
        System.out.println("Direction of Player 2");
        //MenuCommand commandP2 = parser.getCommand();
        //processCommand(commandP2, p2);
    }
   
    /**
     * Start the match. 
     * @return winner of the match.
     */
    public Player play() {
        while (true) {
            //print body of snake so players know where to move next
            p1.printSnake();
            p2.printSnake();
            
            // read command
            // todo want to quit
            updateSnakeDirection();
            
            int result = tick();
            switch(result){
                case -1: 
                    System.out.println("You died at the same time.");
                    return null;
                case 1:
                    System.out.println("Match won by Player 1");
                    return this.p1;
                case 2:
                    System.out.println("Match won by Player 2");
                    return this.p2;
            }
            
        }
    }
}
