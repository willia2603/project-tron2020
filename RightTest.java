import static org.junit.Assert.*;
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

    @Test
    public void testGetLeftDirection() {
        assertTrue(r.getLeftDirection() instanceof Up);
        assertFalse(r.getLeftDirection() instanceof Left);
    }

    @Test
    public void testGetRightDirection() {
        assertTrue(r.getRightDirection() instanceof Down);
        assertFalse(r.getRightDirection() instanceof Right);
    }
}
