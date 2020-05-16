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
    private final String[] menuCommands = {"help", "play", "quit"};

    public TUI()
    {
        parser = new Parser();
    }
    
    private boolean processCommandMenu(String userCommand) {
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
                System.out.println("I don't know what you mean...");
                break;
        }
        return false;
    }
    
    private Command processCommandMatch(String userCommand, Player player) {
        switch (userCommand) {
            case "left":
                return new TurnLeft(player);

            case "right":
                return new TurnRight(player);

            case "continue":
                return new Continue(player);
                
            default:
                System.out.println("I don't know what you mean...");
                return null;
        }
    }
    
    /**
    * Display available commands.
    */
    private void printHelp()
    {
        System.out.println("Each player has 3 lives, game ends when one reaches 0 lives");
        System.out.println("Play starts a new game");
        //System.out.println("\"" + MenuCommand.QUIT.toString() + "\" terminates this program");
    }
    
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to Tron2020!");
        System.out.print("The commands are: ");
        //parser.showCommands();
        System.out.println();
    }
    
    public void showWinner(Player winner){
       System.out.println("The winner is: " + winner.toString());
    }
    
    private void play() {
        Game game = new Game();
        //register TUI into game
        game.registerListener(this);
        Player winner = game.play();
        
        showWinner(winner);
    }
    
    public void start()
    {
        printWelcome();
        
        boolean finished = false;
        while (! finished) {
            String[] commands = parser.getCommand();
            finished = processCommandMenu(commands[0]);
        }
        
        System.out.println("Thank you for riding. Good bye.");
    }
    
    public void readMatchCommand(Match match) {
        ArrayList<Player> players = match.returnPlayers();
        Command commandP1;
        Command commandP2;
        
        do{
            System.out.println("Where do you want to go?");
            String[] commands = parser.getCommand();
            String word1 = commands[0];
            String word2 = commands[1];
            // todo: if write only 1 word, words2 is null and null pointer exception
            commandP1 = processCommandMatch(word1, players.get(0));
            commandP2 = processCommandMatch(word2, players.get(1));
        }while(commandP1 == null || commandP2 == null);
        
        match.addCommand(commandP1);
        match.addCommand(commandP2);
    }
    
    public void beforeTick(Match match){
        ArrayList<Player> players = match.returnPlayers();
        // print snake
        for(Player player : players){
            System.out.print(player.toString() + ": ");
            player.printSnake();
        }
        
        // get new command from user
        readMatchCommand(match);
    }
    
    public void beforeMatch(Match match){
        //register TUI into match
        match.registerListener(this);
    }
    
    public void afterMatch(Player winner, Match match){
        System.out.println("Winner: " + winner.toString());
        
        ArrayList<Player> players = match.returnPlayers();
        for(Player player : players){
            System.out.println(player.toString() + " has " + player.getLives() + " lives.");
        }
    }

}
