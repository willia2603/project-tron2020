

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RightTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RightTest {

    private Right r;

    /**
     * Default constructor for test class RightTest
     */
    public RightTest()
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
        r = new Right();
    }

    @Test
    public void actionOnX() {
        assertEquals(1, r.actionOnX());
    }

    @Test
    public void actionOnY() {
        assertEquals(0, r.actionOnY());
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
