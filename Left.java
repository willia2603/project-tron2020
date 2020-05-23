
/**
 * Write a description of class Left here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Left implements Direction
{

    
    /**
     * Return the value of x.
     * @return value of x. 
     */
    public int actionOnX() {
        return -1;
    }
    //getLeftDirection --> return next direction that is left to this one
    //
    /**
     * Return the value of y.
     * @return value of y. 
     */
    public int actionOnY() {
        return 0;
    }
    
    public Direction getLeftDirection() {
        return  new Down();
    }
    
    public Direction getRightDirection() {
        return  new Up();
    }
}
