
/**
 * Write a description of class GoUp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TurnLeft implements Command
{   
    private Player player;
    /**
     * Constructor for objects of class TurnLeft.
     * @param player the player of the match.
     */
    public TurnLeft(Player player) {
        this.player = player;
    }
    
    public void execute() {
        player.turnLeft();
    }
}
