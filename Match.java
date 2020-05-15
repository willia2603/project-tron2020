import java.util.ArrayList;
/**
 * Write a description of class Match here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Match
{
    ArrayList<MatchListener> listeners;
    //add list of commands
    ArrayList<Command> commands;
    protected Player p1;
    protected Player p2;

    /**
     * Constructor for objects of class Match. 
     * Set up match arena.
     */
    public Match(Player p1, Player p2) {
        this.listeners = new ArrayList<>();
        this.commands = new ArrayList<>();
        this.p1 = p1;
        this.p2 = p2;
        Coordinate p1Coord = new Coordinate(10, 10);
        Coordinate p2Coord = new Coordinate(20, 10);
        Direction p1Dir = new Right();
        Direction p2Dir = new Left();
        p1.createSnake(p1Dir, p1Coord);
        p2.createSnake(p2Dir, p2Coord);
    }
   
    public void registerListener(MatchListener listener) {
        listeners.add(listener);
    }
    
    /**
     * Compute the winner of the match. 
     * @return winner of the match.
     */
    public int tick() {
        // update snake
        this.updateSnake();
        
        int result = this.checkCollision();
        
        return result;
    }
    
    /**
     * Start the match. 
     * @return winner of the match.
     */
    public Player play() {
        while (true) {
            beforeTick();
            
            // read command
            // todo want to quit
            //updateSnakeDirection();
            
            int result = tick();
            
            //afterTick
            switch(result){
                case 0:
                    continue;
                case -1: 
                    //System.out.println("You died at the same time.");
                    return null;
                case 1:
                    //System.out.println("Match won by Player 1");
                    return this.p1;
                case 2:
                    //System.out.println("Match won by Player 2");
                    return this.p2;
                default:
                    //condition should be true. if false, if enters here, error is reported
                    assert(false);
            }
            
        }
    }
    
    public void addCommand(Command command) {
        commands.add(command);
    }
    //new
    private void beforeTick() {
        for (MatchListener listener : listeners) {
            listener.beforeTick(this);
        }
        //execute all current commands
        //loop over all commands
        //set the new directoin
        for (Command command : commands) {
            command.execute();
        }
        commands.clear();
    }
    //new
    public ArrayList<Player> returnPlayers() {
        ArrayList players = new ArrayList();
        players.add(p1);
        players.add(p2);
        return players;
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
}
