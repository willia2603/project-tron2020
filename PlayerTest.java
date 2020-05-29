import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PlayerTest.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PlayerTest {

    Coordinate c10_10, c20_10, c18_10;
    Snake s1, s2;
    Player p1, p2, p3, p4, p5, p6, p7;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        c10_10 = new Coordinate(10, 10);
        c20_10 = new Coordinate(20, 10);
        c18_10 = new Coordinate(19, 10);

        p1 = new Player("p1");
        p2 = new Player("p2");
        p3 = new Player("p3");
        p4 = new Player("p4");
        p5 = new Player("p5");
        p6 = new Player("p6");
        p7 = new Player("p7");

        p1.createSnake(new Up(), c10_10);
        p2.createSnake(new Down(), c20_10);
        p3.createSnake(new Down(), c20_10);
        p4.createSnake(new Up(), c18_10);
        p5.createSnake(new Down(), c18_10);
        p6.createSnake(new Right(), c18_10);
        p7.createSnake(new Left(), c18_10);

        s1 = new Snake(new Up(), c10_10);
        s2 = new Snake(new Down(), c20_10);
    }

    @Test
    public void testCreateSnake() {
        Player p20 = new Player("P20");
        p20.createSnake(new Up(), c10_10);
        assertEquals(p20.getSnakeCopy().getBody(), p1.getSnakeCopy().getBody());
    }

    // check it again
    @Test
    public void testGetSnakeCopy() {
        Player p20 = new Player("P20");
        p20.createSnake(new Up(), c10_10);
        ArrayList<Coordinate> body = p20.getSnakeCopy().getBody();
        assertEquals(body, p1.getSnakeCopy().getBody());
    }

    @Test
    public void checkCollision() {
        assertFalse(p1.checkCollision(p2));
        assertTrue(p1.checkCollision(p1));
        assertTrue(p2.checkCollision(p3));
        assertTrue(p3.checkCollision(p2));
    }

    @Test
    public void checkCollisionSelf() {
        assertFalse(p1.checkCollisionSelf());
    }

    @Test
    public void testNextPosition() {
        int newHeadX = p1.getSnakeCopy().getHead().getX();
        int newHeadY = p1.getSnakeCopy().getHead().getY() - 1;
        Coordinate newHead = new Coordinate(newHeadX, newHeadY);
        p1.nextPosition();
        assertEquals(newHead.getX(), p1.getSnakeCopy().getHead().getX());
        assertEquals(newHead.getY(), p1.getSnakeCopy().getHead().getY());
    }

    @Test
    public void testTurnLeft() {
        p1.turnLeft();
        p5.turnLeft();
        p6.turnLeft();
        p7.turnLeft();
        assertTrue(p1.getSnakeCopy().getDirection() instanceof Left);
        assertTrue(p5.getSnakeCopy().getDirection() instanceof Right);
        assertTrue(p6.getSnakeCopy().getDirection() instanceof Up);
        assertTrue(p7.getSnakeCopy().getDirection() instanceof Down);
    }

    @Test
    public void testTurnRight() {
        p1.turnRight();
        p5.turnRight();
        p6.turnRight();
        p7.turnRight();
        assertTrue(p5.getSnakeCopy().getDirection() instanceof Left);
        assertTrue(p1.getSnakeCopy().getDirection() instanceof Right);
        assertTrue(p7.getSnakeCopy().getDirection() instanceof Up);
        assertTrue(p6.getSnakeCopy().getDirection() instanceof Down);

    }

    @Test
    public void die() {
        p1.die();
        assertEquals(2, p1.getLives());
    }

    @Test
    public void testGetLives() {
        assertEquals(3, p7.getLives());
    }

    @Test
    public void testToString() {
        Player p21 = new Player("p1");
        assertEquals(p21.toString(), p1.toString());
    }

}
