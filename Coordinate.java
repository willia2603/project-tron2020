
/**
 * Write a description of class Coordinate here.
 *
 * @author Tron2020 Team
 * @version Alpha
 */
public class Coordinate
{
    private int x;
    private int y;

    /**
     * Constructor for objects of class Coordinate
     */
    public Coordinate(int x, int y) {
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
     * @return true if the value is the same, false otherwise.
     */
    public boolean equals(Coordinate other) {
        return other.getX() == x && other.getY() == y;
    }

    /**
     * Temporary Method so I can check the values inside the Coordinate Object.
     * @return x and y values of a Coordinate Object.
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /**
     * Testing manually the methods from the Snake class.
     */
    public static void main(String[] args) {
        Snake s1 = new Snake(new Right(), new Coordinate(15, 15));
        System.out.println(s1.getHead());
        s1.nextPosition();
        System.out.println(s1.getBody().get(1).getX());
    }

}
