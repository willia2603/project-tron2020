import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;

public class MatchTest {
    Game game = new Game();
    Player p1 = game.getPlayer("Player 1");
    Player p2 = game.getPlayer("Player 2");
    Match m = new Match(p1, p2);
    Tui listener = new Tui();
    ArrayList<MatchListener> listeners = new ArrayList<>();
    ArrayList<Command> commands = new ArrayList<>();

    @Test
    public void setUp() {
    }

    @Test
    public void testRegisterListener() {
        m.registerListener(listener);
        listeners.add(listener);
        assertNotNull(listeners.get(0));
    }

    @Test
    public void testReturnPlayers() {
        assertEquals(m.returnPlayers().get(0), p1);
        assertEquals(m.returnPlayers().get(1), p2);
    }

    @Test
    public void testUpdateSnake() {
        m.updateSnake();
        assertEquals(2, p1.getSnakeCopy().getBody().size());
        assertEquals(2, p2.getSnakeCopy().getBody().size());
    }

    @Test
    public void testBeforeTick() {
        m.beforeTick();
        assertEquals(0, commands.size());
    }

    @Test
    public void testTick() {
        Player p1 = game.getPlayer("Player 1");
        Player p2 = game.getPlayer("Player 2");
        Match m = new Match(p1, p2);
        m.tick();
        assertEquals(2, p1.getSnakeCopy().getBody().size());
        assertEquals(2, p2.getSnakeCopy().getBody().size());
    }
}
