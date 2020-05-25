import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

/**
 * Write a description of class GamePanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GamePanel extends JPanel
{   
    
    public GamePanel(final Game game) {
        super();
        final JComponent canvas = new Canvas(game);
        //TopPanel bcs it implements matchListener --> allows me to have it as a listener
        final TopPanel topPanel = new TopPanel(game);
        
        //topPanel.setBorder(BorderFactory.createEmptyBorder(-5,0,0,0));
        //canvas.setBorder(BorderFactory.createEmptyBorder(-5,0,0,0));
        
        add(topPanel);
        add(canvas);
        //add topPanel to match listeners to change lives number of each player
        setVisible(true);
       
    }
    //canvas only draws
    private class Canvas extends JComponent {
        private final static int WIDTH = 800;
        private final static int HEIGHT = 600;
        private Match match;
        public Canvas(final Game game) {
            //setBackground(Color.RED);
            super();
            
            game.registerListener(new GameListener() {
                public void beforeMatch(final Match match) {
                    Canvas.this.match = match;
                    match.registerListener(new MatchListener() {
                        public void beforeTick(final Match match) {
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            repaint();
                        }          
                    });
                }
                public void afterMatch(final Player player, final Match match) {
                    //does nothing. Left intentionally empty.
                }
                
                public void afterGame(final Player gameWinner) {
                    //does nothing. Left intentionally empty.
                }
            });
            setVisible(true);
        }
        
        public Dimension getPreferredSize() {
            return new Dimension(Canvas.WIDTH, Canvas.HEIGHT);
        }
        
        public void paintComponent(final Graphics g) {
            //g.setColor(Color.RED);
            //g.fillRect(0, 0, Canvas.WIDTH, Canvas.HEIGHT);
            //draw horizontal lines
            final Color gridColor = Color.decode("#DCDCDC");
            g.setColor(gridColor);
            //draw line every 10 pixels
            for (int i = 0; i < Setting.ARENA_HEIGHT; i++) {
                g.drawLine(
                    0, 
                    i * (Canvas.HEIGHT / Setting.ARENA_HEIGHT), 
                    Canvas.WIDTH, 
                    i * (Canvas.HEIGHT / Setting.ARENA_HEIGHT)
                );
            }
            
            //draw vertical lines
            //draw line every 10 pixels
            for (int i = 0; i < Setting.ARENA_WIDTH; i++) {
                g.drawLine(
                    i * (Canvas.WIDTH / Setting.ARENA_WIDTH), 
                    0, 
                    i * (Canvas.WIDTH / Setting.ARENA_WIDTH),
                    Canvas.HEIGHT 
                );
            }
            
            //draw players
            //TODO: change color for each player
            final ArrayList<Player> players = match.returnPlayers();
            final Player p1 = players.get(0);
            final Color p1Color = Color.decode("#03C9F0");
            g.setColor(p1Color);
            //iterator to 
            for (final Coordinate c : p1.getSnakeCopy().getBody()) {
                //fillRect topLeftX, topLeftY,bottomRightX, bottomRightY
                g.fillRect(
                //
                //1 : 10 --> 1 Arena --> move 1 * 10 each time --> map from arena --> pixels
                c.getX() * (Canvas.WIDTH / Setting.ARENA_WIDTH), 
                c.getY() * (Canvas.HEIGHT / Setting.ARENA_HEIGHT), 
                Canvas.WIDTH / Setting.ARENA_WIDTH, 
                Canvas.HEIGHT / Setting.ARENA_HEIGHT
                );
            }
            final Color p2Color = Color.decode("#E500FF");
            g.setColor(p2Color);
            final Player p2 = players.get(1);
            for (final Coordinate c : p2.getSnakeCopy().getBody()) {
                //fillRect topLeftX, topLeftY,bottomRightX, bottomRightY
                g.fillRect(
                //
                //1 : 10 --> 1 Arena --> move 1 * 10 each time --> map from arena --> pixels
                c.getX() * (Canvas.WIDTH / Setting.ARENA_WIDTH), 
                c.getY() * (Canvas.HEIGHT / Setting.ARENA_HEIGHT), 
                Canvas.WIDTH / Setting.ARENA_WIDTH, 
                Canvas.HEIGHT / Setting.ARENA_HEIGHT
                );
            }
        }

    }
    //matchListener to show decreasing of lives
    private class TopPanel extends JPanel {
        private JLabel p1Label;
        private JLabel p2Label;
        
        public TopPanel(final Game game) {
            //JPanel topPanel = new JPanel(); NO, we are the top panel
            //horizontal space between components
            //maybe change to flow layout???
            super();
            setLayout(new BorderLayout(20,0));
            //setBackground(Color.GREEN);
            setPreferredSize(new Dimension(800,100));
            //setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5); 
            final JPanel topRightPanel = new JPanel();
            final JPanel topCenterPanel = new JPanel();
            final JPanel topLeftPanel = new JPanel();
            
            topRightPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#03C9F0")));
            topCenterPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            topLeftPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#E500FF")));
            
            p1Label = new JLabel("P1 Lives");
            p1Label.setPreferredSize(new Dimension(100,100));
            p1Label.setHorizontalAlignment(JLabel.CENTER);
            //p1Label.setForeground(Color.RED);
            
            final JLabel titleLabel = new JLabel("TRON 2020");
            titleLabel.setPreferredSize(new Dimension(100,100));
            titleLabel.setHorizontalAlignment(JLabel.CENTER);
            //titleLabel.setForeground(Color.RED);
            
            p2Label = new JLabel("P2 Lives");
            p2Label.setPreferredSize(new Dimension(100,100));
            p2Label.setHorizontalAlignment(JLabel.CENTER);
            //p2Label.setForeground(Color.RED);
            
            topRightPanel.add(p1Label);
            topLeftPanel.add(p2Label);
            topCenterPanel.add(titleLabel);
            
            topRightPanel.setPreferredSize(new Dimension(200,100));
            topCenterPanel.setPreferredSize(new Dimension(200,100));
            topLeftPanel.setPreferredSize(new Dimension(200,100));

            //topRightPanel.setBackground(Color.decode("#F5F5F5"));
            //topCenterPanel.setBackground(Color.decode("#F5F5F5"));
            //topLeftPanel.setBackground(Color.decode("#F5F5F5"));
            //change later WEST EAST
            add(topRightPanel, BorderLayout.WEST);
            add(topCenterPanel, BorderLayout.CENTER);
            add(topLeftPanel, BorderLayout.EAST);
            setVisible(true);
            
            //register listener
            game.registerListener(new GameListener() {
                public void beforeMatch(final Match match) {
                    match.registerListener(new MatchListener() {
                        public void beforeTick(final Match match) 
                        {
                            final ArrayList<Player> players = match.returnPlayers();
                            final int p1Lives = players.get(0).getLives();
                            final int p2Lives = players.get(1).getLives();
                            //change label of lives according to match
                            p1Label.setText("P1 Lives: " + p1Lives);
                            p2Label.setText("P2 Lives: " + p2Lives);
                        }
                        
                    });
                }
                public void afterMatch(final Player player, final  Match match) {
                    //does nothing. Left intentionally empty.
                }
                
                public void afterGame(final Player gameWinner) {
                    //does nothing. Left intentionally empty.
                }
            
            });
        }
        
        
    }
}

