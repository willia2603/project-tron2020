import java.util.Scanner;

/**
 * Write a description of class Parser here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Parser {
    private Scanner reader;

    /**
     * Constructor for objects of class Parser.
     */
    public Parser() {
        reader = new Scanner(System.in);
    }

    /**
     * Get commands from user.
     * 
     * @return array of Strings containing the commands.
     */
    public String[] getCommand() {
        String inputLine; // will hold the full input line
        String[] words = new String[2];

        System.out.print("> "); // print prompt

        inputLine = reader.nextLine();

        // Find up to two words on the line.
        final Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            words[0] = tokenizer.next();
            if (tokenizer.hasNext()) {
                words[1] = tokenizer.next(); // get second word
                // note: we just ignore the rest of the input line.
            }
        }

        return words;
    }
}
