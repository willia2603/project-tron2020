import java.util.ArrayList;

/**
 * Write a description of class Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Game
{
    private ArrayList<GameListener> listeners;
    private final Player p1;
    private final Player p2;
    
    /**
     * Constructor for objects of class Game.
     */
    public Game() {
        this.listeners = new ArrayList<>();
        p1 = new Player("Player 1");
        p2 = new Player("Player 2");
    }
    
    /**
     * Register a listener.
     * @param listener The GameListener.
     */
    public void registerListener(final GameListener listener) {
        listeners.add(listener);
    }
    
    /**
     * Notify all listeners.
     * @param match The current match.
     */
    public void beforeMatch(final Match match) {
        for (final GameListener listener : listeners) {
            listener.beforeMatch(match);
        }
    }
    
    /**
     * Notify all listeners.
     * @param winner The winner of the match.
     * @param match The current match.
     */
    public void afterMatch(final Player winner, final Match match) {
        for (final GameListener listener : listeners) {
            listener.afterMatch(winner,match);
        }
    }
    
    /**
     * Return winner of the game.
     * @return winner of the match.
     */
    protected Player gameWinner() {
        if (p1.getLives() == 0) {
            return p2;
        } else {
            return p1;
        }
    }
    
    /**
     * Reduce lives of player.
     * @param player of the match.
     */
    protected void alive(final Player player) {
        if (p1 == player) {
            p2.die();
        } else if (p2 == player) {
            p1.die();
        }
    }
    
    /**
     * Continue game according to number of lives.
     * @return true if both players have at least 1 life, false otherwise.
     */
    public boolean continueGame() {
        return p1.getLives() > 0 && p2.getLives() > 0;
    }
    
    /**
     * Start game.
     * @return winner of the game.
     */
    public Player play()
    {
        while (this.continueGame()) {
            final Match match = new Match(this.p1, this.p2);
            beforeMatch(match);
            final Player winner = match.play();

            this.alive(winner);
            
            afterMatch(winner, match);
        }
        
        final Player gameWinner = this.gameWinner();
        return gameWinner;
    }
    
    /**
     * Register list of listeners (needed for testing).
     * @return array of game listeners.
     */
    public ArrayList<GameListener> returnListeners() {
        return this.listeners;
    }
    
    /**
     * Get players of game (needed for testing).
     * @param name The name of the player.
     * @return player that matches string.
     */
    public Player getPlayer(final String name) {
        if (name.equals(p1.toString())) {
            return this.p1;
        }
        
        if (name.equals(p2.toString())) {
            return this.p2;
        } else {
            return null;
        }
    }
}
