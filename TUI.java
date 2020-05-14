
/**
 * Write a description of class TUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TUI
{
    private Parser parser;
    /**
     * Constructor for objects of class TUI
     */
    public TUI()
    {
        parser = new Parser();
    }

    public void start()
    {
        printWelcome();
        
        boolean finished = false;
        while (! finished) {
            MenuCommand command = parser.getCommand();
            finished = processCommand(command);
        }
        
        System.out.println("Thank you for riding.  Good bye.");
    }
    
    private boolean processCommand(MenuCommand command){
        boolean wantToQuit = false;
        switch (command) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case PLAY:
                play();
                break;

            case QUIT:
                return true;
        }
        return wantToQuit;
    }
    
    private void play(){
        
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
