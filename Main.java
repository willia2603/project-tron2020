///**
// * ...
// */
public class Main {

    private Main() {
        // never instantiated
    }

    /**
     * Run the application (from the command line).
     * @param args the command line arguments.
     */
    public static void main(final String[] args) {
        TextUserInterface input = new TextUserInterface();
        System.out.print("Type one of the available options: \"start\", \"help\" or \"quit\" ");
        boolean b = true;
        while (b) {
            System.out.print("\n> ");
            String words = input.getCommand().nextLine();
            // Switch is bad coding, I will put it into TUI Class eventually.
            if (input.checkCommand(words)) {
                switch (words) {
                    case "start":
                        input.printStart();
                        b = false;
                        break;
                    case "help":
                        input.printHelp();
                        b = false;
                        break;
                    case "quit":
                        input.printQuit();
                        b = false;
                        break;
                }
            } else {
                System.out.println(input.printDefault() + "\"" + words + "\"");
            }
        }
    }
}
//        final Model model = new Model();
//        final TextUserInterface tui = new TextUserInterface(model);
//        tui.run();