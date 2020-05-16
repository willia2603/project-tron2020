
/**
 * Write a description of class GoUp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class TurnLeft implements Command
{   
    private final Player player;
    
    /**
     * Constructor for objects of class TurnLeft.
     * @param player the player of the match.
     */
    public TurnLeft(final Player player) {
        this.player = player;
    }
    
    /**
     * Turn player left.
     */
    public void execute() {
        player.turnLeft();
    }
}
