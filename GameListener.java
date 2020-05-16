
/**
 * Write a description of interface GameListener here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface GameListener
{   
    /**
     * What to do before the match.
     * @param  the match tthat is about to start.
     */
    void beforeMatch(Match match);
    
    /**
     * What to do after the match.
     * @param  the winner of the match
     * @param  the match that is about to start.
     */
    void afterMatch(Player player, Match match);
}
