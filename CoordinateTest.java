

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CoordinateTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CoordinateTest {

    private Coordinate c10_10, c20_10, c10_20, c20_20;

    /**
     * Default constructor for test class CoordinateTest
     */
    public CoordinateTest()
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
        c10_20 = new Coordinate(10, 20);
        c20_20 = new Coordinate(20, 20);
    }

    @Test
    public void getX() {
        assertEquals(10, c10_10.getX());
        assertEquals(20, c20_10.getX());
        assertNotEquals(0, c10_10.getX());
    }

    @Test
    public void getY() {
        assertEquals(20, c10_20.getY());
        assertEquals(10, c20_10.getY());
        assertNotEquals(0, c20_20.getY());
    }

    @Test
    public void equals() {
        assertTrue(c10_10.equals(c10_10));
        assertFalse(c10_20.equals(c20_10));
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
