//
//
//import static org.junit.Assert.*;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
///**
// * The test class PlayerTest.
// *
// * @author  (your name)
// * @version (a version number or a date)
// */
//public class PlayerTest {
//
//    Coordinate c10_10, c20_10, c18_10;
//    Snake s1, s2;
//    Player p1, p2, p3, p4;
//
//
//    /**
//     * Default constructor for test class PlayerTest
//     */
//    public PlayerTest()
//    {
//    }
//
//    /**
//     * Sets up the test fixture.
//     *
//     * Called before every test case method.
//     */
//    @Before
//    public void setUp()
//    {
//        c10_10 = new Coordinate(10, 10);
//        c20_10 = new Coordinate(20, 10);
//        c18_10 = new Coordinate(19, 10);
//        p1 = new Player();
//        p2 = new Player();
//        p3 = new Player();
//        p4 = new Player();
//        p1.createSnake(new Up(), c10_10);
//        p2.createSnake(new Down(), c20_10);
//        p3.createSnake(new Down(), c20_10);
//        p4.createSnake(new Up(), c18_10);
//        s1 = new Snake(new Up(), c10_10);
//        s2 = new Snake(new Down(), c20_10);
//    }
//
//    @Test
//    public void checkCollisionSelf() {
//        p1.checkCollisionSelf();
//    }
//
//    @Test
//    public void checkCollision() {
//        assertFalse(p1.checkCollision(p2));
//        assertTrue(p1.checkCollision(p1));
//        assertTrue(p2.checkCollision(p3));
//        assertTrue(p3.checkCollision(p2));
////        p3.Act("left");
////        p4.Act("right");
////        assertTrue(p3.checkCollision(p4));
////        assertTrue(p4.checkCollision(p3));
//    }
//
//
//
//    @Test
//    public void die() {
//        p1.die();
//        assertEquals(2, p1.getLives());
//    }
//
//    /**
//     * Tears down the test fixture.
//     *
//     * Called after every test case method.
//     */
//    @After
//    public void tearDown()
//    {
//    }
//}
