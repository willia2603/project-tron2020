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
                            // TODO make it only accept commands.length == 2
                            String[] commands = input1.split(" ");
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

                                // #----- Above this is the collision part, I tried with two different approaches, Match happens to get
                                //        a null pointer exception, I will be doing debugging to see if I understand why it's happening.
                                //        It's important to find out to properly implement all cases of collision -----#

                                if (p1.checkCollision(p2) || p1.checkCollisionSelf()) {
                                    p1.die();
                                    System.out.println("p1 lost this round. p1 lives = " + p1.getLives());
                                    // resetting both players position to the default position of a match
                                    p1.createSnake(new Left(), new Coordinate(10, 10));
                                    p2.createSnake(new Right(), new Coordinate(12, 10));
                                } else if (p2.checkCollision(p1) || p2.checkCollisionSelf()) {
                                    p2.die();
                                    p1.createSnake(new Left(), new Coordinate(10, 10));
                                    p2.createSnake(new Right(), new Coordinate(12, 10));
                                    System.out.println("p2 lost this round. p2 lives = " + p2.getLives());
                                }
//                                if (n.checkCollision() == 1) {
//                                    p1.die();
//                                    System.out.println("p1 lost");
//                                    b1 = false;
//                                } else if (n.checkCollision() == 2) {
//                                    p2.die();
//                                    System.out.println("p2 lost");
//                                    b1 = false;
//                                } else if (n.checkCollision() == 0) {
//                                    p1.die();
//                                    p2.die();
//                                    System.out.println("matched ended in a draw");
//                                    b1 = false;
//                                }
                            } else {
                                // if it's not a valid player command continue asking for inputs.
                                System.out.println(input.printPlayerDefault() + "\"" + commands[0] + " " + commands[1] + "\"");
                            }
                        }
                        // you reach this section when one of the players has no more lives left. Print the winner.
                        System.out.println("\nThe winner is: " + p1.victorious(p2) + "!");
                        b = false;
                        break;

                    case "help":
                        input.printHelp();
                        break;

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