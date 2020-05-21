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


}
