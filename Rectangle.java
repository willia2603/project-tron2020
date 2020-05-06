
/**
 * Write a description of class Rectangle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rectangle
{
    private Coordinate topLeft;
    private Coordinate bottomRight;

    /**
     * Constructor for objects of class Rectangle
     */
    public Rectangle(Coordinate topLeft, Coordinate bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }
    
    /**
     * Return the top left coordinate of the rectangle.
     * @return coordinate of left rectangle.
     */
    public Coordinate getTopLeft() {
        return topLeft;
    }
    
    /**
     * Return the bottom right coordinate of the rectangle.
     * @return coordinate of bottom right.
     */
    public Coordinate getBottomRight() {
        return bottomRight;
    }
}
