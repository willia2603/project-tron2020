import java.util.Scanner;

/**
 * Write a description of class Parser here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Parser
{
    private Scanner reader;         // source of command input
    private MenuCommands commands;
    /**
     * Constructor for objects of class Parser
     */
    public Parser()
    {
        commands = new MenuCommands();
        reader = new Scanner(System.in);
    }

    public MenuCommand getCommand() 
    {
        String inputLine;   // will hold the full input line
        String userCommand = null;

        System.out.print("> ");     // print prompt

        inputLine = reader.nextLine();

        // Find up to two words on the line.
        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            userCommand = tokenizer.next(); 
        }

        return commands.getMenuCommand(userCommand);
    }
    
    /**
     * Print out a list of valid command words.
     */
    public void showCommands()
    {
        commands.showAll();
    }
}
