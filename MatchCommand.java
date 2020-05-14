
/**
 * Enumeration class MatchCommand - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum MatchCommand
{
    UP("up", new Up()), DOWN("down", new Down()), LEFT("left", new Left()), RIGHT("right", new Right()), UNKNOWN("?", null);
    
    // The command string.
    private String commandString;
    private Direction direction;
    
    /**
     * Initialise with the corresponding command string.
     * @param commandString The command string.
     */
    MatchCommand(String commandString, Direction direction)
    {
        this.commandString = commandString;
        this.direction = direction;
    }
    
    public Direction getDirection() {
        return this.direction;
    }
    
    /**
     * @return The command word as a string.
     */
    public String toString()
    {
        return this.commandString;
    }
}
