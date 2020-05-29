

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
    public void testActionOnX() {
        assertEquals(0, d.actionOnX());
    }

    @Test
    public void testActionOnY() {
        assertEquals(1, d.actionOnY());
    }

    @Test
    public void testGetLeftDirection() {
        assertTrue(d.getLeftDirection() instanceof Right);
        assertFalse(d.getLeftDirection() instanceof Left);
    }

    @Test
    public void testGetRightDirection() {
        assertTrue(d.getRightDirection() instanceof Left);
        assertFalse(d.getRightDirection() instanceof Right);
    }
}
