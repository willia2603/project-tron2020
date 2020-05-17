import java.util.Scanner;

/**
 * Provides de TUI for the game.
 */
public class TextUserInterface {
    private Scanner command = new Scanner(System.in);

    /**
     * From the course textbook Chapter 8.
     * Available user commands.
     */
    private static final String[] validCommands = {
            "start", "help", "quit", "start gui"
    };

    private static final String[] playerCommands = {
            "up", "down", "left", "right", "quit"
    };

    /**
     * Default command getter.
     * @return command.
     */
    public Scanner getCommand() {
        return command;
    }
    
    /**
     * From the course textbook Chapter 8.
     * Iterates through a list of possible valid commands.
     * @return True if a valid command has been found, false otherwise.
     */
    public boolean checkCommand(String str) {
        for (String s: validCommands) {
            if (s.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Prints a message for now, will start the game later.
     */
    public void printStart()
    {
        System.out.println("New Game Starts");
    }

    /**
     * Display available commands.
     */
    public void printHelp()
    {
        System.out.println("Start command starts a new game");
        System.out.println("Quit command terminates this program");
        System.out.println("Use the arrow keys to move around the board");
        System.out.println("Each player has 3 lives, game ends when one reaches 0 lives");
    }

    /**
     * Politely terminates the program.
     */
    public void printQuit()
    {
        System.out.println("GoodBye");
    }

    /**
     * Default String for miss inputs.
     * @return an error String.
     */
    public String printDefault() {
        return "The commands are: \"start\", \"start gui\", \"help\", \"quit\". " + "You typed: ";
    }

    public String printPlayerDefault() {
        return "The commands are: \"up\", \"down\", \"left\", \"right\", \"quit\". i.e: down left. You Typed: ";
    }

    public boolean checkPlayerCommand(String str) {
        for (String s : playerCommands) {
            if (s.equals(str)) {
                return true;
            }
        }
        return false;
    }
}