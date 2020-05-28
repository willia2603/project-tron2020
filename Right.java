
/**
 * Write a description of class Right here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Right implements Direction {
    /**
     * Return the value of x.
     * 
     * @return value of x.
     */
    public int actionOnX() {
        return 1;
    }

    /**
     * Return the value of y.
     * 
     * @return value of y.
     */
    public int actionOnY() {
        return 0;
    }

    /**
     * Return direction left to this one.
     * 
     * @return the new direction.
     */
    public Direction getLeftDirection() {
        return new Up();
    }

    /**
     * Return direction right to this one.
     * 
     * @return the new direction.
     */
    public Direction getRightDirection() {
        return new Down();
    }
}
