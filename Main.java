
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
     * Run gui.
     */
    public static void runGui() {
        final Gui gui = new Gui();
        gui.start();
    }
    
    /**
     * Run tui.
     */
    public static void runTui() {
        final Tui tui = new Tui();
        tui.start();
    }

    /**
     * Run application.
     * @param arguments The command line arguments.
     */
    public static void main(final String[] arguments) {
        if (arguments.length == 0) {
            System.out.println("accepted arguments: tui or gui");
        } else if (arguments[0].equals("gui")) {
            Main.runGui();
        } else if (arguments[0].equals("tui")) {
            Main.runTui();
        } else {
            System.out.println("argument not valid");
        }
        
    }
}