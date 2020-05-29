import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The test class GameTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class GameTest {
    Game game = new Game();
    Player p1 = game.getPlayer("Player 1");
    Player p2 = game.getPlayer("Player 2");
    Tui listener = new Tui();
    ArrayList<GameListener> listeners = new ArrayList<>();

    @Test
    public void testRegisterListenerPositive() {
        game.registerListener(listener);
        listeners.add(listener);
        assertEquals(listeners.get(0), game.returnListeners().get(0));
    }

    @Test
    public void testRegisterListenerNegative() {
        game.registerListener(listener);
        listeners.add(listener);
        assertNull(listeners.get(1));
    }
    
    @Test
    public void testGameWinner() {
        p1.die();
        p1.die();
        p1.die();
        System.out.println(game.gameWinner());
        assertEquals(p2, game.gameWinner());
    }
    
    @Test
    public void testAlive() {
        Player p1 = game.getPlayer("Player 1");
        game.alive(p1);
        Player p2 = game.getPlayer("Player 2");
        assertEquals(2, p2.getLives());
        game.alive(p2);
        assertEquals(2, p1.getLives());
        game.alive(p2);
        assertEquals(1, p1.getLives());
        game.alive(p2);
        assertEquals(0, p1.getLives());
    }
    
    @Test
    public void testContinueGamePositive(){
        p1.die();
        p2.die();
        assertTrue(game.continueGame());
    }
    
    @Test
    public void testContinueGameNegative(){
        p1.die();
        p2.die();
        p2.die();
        p2.die();
        assertFalse(game.continueGame());
    }
    
    @Test
    public void testReturnListeners() {
        assertEquals(listeners, game.returnListeners());
    }

    @Test
    public void testGetPlayer() {
        assertEquals(game.getPlayer("Player 1"), p1);
        assertEquals(game.getPlayer("Player 2"), p2);
        assertNotEquals(game.getPlayer("Player 2"), p1);
        assertNotEquals(game.getPlayer("Player 1"), p2);
    }
}
