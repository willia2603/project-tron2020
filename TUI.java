import java.util.ArrayList;

/**
 * Write a description of class TUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TUI implements MatchListener, GameListener
{
    private Parser parser;
    
    /**
     * Constructor for TUI object.
     */
    public TUI()
    {
        parser = new Parser();
    }
    
    /**
     * Process menu commands.
     * @param userCommand the command given by user.
     * @return true if player wants to quit, false otherwise.
     */
    private boolean processCommandMenu(final String userCommand) {
        switch (userCommand) {
            case "help":
                printHelp();
                break;

            case "play":
                play();
                break;

            case "quit":
                return true;
                
            default:
                System.out.println("commands are: 'quit', 'help', 'play'");
                break;
        }
        return false;
    }
    
    /**
     * Process match commands.
     * @param userCommand the command given by user.
     * @param player the player that needs to act.
     * @return command associated with userCommand.
     */
    private Command processCommandMatch(final String userCommand, final Player player) {
        String command = userCommand;
        
        //if one of the two words is null, make snake go straight
        if (command == null) {
            command = "continue";
        }
        
        switch (command) {
            case "left":
                return new TurnLeft(player);

            case "right":
                return new TurnRight(player);

            case "continue":
                return new Continue();
                
            default:
                System.out.println("The commands are: 'right', 'left'");
                return null;
        }
    }
    
    /**
    * Display available commands.
    */
    private void printHelp()
    {
        System.out.println("Each player has 3 lives, game ends when one reaches 0 lives");
        System.out.println("'play' starts a new game");
        System.out.println("'quit' terminates this program");
        System.out.println("after 'play', use 'right' 'left'or 'continue' to move each player");
        System.out.println();
    }
    
    /**
    * Print welcome and list of commands.
    */
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to Tron2020!");
        System.out.print("The commands are: ");
        System.out.print("'help' 'play' 'quit'");
        System.out.println();
    }
    
    /**
    * Print winner of game.
    */
    private void showWinner(final Player winner) {
        System.out.println("The winner is: " + winner.toString());
    }
    
    /**
    * Start the game.
    */
    private void play() {
        final Game game = new Game();
        //register TUI into game
        game.registerListener(this);
        final Player winner = game.play();
        
        showWinner(winner);
    }
    
    /**
    * Start application.
    */
    public void start()
    {
        printWelcome();
        
        boolean finished = false;
        while (! finished) {
            final String[] commands = parser.getCommand();
            finished = processCommandMenu(commands[0]);
        }
        
        System.out.println("Thank you for riding. Good bye.");
    }
    
    /**
    * Read the user commands when playing the match.
    * @param the current match.
    */
    private void readMatchCommand(final Match match) {
        final ArrayList<Player> players = match.returnPlayers();
        Command commandP1;
        Command commandP2;
        
        do {
            System.out.println("Where do you want to go?");
            final String[] commands = parser.getCommand();
            final String word1 = commands[0];
            final String word2 = commands[1];
            //case where ne of the two words is null:
            //if word is null, just go straight (see processCommandMenu)
            commandP1 = processCommandMatch(word1, players.get(0));
            commandP2 = processCommandMatch(word2, players.get(1));
        } while (commandP1 == null || commandP2 == null);
        
        match.addCommand(commandP1);
        match.addCommand(commandP2);
    }
    
    /**
    * Printer player information before the tick and get new command from user.
    * @param match The current match.
    */
    public void beforeTick(final Match match) {
        final ArrayList<Player> players = match.returnPlayers();
        // print snake
        for (final Player player : players) {
            System.out.print(player.toString() + ": ");
            player.printSnake();
        }
        
        // get new command from user
        readMatchCommand(match);
    }
    
    /**
    * Register TUI object into match.
    * @param match The current match.
    */
    public void beforeMatch(final Match match) {
        //register TUI into match
        match.registerListener(this);
    }
    
    /**
    * Print winner of match and lives of players.
    * @param winner The winner of the match.
    * @param match The current match.
    */
    public void afterMatch(final Player winner, final  Match match) {
        if (winner != null) {
            System.out.println("Winner: " + winner.toString());
        } else {
            System.out.println("Draw");
        }
        
        final ArrayList<Player> players = match.returnPlayers();
        for (final Player player : players) {
            System.out.println(player.toString() + " has " + player.getLives() + " lives.");
        }
    }
    
    public void afterGame(final Player gameWinner) {
        System.out.println("The winner is: " + gameWinner.toString());
    }
}
