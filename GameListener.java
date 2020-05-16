
/**
 * Write a description of interface GameListener here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface GameListener
{
    void beforeMatch(Match match);
    void afterMatch(Player player, Match match);
}
