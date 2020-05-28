import java.util.ArrayList;

/**
 * Write a description of class Match here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Match {
    private ArrayList<MatchListener> listeners;
    private ArrayList<Command> commands;
    protected Player p1;
    protected Player p2;

    /**
     * Constructor for objects of class Match.
     * 
     * @param p1 The first player.
     * @param p2 The second player.
     */
    public Match(final Player p1, final Player p2) {
        this.listeners = new ArrayList<>();
        this.commands = new ArrayList<>();
        this.p1 = p1;
        this.p2 = p2;
        final Coordinate p1Coord = new Coordinate(SettingsHelper.ARENA_WIDTH / 5, 
            SettingsHelper.ARENA_HEIGHT / 2);
        final Coordinate p2Coord = new Coordinate(4 * (SettingsHelper.ARENA_WIDTH / 5), 
            SettingsHelper.ARENA_HEIGHT / 2);
        final Direction p1Dir = new Right();
        final Direction p2Dir = new Left();
        p1.createSnake(p1Dir, p1Coord);
        p2.createSnake(p2Dir, p2Coord);
    }

    /**
     * Add listener.
     * 
     * @param listener The listener.
     */
    public void registerListener(final MatchListener listener) {
        listeners.add(listener);
    }

    /**
     * Add a command.
     * 
     * @param command the command of the user.
     */
    public void addCommand(final Command command) {
        commands.add(command);
    }

    /**
     * Return list of players.
     * 
     * @return list of players.
     */
    public ArrayList<Player> returnPlayers() {
        final ArrayList players = new ArrayList();
        players.add(p1);
        players.add(p2);
        return players;
    }

    /**
     * Update position of players.
     */
    protected void updateSnake() {
        p1.nextPosition();
        p2.nextPosition();
    }

    /**
     * Check if players collides.
     * 
     * @return -1 both players die, 1 first player dies, 2 first player dies, 0 no
     *         collsion.
     */
    protected int checkCollision() {
        // need border of game and check player doesn't collide into it.
        // check collisions: head-head, self-self, p1-p2
        // Note: checkCollision takes care of head-head collision + p1 p2 collision
        final boolean dead1 = p1.checkCollision(p2) 
            || p1.checkCollisionSelf() 
            || p1.checkCollisionBorder();

        final boolean dead2 = p2.checkCollision(p1) 
            || p2.checkCollisionSelf() 
            || p2.checkCollisionBorder();

        // 0 -> no collision, start new tick, -1 -> both collision, 1 -> p1 wins, 2 ->
        // p2 wins
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
     * Notify listeners and set player direction according to user string.
     */
    public void beforeTick() {
        // notify listeners when play is callled
        for (final MatchListener listener : listeners) {
            listener.beforeTick(this);
        }

        // set direction according to user string
        for (final Command command : commands) {
            command.execute();
        }
        commands.clear();
    }

    /**
     * Compute the winner of the match.
     * 
     * @return winner of the match.
     */
    public int tick() {
        // update snake
        this.updateSnake();

        final int result = this.checkCollision();

        return result;
    }

    /**
     * Start the match.
     * 
     * @return winner of the match.
     */
    public Player play() {
        while (true) {
            beforeTick();

            // read command
            // taken care by beforeTick()

            final int result = tick();
            // sleep to no draw all the time. Have tick every second.

            switch (result) {
                case 0:
                    continue;
                case -1:
                    return null;
                case 1:
                    return this.p1;
                case 2:
                    return this.p2;
                default:
                    // condition should be true. if false, if enters here,
                    // and error is reported
                    assert false;
                    break;
            }

        }
    }
}
