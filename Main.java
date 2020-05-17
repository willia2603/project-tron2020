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
        nPlayer p1 = new nPlayer(3);
        nPlayer p2 = new nPlayer(3);
        nMatch n = new nMatch(p1, p2);
        TextUserInterface input = new TextUserInterface();
        System.out.print("Type one of the available options: \"start\", \"help\" or \"quit\" ");
        boolean b = true;
        while (b) {
            System.out.print("\n> ");
            String words = input.getCommand().nextLine();
            // check if the given input is a valid command on the list of valid commands inside class TextUserInterface
            if (input.checkCommand(words)) {
                switch (words) {
                    case "start":
                        // starting a match below.
                        input.printStart();
                        // starting the game loop. True until any player has any life left.
                        while ((p1.getLives() != 0 && p2.getLives() != 0)) {
                            TextUserInterface nInput = new TextUserInterface();
                            System.out.print("\n> ");
                            String input1 = nInput.getCommand().nextLine();
                            // put all inputs from System.in into an array, every time you read a " " you add the following input as new command.
                            String[] commands = input1.split(" ");
                            if (commands.length == 2) {
                                // print what was given as command for player 1 and for player 2, respectively.
                                System.out.println("p1: " + commands[0] + " " + "p2: " + commands[1]);
                                // check is the commands are valid commands on the list of player commands inside class TextUserInterFace.
                                if (nInput.checkPlayerCommand(commands[0]) && nInput.checkPlayerCommand(commands[1])) {
                                    // p1 takes first argument and move accordingly.
                                    p1.act(commands[0]);
                                    // p2 takes second argument and move accordingly.
                                    p2.act(commands[1]);
                                    // print both players coordinates after the movement has happened.
                                    System.out.println("p1: (" + p1.getSnake().getHead().getX() + ", " + p1.getSnake().getHead().getY()
                                            + ") " + "p2: (" + p2.getSnake().getHead().getX() + ", " + p2.getSnake().getHead().getY() + ")");

                                    // #----- Collision Section -----#

                                    if (n.checkCollision() == 1) {
                                        p1.die();
                                        p1.createSnake(new Left(), new Coordinate(10, 10));
                                        p2.createSnake(new Right(), new Coordinate(12, 10));
                                        System.out.println("p1 lost this round. p1 lives = " + p1.getLives());
                                    } else if (n.checkCollision() == 2) {
                                        p2.die();
                                        p1.createSnake(new Left(), new Coordinate(10, 10));
                                        p2.createSnake(new Right(), new Coordinate(12, 10));
                                        System.out.println("p2 lost this round. p2 lives = " + p2.getLives());
                                    } else if (n.checkCollision() == 0) {
                                        p1.die();
                                        p2.die();
                                        p1.createSnake(new Left(), new Coordinate(10, 10));
                                        p2.createSnake(new Right(), new Coordinate(12, 10));
                                        System.out.println("matched ended in a draw. p1 lives = " + p1.getLives() +
                                                ", p2 lives = " + p2.getLives());
                                    }

                                    // #----- Error Handling Section -----#

                                } else {
                                    // if it's not a valid player command continue asking for inputs.
                                    System.out.println(input.printPlayerDefault() + "\"" + input1 + "\"");
                                }
                            } else {
                                System.out.println(input.printPlayerDefault() + "\"" + input1 + "\"");
                            }
                        }
                        System.out.println("\nThe winner is: " + p1.victorious(p2) + "!");
                        b = false;
                        break;

                    case "help":
                        input.printHelp();
                        break;

                    case "start gui":   // start the GUI application
                        input.printStart();
                        new Gui("Tron2020");

                    case "quit":
                        input.printQuit();
                        b = false;
                        break;
                }
                // if it's not a valid command, continue asking for inputs.
            } else {
                System.out.println(input.printDefault() + "\"" + words + "\"");
            }
        }
    }
}