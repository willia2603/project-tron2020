import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DownTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class UpTest {

    private Down u;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        u = new Down();
    }

    @Test
    public void testActionOnX() {
        assertEquals(0, u.actionOnX());
    }

    @Test
    public void testActionOnY() {
        assertEquals(1, u.actionOnY());
    }

    @Test
    public void testGetLeftDirection() {
        assertTrue(u.getLeftDirection() instanceof Left);
        assertFalse(u.getLeftDirection() instanceof Right);
    }

    @Test
    public void testGetRightDirection() {
        assertTrue(u.getRightDirection() instanceof Right);
        assertFalse(u.getRightDirection() instanceof Left);
    }
}
