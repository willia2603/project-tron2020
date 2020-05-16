

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DownTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DownTest {

    private Down d;

    /**
     * Default constructor for test class DownTest
     */
    public DownTest()
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
        d = new Down();
    }

    @Test
    public void actionOnX() {
        assertEquals(0, d.actionOnX());
    }

    @Test
    public void actionOnY() {
        assertEquals(1, d.actionOnY());
    }

}
