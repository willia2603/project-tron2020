import static org.junit.Assert.*;
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

    @Test
    public void testGetLeftDirection() {
        assertTrue(l.getLeftDirection() instanceof Down);
        assertFalse(l.getLeftDirection() instanceof Left);
    }

    @Test
    public void testGetRightDirection() {
        assertTrue(l.getRightDirection() instanceof Up);
        assertFalse(l.getRightDirection() instanceof Right);
    }
}
