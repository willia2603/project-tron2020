
/**
 * Write a description of class GoUp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Continue implements Command
{   
    private final Player player;
    
    /**
     * Constructor for objects of class Continue.
     * @param player the player of the match.
     */
    public Continue(final Player player) {
        this.player = player;
    }
    
    /**
     * Do nothing.
     */
    public void execute() {
    }
}
