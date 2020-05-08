

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MatchTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MatchTest {

    private Match m1;
    private Player p1, p2;
    private Snake s1, s2;
    private Coordinate c10_10, c20_10;


    /**
     * Default constructor for test class MatchTest
     */
    public MatchTest()
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
        c20_10 = new Coordinate(20, 10);
        c10_10 = new Coordinate(10, 10);
        s1 = new Snake(new Down(), c10_10);
        s2 = new Snake(new Down(), c20_10);
        //p1.setSnake(s1);
        //p2.setSnake(s2);
        m1 = new Match(p1, p2);
    }

    @Test
    public void tick() {
        //TODO
    }

    @Test
    public void play() {
        //TODO
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
