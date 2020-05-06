

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LeftTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class LeftTest {

    private Left l;

    /**
     * Default constructor for test class LeftTest
     */
    public LeftTest()
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
        l = new Left();
    }

    @Test
    public void actionOnX() {
        assertEquals(-1, l.actionOnX());
    }

    @Test
    public void actionOnY() {
        assertEquals(0, l.actionOnY());
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
