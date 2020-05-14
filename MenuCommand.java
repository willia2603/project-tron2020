
/**
 * Enumeration class MenuCommand - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum MenuCommand
{
    PLAY("play"), QUIT("quit"), HELP("help"), UNKNOWN("?");
    
    // The command string.
    private String commandString;
    
    /**
     * Initialise with the corresponding command string.
     * @param commandString The command string.
     */
    MenuCommand(String commandString)
    {
        this.commandString = commandString;
    }
    
    /**
     * @return The command word as a string.
     */
    public String toString()
    {
        return commandString;
    }
}
