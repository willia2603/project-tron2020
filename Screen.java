import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Screen extends JPanel implements Runnable {

    public static final int WIDTH = 400, HEIGHT = 300;
    private boolean checker = false;
    private nPlayer p1 = new nPlayer(3);
    private nPlayer p2 = new nPlayer(3);
    private nMatch n = new nMatch(p1, p2);
    private int ticks = 0;


    /**
     * Screen constructor, to be initialized in class Gui.
     */
    public Screen() {
        setFocusable(true);
        Key k = new Key();
        addKeyListener(k);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        start();
    }

    /**
     * Tick is what happens at every cycle as fast as JVM can go,
     * this makes the game extremely heavy on the processor,
     * ideally has to be changed, but maybe it's acceptable for demo purposes.
     */
    public void tick() {
        if (!checker) {
            p1.createSnake(new Right(), new Coordinate(10, 10));
            p2.createSnake(new Left(), new Coordinate(30, 5));
            checker = true;
        }
        ticks++;
        if (ticks > 200000) {
            ticks = 0;
            p1.nextPosition();
            p2.nextPosition();
            int size = 15;
            if (p1.getSnake().getBody().size() > size) {
                p1.getSnake().getBody().remove(0);
                p2.getSnake().getBody().remove(0);
            }
        }
        if (n.checkCollision() == 1) {
            p1.die();
            JOptionPane.showMessageDialog(null, "Matched ended P1 lost. P1 lives = "
                    + p1.getLives() + ", P2 lives = " + p2.getLives());
            checker = false;
        } else if (n.checkCollision() == 2) {
            p2.die();
            JOptionPane.showMessageDialog(null, "Matched ended P2 lost. P1 lives = "
                    + p1.getLives() + ", P2 lives = " + p2.getLives());
            checker = false;
        } else if (n.checkCollision() == 0) {
            p1.die();
            p2.die();
            JOptionPane.showMessageDialog(null, "Tie match. P1 lives = "
                    + p1.getLives() + ", P2 lives = " + p2.getLives());
            checker = false;
        } else if (p1.checkCollisionWall(HEIGHT, WIDTH)) {
            p1.die();
            JOptionPane.showMessageDialog(null, "P1 has hit the wall!");
            checker = false;
        } else if (p2.checkCollisionWall(HEIGHT, WIDTH)) {
            p2.die();
            JOptionPane.showMessageDialog(null, "P2 has hit the wall!");
            checker = false;
        }
    }

    /**
     * The painter, draws the grid and the player's snake
     * @param g is a graphics.
     */
    public void paint(Graphics g) {
        g.clearRect(0, 0, WIDTH, HEIGHT);
        g.setColor(new Color(10, 50, 0));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.BLACK);
        for (int i = 0; i < WIDTH/10; i++) {
            g.drawLine(i * 10, 0, i * 10, HEIGHT);
        }
        for (int i = 0; i < HEIGHT/10; i++) {
            g.drawLine(0, i * 10, WIDTH, i * 10);
        }
        for (int i = 0; i < p1.getSnake().getBody().size(); i++) {
            p1.getSnake().getBody().get(i).draw(g, Color.GREEN);
            p2.getSnake().getBody().get(i).draw(g, Color.BLUE);
        }
    }

    /**
     * Used to Start the runnable.
     */
    public void start() {
        Thread t = new Thread(this, "game loop");
        t.start();
    }

    /**
     * Run the game until p1 or p2 lives is equal to zero.
     */
    public void run() {
        while(p1.getLives() != 0 && p2.getLives() != 0) {
            tick();
            repaint();
        }
        JOptionPane.showMessageDialog(null, "\nThe winner is: " + p1.victorious(p2) + "!");
        System.exit(0);
    }

    // #----- Anonymous class for movement handling -----#

    private class Key implements KeyListener {

        /**
         * Listener to capture key presses and address than as new Direction.
         * @param e is the key pressed on the keyboard.
         */
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            // moving right.
            if (key == KeyEvent.VK_RIGHT && !(p1.getSnake().getDirection() instanceof Left)) {
                p1.getSnake().setDirection(new Right());
            } else if (key == KeyEvent.VK_D && !(p2.getSnake().getDirection() instanceof Left)) {
                p2.getSnake().setDirection(new Right());
            }

            // moving left.
            if (key == KeyEvent.VK_LEFT && !(p1.getSnake().getDirection() instanceof Right)) {
                p1.getSnake().setDirection(new Left());
            } else if (key == KeyEvent.VK_A && !(p2.getSnake().getDirection() instanceof Right)) {
                p2.getSnake().setDirection(new Left());
            }

            // moving up.
            if (key == KeyEvent.VK_UP && !(p1.getSnake().getDirection() instanceof Down)) {
                p1.getSnake().setDirection(new Up());
            } else if (key == KeyEvent.VK_W && !(p2.getSnake().getDirection() instanceof Down)) {
                p2.getSnake().setDirection(new Up());
            }

            // moving down.
            if (key == KeyEvent.VK_DOWN && !(p1.getSnake().getDirection() instanceof Up)) {
                p1.getSnake().setDirection(new Down());
            } else if (key == KeyEvent.VK_S && !(p2.getSnake().getDirection() instanceof Up)) {
                p2.getSnake().setDirection(new Down());
            }
        }


        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

}
