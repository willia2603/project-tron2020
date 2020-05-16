
/**
 * Write a description of class GoUp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TurnLeft implements Command
{   
    Player player;
    public TurnLeft(Player player) {
        this.player = player;
    }
    
    public void execute() {
        player.turnLeft();
    }
}
