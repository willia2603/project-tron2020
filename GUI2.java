
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Write a description of class GameFrame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GUI2 extends JFrame
{   
    
    /**
     * Constructor for objects of class GameFrame
     */
    public GUI2(final Game game)
    {
        super();
        setTitle("Tron2020");
        setBackground(Color.BLACK);
        final GamePanel gamePanel = new GamePanel(game);
        game.registerListener(new GameListener() {
            public void beforeMatch(final Match match) {
                GUI2.this.addKeyListener(new Key(match));
            }
            
            public void afterMatch(final Player player, final Match match) {
                if (player == null) {
                    JOptionPane.showMessageDialog(null, "Draw");
                } else {
                    JOptionPane.showMessageDialog(null, player.toString() + " won the match");
                }
            }
            
            public void afterGame(final Player gameWinner) {
                JOptionPane.showMessageDialog(null, gameWinner.toString() + " won the game");
            }
        });
        //take off border top
        //gamePanel.setBorder(BorderFactory.createEmptyBorder(-5,0,0,0));
        //gamePanel.setVisible(true);
        add(gamePanel);
        //gamePanel = new GamePanel();
        //add(gamePanel);
        
        setResizable(false);
        setPreferredSize(new Dimension(800,700));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
    private class Key implements KeyListener {
        private final Match match;
        public Key(final Match match) {
            this.match = match;
        }
        
        public void keyPressed(final KeyEvent event) {
            final int key = event.getKeyCode();
            final Player p1 = match.returnPlayers().get(0);
            final Player p2 = match.returnPlayers().get(1);
            
            if (key == KeyEvent.VK_LEFT) {
                match.addCommand(new TurnLeft(p2));
            } else if (key == KeyEvent.VK_RIGHT) {
                match.addCommand(new TurnRight(p2));
            }
            
            if (key == KeyEvent.VK_A) {
                match.addCommand(new TurnLeft(p1));
            } else if (key == KeyEvent.VK_D) {
                match.addCommand(new TurnRight(p1));
            }
            
        }
        
        public void keyReleased(final KeyEvent event) {
            //does nothing. Left intentionally empty.
        }
        
        public void keyTyped(final KeyEvent event) {
            //does nothing. Left intentionally empty.
        }
    }


}
