import java.util.HashMap;
/**
 * Write a description of class MenuCommands here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MenuCommands
{
    private HashMap<String, MenuCommand> validCommands;

    /**
     * Constructor for objects of class MenuCommands
     */
    public MenuCommands()
    {
        validCommands = new HashMap<>();
        for(MenuCommand command : MenuCommand.values()) {
            if(command != MenuCommand.UNKNOWN) {
                validCommands.put(command.toString(), command);
            }
        }
    }

    /**
     * Find the CommandWord associated with a command word.
     * @param commandWord The word to look up.
     * @return The CommandWord correspondng to commandWord, or UNKNOWN
     *         if it is not a valid command word.
     */
    public MenuCommand getMenuCommand(String userCommand)
    {
        MenuCommand command = validCommands.get(userCommand);
        if(command != null) {
            return command;
        } else {
            return MenuCommand.UNKNOWN;
        }
    }
    
    /**
     * Check whether a given String is a valid command word. 
     * @return true if it is, false if it isn't.
     */
    public boolean isCommand(String userString)
    {
        return validCommands.containsKey(userString);
    }

    /**
     * Print all valid commands to System.out.
     */
    public void showAll() 
    {
        for(String command : validCommands.keySet()) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
