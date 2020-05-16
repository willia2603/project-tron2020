
/**
 * Write a description of class GoUp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TurnRight implements Command
{   
    private Player player;
    
    /**
     * Constructor for objects of class TurnRight.
     * @param player the player of the match.
     */
    public TurnRight(Player player) {
        this.player = player;
    }
    
    public void execute() {
        player.turnRight();
    }
}
