import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Graphics;
/**
 * Write a description of class GameFrame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GUI2 extends JFrame
{   
    private GamePanel gamePanel;
    private JPanel gameWinPanel;
    private JPanel matchWinPanel;
    private JPanel menuPanel;
    
    /**
     * Constructor for objects of class GameFrame
     */
    public GUI2(Game game)
    {
        setTitle("Tron2020");
        setBackground(Color.BLACK);
        gamePanel = new GamePanel(game);
        game.registerListener(new GameListener() {
            public void beforeMatch(Match match) {
                GUI2.this.addKeyListener(new Key(match));
            }
            
            public void afterMatch(Player player, Match match) {}
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
        public Key(Match match) {
            this.match = match;
        }
        
        public void keyPressed(KeyEvent event) {
            int key = event.getKeyCode();
            Player p1 = match.returnPlayers().get(0);
            Player p2 = match.returnPlayers().get(1);
            
            if (key == KeyEvent.VK_LEFT) {
                match.addCommand(new TurnLeft(p1));
            } else if (key == KeyEvent.VK_RIGHT) {
                match.addCommand(new TurnRight(p1));
            }
            
            if (key == KeyEvent.VK_A) {
                match.addCommand(new TurnLeft(p2));
            } else if (key == KeyEvent.VK_D) {
                match.addCommand(new TurnRight(p2));
            }
            
        }
        public void keyReleased(KeyEvent event) {}
        public void keyTyped(KeyEvent event) {}
    }


}
