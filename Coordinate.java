
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
    
    @Override
    /**
     * Check if two coordinates have the same values.
     * @param other The other coordinate.
     * @return true if the value is the same, false otherwise.
     */
    public boolean equals(final Object o) {
        if (o == this) { 
            return true; 
        }
        
        if (!(o instanceof Coordinate)) {
            return false;
        }
        
        final Coordinate c = (Coordinate) o;
        return c.getX() == x && c.getY() == y;
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + x;
        result = 31 * result + y;
        return result;
    }
    
    /**
     * Get String version of coordinate.
     * @return coordinate as a String.
     */
    @Override
    public String toString() {
        return "(" + this.getX() + "," + this.getY() + ")";
    }

}
