
/**
 * Write a description of class Match here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GraphicalMatch extends Match
{
    private float speed = Setting.initialSpeed;
    
    public GraphicalMatch(Player p1, Player p2){
        super(p1, p2);
    }
    
    /**
     * Compute the winner of the match. 
     * @return winner of the match.
     */
    public int tick() {
        //set dir in caso
        
        
        // update snake
        p1.nextPosition();
        p2.nextPosition();
        
        //need border of game and check player doesn't collide into it.
        //check collisions: head-head, self-self, p1-p2
        //Note: checkCollision takes care of head-head collision + p1 p2 collision
        boolean dead1 = p1.checkCollision(p2) || p1.checkCollisionSelf();
        boolean dead2 = p2.checkCollision(p1) || p2.checkCollisionSelf();
        
        // 0 -> no collision, start new tick, -1 -> both collision, 1 -> p1 wins, 2 -> p2 wins
        if (dead1 && dead2) {
            return -1;
        }
        if (dead2) {
            return 1;
        }
        if (dead1) {
            return 2;
        }
        // draw
        return 0;
    }
    
    /**
     * Start the match. 
     * @return winner of the match.
     */
    public Player play() {
        // while (true) {
            // long tickStart = System.currentTimeMillis();
            // // return the winner player when a player wins
            // int result = tick();
            // switch(result){
                // case -1: 
                    // return null;
                // case 1:
                    // return this.p1;
                // case 2:
                    // return this.p2;
            // }
            
            // long tickEnd = System.currentTimeMillis();
            
            // long ellapsedTime = tickEnd - tickStart;
            // long sleep = (long)(1000 / (Setting.tickPerSecond * speed)) - ellapsedTime;
            // if (sleep < 0) {
                // sleep = 0;
            // }
            
            // speed += 0.001;
            // try {
                // Thread.sleep(sleep);
            // } catch (InterruptedException ex) {
                // Thread.currentThread().interrupt();
            // }
        // }
        return null;
    }
}
