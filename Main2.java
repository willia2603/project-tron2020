import javax.swing.JFrame;

/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Main2
{
    public static void run() {
        
        Game game = new Game();
        GUI2 gui = new GUI2(game);
        game.play();
        
        //Match match = new Match(new Player("P1"), new Player("P2"));
        //GameFrame frame = new GameFrame(match);
        // match.beforeTick();
        
    }
    public static void main(String[] arguments) {
        Main2.run();
    }
}