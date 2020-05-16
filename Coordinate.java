
/**
 * Write a description of class Coordinate here.
 *
 * @author Tron2020 Team
 * @version Alpha
 */
public class Coordinate
{
    private final int x;
    private final int y;

    /**
     * Constructor for objects of class Coordinate.
     * @param x The x coordinate.
     * @param y The y coordinate.
     */
    public Coordinate(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Return x coordinate.
     * @return the x coordinate.
     */
    public int getX() {
        // put your code here
        return x;
    }
    
    /**
     * Return y coordinate.
     * @return the y coordinate.
     */
    public int getY() {
        // put your code here
        return y;
    }
    
    /**
     * Check if two coordinates have the same values.
     * @param other The other coordinate.
     * @return true if the value is the same, false otherwise.
     */
    public boolean equals(final Coordinate other) {
        return other.getX() == x && other.getY() == y;
    }
    
    /**
     * Get String version of coordinate.
     * @return coodinate as a String.
     */
    @Override
    public String toString() {
        return "(" + this.getX() + "," + this.getY() + ")";
    }

}
