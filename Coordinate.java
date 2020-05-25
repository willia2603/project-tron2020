import java.awt.*;

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
     * @return coordinate as a String.
     */
    @Override
    public String toString() {
        return "(" + this.getX() + "," + this.getY() + ")";
    }

    /**
     * Draw a rectangle at given coordinate.
     * @param graphics the graphic to be used in the Screen class.
     * @param color the color of the rectangles (represent the snake's color).
     */
    public void draw(final Graphics graphics, final Color color) {
        graphics.setColor(color);
        graphics.fillRect(getX() * 10, getY() * 10, 10, 10);
        graphics.setColor(color);
        graphics.fillRect(getX() * 10 + 2, getY() * 10 + 2, 10 - 4, 10 - 4);
    }

}
