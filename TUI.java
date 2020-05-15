import java.util.List;
/**
 * Write a description of class TUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TUI implements MatchListener,GameListener
{
    private Parser parser;
    /**
     * Constructor for objects of class TUI
     */
    public TUI()
    {
        parser = new Parser();
    }

    // public void start()
    // {
        // printWelcome();
        
        // boolean finished = false;
        // while (! finished) {
            // MenuCommand command = parser.getCommand();
            // finished = processCommand(command);
        // }
        
        // System.out.println("Thank you for riding.  Good bye.");
    // }
    
    //method to read match commands
    
    public void readMatchCommand(Match match) {
        //if user writes left right
        //command for no turning
        //processCommandMatch(MenuCommand command);
    }
    
    // private boolean processCommandGame(MenuCommand command) {
        // boolean wantToQuit = false;
        // switch (command) {
            // case UNKNOWN:
                // System.out.println("I don't know what you mean...");
                // break;

            // case HELP:
                // printHelp();
                // break;

            // case PLAY:
                // play();
                // break;

            // case QUIT:
                // return true;
        // }
        // return wantToQuit;
    // }
    //user: types p1 left --> turn string into turn left command inside TurnLeft class
    // private boolean processCommandMatch(Match match, Command command) {
        // //process command for current match
        // boolean wantToQuit = false;
        // switch (command) {
            // case UNKNOWN:
                // System.out.println("I don't know what you mean...");
                // break;

            // case Left:
                // //figure out how to know which player. How to create command 0bjs from string user
                // Command command = new TurnLeft(p1);
                // //printHelp();
                // break;

            // case right:
                // play();
                // break;

            // case Continue:
                // break;
        // }
        // return wantToQuit;
    // }
    //new
    public void beforeTick(Match match) {
        List<Player> players = match.returnPlayers();
        for (Player player : players) {
            player.printSnake();
        }
        //ask for command again
        readMatchCommand(match);
    };
    
    public void showWinner(Game game){
       System.out.println("The winner is: " + game.gameWinner());
    }
    
    
    private void play() {
        Game textGame = new TextGame();
        textGame.play();
    }
    
     /**
     * Display available commands.
     */
    private void printHelp()
    {
        System.out.println("Each player has 3 lives, game ends when one reaches 0 lives");
        System.out.println("\"" + MenuCommand.PLAY.toString() + "\" starts a new game");
        System.out.println("\"" + MenuCommand.QUIT.toString() + "\" terminates this program");
    }
    
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to Tron2020!");
        System.out.print("The commands are: ");
        parser.showCommands();
        System.out.println();
    }
}
