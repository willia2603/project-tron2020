import java.util.ArrayList;

/**
 * Duplicate of class Player to avoid merge conflicts
 */
public class nPlayer {

        private Snake snake;
        private int lives;

        /**
         * Constructor for objects of class Player
         */
        public nPlayer(final int i) {
            lives = i;
        }

        /**
         * Create a snake for a given Player.
         * @param direction initial direction a snake is initially facing.
         * @param init initial coordinate of the snake
         */
        public void createSnake(Direction direction, Coordinate init) {
            this.snake = new Snake(direction, init);
        }

        /**
         * return the snake of the player.
         * @return the snake of the player.
         */
        public Snake getSnake() {
            return snake;
        }

    /**
     * Check if current player collides with another player.
     * @param other The other player.
     * @return true if collision happens, false otherwise.
     */
    public boolean checkCollision(nPlayer other) {
        Coordinate head = this.snake.getHead();
        ArrayList<Coordinate> otherBody = other.getSnake().getBody();
        for (Coordinate c : otherBody) {
            if (head.equals(c)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check I collide into myself.
     * @return true if collision happens, false otherwise.
     */
    public boolean checkCollisionSelf() {
        Coordinate head = this.snake.getHead();
        ArrayList<Coordinate> myBody = this.getSnake().getBody();
        // remove head
        //myBody.remove(myBody.size() - 1);
        for (int i = 0; i < myBody.size() - 1; i++) {
            Coordinate c = myBody.get(i);
            if (head.equals(c)) {
                return true;
            }
        }
        return false;
    }

        public void nextPosition() {
            this.snake.nextPosition();
        }

        /**
         * Make player turn left.
         */
        public void goLeft() {
            Direction dir = new Left();
        }

        /**
         * Make player turn right.
         */
        public void goRight() {
            Direction dir = new Right();
        }

        /**
         * Make player turn right.
         */
        public void goUp() {
            Direction dir = new Up();
        }

        /**
         * Make player turn right.
         */
        public void goDown() {
            Direction dir = new Down();
        }

        /**
         * Remove a life from the player.
         */
        public void die() {
            lives--;
        }

        /**
         * Get the numbers of lives of a player.
         * @return the number of lives of the player.
         */
        public int getLives() {
            return lives;
        }

    /**
     * Switch case for all directions.
     * @param str a string given by System.in.
     */
    public void act(String str) {
            switch (str) {
                case "up":
                    snake.setDirection(new Up());
                    snake.nextPosition();
                    break;

                case "down":
                    snake.setDirection(new Down());
                    snake.nextPosition();
                    break;

                case "left":
                    snake.setDirection(new Left());
                    snake.nextPosition();
                    break;

                case "right":
                    snake.setDirection(new Right());
                    snake.nextPosition();
                    break;

                case "quit":
                    System.out.println("Thank you for playing.");
                    System.exit(0);
            }
        }

    /**
     * Check whether p1 or p2 won the game, by checking who has the most lives left.
     * @param p2 p1's opponent.
     * @return the winner.
     */
    public String victorious(nPlayer p2) {
        if (this.getLives() > p2.getLives()) {
            return "p1";
        } else {
            return "p2";
        }
    }

}


