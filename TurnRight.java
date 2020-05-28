
/**
 * Write a description of class GoUp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TurnRight implements Command {
    private final Player player;

    /**
     * Constructor for objects of class TurnRight.
     * 
     * @param player the player of the match.
     */
    public TurnRight(final Player player) {
        this.player = player;
    }

    /**
     * Turn player right.
     */
    public void execute() {
        player.turnRight();
    }
}
