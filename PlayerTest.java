

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PlayerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PlayerTest {

    Coordinate c10_10, c20_10;
    Snake s1, s2;
    Player p1, p2;


    /**
     * Default constructor for test class PlayerTest
     */
    public PlayerTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        c10_10 = new Coordinate(10, 10);
        c20_10 = new Coordinate(20, 10);
        s1 = new Snake(new Up(), c10_10);
        s2 = new Snake(new Down(), c20_10);
        p1 = new Player();
        p2 = new Player();
        p1.setSnake(s1);
        p2.setSnake(s2);
    }

    @Test
    public void getSnake() {
        assertEquals(s1, p1.getSnake());
        assertNotEquals(s2, p1.getSnake());
        assertEquals(s2, p2.getSnake());
        assertNotEquals(s1, p2.getSnake());
    }

    @Test
    public void checkCollision() {
        //TODO
    }

    @Test
    public void die() {
        p1.die();
        assertEquals(2, p1.getLives());
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
