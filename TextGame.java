
/**
 * Write a description of class TextGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TextGame extends Game
{
    /**
     * Constructor for objects of class TextGame
     */
    public TextGame()
    {
        super();
    }


    public Player play()
    {
        while(this.continueGame()){
            Match match = new TextMatch(this.p1, this.p2);
            Player winner = match.play();
            
            this.alive(winner);
        }
        
        return this.gameWinner();
    }
}
