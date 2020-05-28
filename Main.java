
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Main {

    /**
     * Constructor of class Main.
     */
    private Main() {
    }

    /**
     * SetUp and run.
     */
    public static void run() {

        final Game game = new Game();
        final Gui gui = new Gui(game);
        game.play();

        // Match match = new Match(new Player("P1"), new Player("P2"));
        // GameFrame frame = new GameFrame(match);
        // match.beforeTick();

    }

    /**
     * Run application.
     * @param arguments The command line arguments.
     */
    public static void main(final String[] arguments) {
        Main.run();
    }
}