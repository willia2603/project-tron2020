

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class UpTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class UpTest {

    private Up u;

    /**
     * Default constructor for test class UpTest
     */
    public UpTest()
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
        u = new Up();
    }

    @Test
    public void actionOnX() {
        assertEquals(0, u.actionOnX());
    }

    @Test
    public void actionOnY() {
        assertEquals(1, u.actionOnY());
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
