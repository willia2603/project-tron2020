
/**
 * Write a description of class Down here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Down implements Direction {
    /**
     * Return the value of x.
     * 
     * @return value of x.
     */
    public int actionOnX() {
        return 0;
    }

    /**
     * Return the value of y.
     * 
     * @return value of y.
     */
    public int actionOnY() {
        return 1;
    }

    /**
     * Return direction left to this one.
     * 
     * @return the new direction.
     */
    public Direction getLeftDirection() {
        return new Right();
    }

    /**
     * Return direction right to this one.
     * 
     * @return the new direction.
     */
    public Direction getRightDirection() {
        return new Left();
    }
}
