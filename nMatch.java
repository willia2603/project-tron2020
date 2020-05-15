/**
 * Duplicate of class Match to avoid merge conflicts
 */
public class nMatch {
        protected nPlayer p1;
        protected nPlayer p2;

        /**
         * Constructor for objects of class Match.
         * Set up match arena.
         */
    public nMatch(nPlayer p1, nPlayer p2) {
        this.p1 = p1;
        this.p2 = p2;
        Coordinate p1C = new Coordinate(10, 10);
        Coordinate p2C = new Coordinate(12, 10);
        Direction p1Dir = new Right();
        Direction p2Dir = new Left();
        p1.createSnake(p1Dir, p1C);
        p2.createSnake(p2Dir, p2C);
    }

    public int tick() {
        return 0;
    }

    public Player play() {
        return null;
    }

    protected void updateSnake(){
        p1.nextPosition();
        p2.nextPosition();
    }

        protected int checkCollision(){
        //need border of game and check player doesn't collide into it.
        //check collisions: head-head, self-self, p1-p2
        //Note: checkCollision takes care of head-head collision + p1 p2 collision
        boolean dead1 = p1.checkCollision(p2) || p1.checkCollisionSelf();
        boolean dead2 = p2.checkCollision(p1) || p2.checkCollisionSelf();

        // 0 -> no collision, start new tick, -1 -> both collision, 1 -> p1 wins, 2 -> p2 wins
        if (dead1 && dead2) {
            return 0;
        }
        if (dead2) {
            return 2;
        }
        if (dead1) {
            return 1;
        }
        // draw
        return -1;
    }
}
