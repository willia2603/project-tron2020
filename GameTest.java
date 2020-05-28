import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
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
    Command rightP1 = new TurnRight(p1);
    Command rightP2 = new TurnRight(p2);
    Command leftP1 = new TurnLeft(p1);
    Command leftP2 = new TurnLeft(p2);
    ArrayList<GameListener> listeners = new ArrayList<>();
    @Test
    public void testRegisterListenerPositive() {
        game.registerListener(listener);
        listeners.add(listener);
        assertEquals(listeners.get(0), game.returnListeners().get(0));
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
        game.alive(p1);
        Player p1 = game.getPlayer("Player 1");
        Player p2 = game.getPlayer("Player 2");
        assertEquals(2, p2.getLives());
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
    
    
   
}
