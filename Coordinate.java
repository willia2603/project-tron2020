
/**
 * Write a description of class Coordinate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Coordinate
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;

    /**
     * Constructor for objects of class Coordinate
     */
    public Coordinate(int x, int y)
    {
        // initialise instance variables
        this.x = x;
        this.y = y;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getX()
    {
        // put your code here
        return x;
    }
    
    public int getY()
    {
        // put your code here
        return y;
    }
    
    public boolean equals(Coordinate other) {
        return other.getX() == x && other.getY() == y;
    }
}
