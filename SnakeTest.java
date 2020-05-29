import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The test class SnakeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SnakeTest {

    @Test
    public void testGetHeadPositive() {
        // it would be good to have a method to return both x and y.
        Snake s1 = new Snake(new Right(), new Coordinate(10, 10));
        assertEquals(new Coordinate(10, 10).getX(), (s1.getHead().getX()));
        assertEquals(new Coordinate(10, 10).getY(), (s1.getHead().getY()));
    }
    
    @Test
    public void testGetHeadNegative() {
        // negative as in position negative or returning false? I Assumed negative position.
        Snake s1 = new Snake(new Right(), new Coordinate(-10, -10));
        assertEquals(new Coordinate(-10, -10).getX(), (s1.getHead().getX()));
        assertEquals(new Coordinate(-10, -10).getY(), (s1.getHead().getY()));
    }
    
    @Test
    public void testNextPositionPositive() {
        Snake s1 = new Snake(new Right(), new Coordinate(15, 15));
        s1.nextPosition();
        assertEquals(16, s1.getBody().get(1).getX());
        assertEquals(15, s1.getBody().get(1).getY());
    }
    
    @Test
    public void testNextPositionNegative() {
        // I assumed negative as in position.
        Snake s1 = new Snake(new Left(), new Coordinate(0, 0));
        s1.nextPosition();
        assertEquals(-1, s1.getBody().get(1).getX());
        assertEquals(0, s1.getBody().get(1).getY());
    }
    
    @Test
    public void testSetDirection() {
        Direction r = new Right();
        Snake s1 = new Snake(new Left(), new Coordinate(10, 10));
        s1.setDirection(r);
        assertEquals(r, s1.getDirection());
    }
    
    @Test
    public void testGetDirection() {
        Snake s1 = new Snake(new Up(), new Coordinate(10, 10));
        assertTrue(s1.getDirection() instanceof Up);
    }
    
    @Test
    public void testGetBody() {
        Snake s1 = new Snake(new Up(), new Coordinate(10, 10));
        Snake s2 = new Snake(new Up(), new Coordinate(10, 10));
        ArrayList<Coordinate> body1 = s1.getBody();
        ArrayList<Coordinate> body2 = s2.getBody();
        for (int i = 0; i < body1.size(); i++) {
            assertEquals(body1.get(i), body2.get(i));
        }
    }
}
