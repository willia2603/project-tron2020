import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Graphics;
/**
 * Write a description of class MenuPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MenuPanel extends JPanel
{
    public MenuPanel() {
        JPanel container = new JPanel();
        
        JLabel title = new JLabel("Tron2020");
        JLabel welcome = new JLabel("Welcome to Tron 2020!");
        JLabel start = new JLabel("press 's' to start the game");
        JLabel help = new JLabel("press 'h' for help");
        JLabel quit = new JLabel("press 'q' to quit");
        
        add(title);
        add(welcome);
        add(start);
        add(help);
        add(quit);
        
        
        setVisible(true);
    }
}
