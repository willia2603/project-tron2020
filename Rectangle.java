
/**
 * Write a description of class Rectangle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rectangle
{
    private Coordinate diagPoint1;
    private Coordinate diagPoint2;

    /**
     * Constructor for objects of class Rectangle
     */
    public Rectangle(Coordinate diagPoint1, Coordinate diagPoint2) {
        this.diagPoint1 = diagPoint1;
        this.diagPoint2 = diagPoint2;
    }
    
    /**
     * Return the top left coordinate of the rectangle.
     * @return coordinate of left rectangle.
     */
    public Coordinate getDiagPoint1() {
        return diagPoint1;
    }
    
    /**
     * Return the bottom right coordinate of the rectangle.
     * @return coordinate of bottom right.
     */
    public Coordinate getDiagPoint2() {
        return diagPoint2;
    }
}
