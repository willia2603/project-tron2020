
/**
 * Write a description of class GoUp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TurnRight implements Command
{   
    Player player;
    public TurnRight(Player player) {
        this.player = player;
    }
    
    public void execute() {
        player.turnRight();
    }
}
