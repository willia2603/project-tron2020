

/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Main
{   
    private Main () {}
    
    public static void run() {
        
        final Game game = new Game();
        final GUI gui = new GUI(game);
        game.play();
        
        //Match match = new Match(new Player("P1"), new Player("P2"));
        //GameFrame frame = new GameFrame(match);
        // match.beforeTick();
        
    }
    public static void main(final String[] arguments) {
        Main.run();
    }
}