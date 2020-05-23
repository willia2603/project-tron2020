/**
 * Interface class Direction - write a description of the class here.
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public interface Direction
{   
    /**
     * Define what happens with x.
     * @return value of x.
     */
    public abstract int actionOnX();
    
    /**
     * Define what happens with y.
     * @return value of y.
     */
    public abstract int actionOnY();
    
    public abstract Direction getLeftDirection();
    
    public abstract Direction getRightDirection();
}
