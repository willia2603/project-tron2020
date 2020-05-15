import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class nPlayerTest {

        Coordinate c10_10, c20_10, c18_10;
        nPlayer p1, p2, p3, p4;


        /**
         * Default constructor for test class PlayerTest
         */
        public nPlayerTest()
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
            c18_10 = new Coordinate(19, 10);
            p1 = new nPlayer(3);
            p2 = new nPlayer(3);
            p3 = new nPlayer(3);
            p4 = new nPlayer(3);
            p1.createSnake(new Up(), c10_10);
            p2.createSnake(new Down(), c20_10);
            p3.createSnake(new Down(), c20_10);
            p4.createSnake(new Up(), c18_10);
        }

        @Test
        public void checkCollisionSelf() {
            assertFalse(p1.checkCollisionSelf());
            p1.act("up");
            p1.act("right");
            p1.act("down");
            p1.act("left");
            assertTrue(p1.checkCollisionSelf());
        }

        @Test
        public void checkCollision() {
            assertFalse(p1.checkCollision(p2));
            assertTrue(p1.checkCollision(p1));
            assertTrue(p2.checkCollision(p3));
            assertTrue(p3.checkCollision(p2));
            p3.act("left");
            p4.act("right");
            assertTrue(p3.checkCollision(p4));
            assertTrue(p4.checkCollision(p3));
            p3.createSnake(new Up(), new Coordinate(10, 9));
            p4.createSnake(new Down(), new Coordinate(10, 11));
            p3.act("up");
            p4.act("down");
            assertTrue(p3.checkCollision(p4));
            assertTrue(p4.checkCollision(p3));
            p1.createSnake(new Left(), new Coordinate(10, 11));
            p2.createSnake(new Right(), new Coordinate(12, 9));
            p1.act("right");
            p2.act("left");
            assertFalse(p1.checkCollision(p2));
            assertFalse(p2.checkCollision(p1));
        }



        @Test
        public void die() {
            p1.die();
            assertEquals(2, p1.getLives());
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
