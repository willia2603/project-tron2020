import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    /**
     * Constructor of class GamePanel.
     * 
     * @param game The current game.
     */
    public GamePanel(final Game game) {
        super();
        // TopPanel bcs it implements matchListener --> allows me to have it as a
        // listener
        createTopPanel(game);
        createCanvas(game);

        setVisible(true);

    }
    
    /**
     * Create and add canvas.
     * 
     * @param game The current game.
     */
    public void createCanvas(final Game game) {
        final JComponent canvas = new Canvas(game);
        add(canvas);
    }
    
    /**
     * Create and add top panel.
     * 
     * @param game The current game.
     */
    public void createTopPanel(final Game game) {
        final TopPanel topPanel = new TopPanel(game);
        add(topPanel);
    }

    // canvas only draws
    private static class Canvas extends JComponent {
        private static final int WIDTH = 800;
        private static final int HEIGHT = 600;
        private Match match;

        /**
         * Constructor of class GamePanel.
         * 
         * @param game The current game.
         */
        public Canvas(final Game game) {
            super();

            game.registerListener(new GameListener() {
                public void beforeMatch(final Match match) {
                    Canvas.this.match = match;
                    match.registerListener(new MatchListener() {
                        public void beforeTick(final Match match) {
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                            repaint();
                        }
                    });
                }

                public void afterMatch(final Player player, final Match match) {
                    // does nothing. Left intentionally empty.
                }

                public void afterGame(final Player gameWinner) {
                    // does nothing. Left intentionally empty.
                }
            });
            setVisible(true);
        }

        /**
         * Get preferred Dimension.
         * 
         * @return the preferred dimension.
         */
        public Dimension getPreferredSize() {
            return new Dimension(Canvas.WIDTH, Canvas.HEIGHT);
        }
        
        public void paintPlayer(final Player player, final Color color, final Graphics g) {
            g.setColor(color);

            for (final Coordinate c : player.getSnakeCopy().getBody()) {
                // fillRect topLeftX, topLeftY,bottomRightX, bottomRightY
                g.fillRect(
                        c.getX() * (Canvas.WIDTH / SettingsHelper.ARENA_WIDTH),
                        c.getY() * (Canvas.HEIGHT / SettingsHelper.ARENA_HEIGHT), 
                        Canvas.WIDTH / SettingsHelper.ARENA_WIDTH,
                        Canvas.HEIGHT / SettingsHelper.ARENA_HEIGHT);
            }
            
        }

        /**
         * Paint on canvas.
         * 
         * @param g the Graphics object.
         */
        public void paintComponent(final Graphics g) {
            final Color gridColor = Color.decode("#DCDCDC");
            g.setColor(gridColor);

            // draw line every 10 pixels
            for (int i = 0; i < SettingsHelper.ARENA_HEIGHT; i++) {
                g.drawLine(0, i * (Canvas.HEIGHT / SettingsHelper.ARENA_HEIGHT), Canvas.WIDTH,
                        i * (Canvas.HEIGHT / SettingsHelper.ARENA_HEIGHT));
            }

            // draw vertical lines
            // draw line every 10 pixels
            for (int i = 0; i < SettingsHelper.ARENA_WIDTH; i++) {
                g.drawLine(i * (
                    Canvas.WIDTH / SettingsHelper.ARENA_WIDTH), 
                    0, 
                    i * (Canvas.WIDTH / SettingsHelper.ARENA_WIDTH),
                    Canvas.HEIGHT);
            }

            // draw players
            final ArrayList<Player> players = match.returnPlayers();
            paintPlayer(players.get(0), Color.decode("#03C9F0"), g);
            paintPlayer(players.get(1), Color.decode("#E500FF"), g);
            
        }

    }
    //static?
    // matchListener to show decreasing of lives
    
    private static class TopPanel extends JPanel {
        private JLabel p1Label;
        private JLabel p2Label;
        
        /**
         * Constructor for TopPanel.
         * 
         * @param game The current game.
         */
        public TopPanel(final Game game) {
            super();
            setUpGamePanel();
            
            // register listener
            addListeners(game);
        }
        
        /**
         * Set up each top panel part.
         * 
         * @param b The color of the border.
         * @param t The text of the label.
         * @param pos The position of the panel.
         * @param p The name of the player.
         */
        public void setUpPanel(final Color b, final String t, final String pos, final String p) {
            final JPanel panel = new JPanel();
            panel.setBorder(BorderFactory.createLineBorder(b));
            final JLabel label = new JLabel(t);
            label.setPreferredSize(new Dimension(100, 100));
            label.setHorizontalAlignment(JLabel.CENTER);
            if ("P2 Lives".equals(p)) {
                this.p2Label = label;
            } else if ("P1 Lives".equals(p)) {
                this.p1Label = label;
            }
            panel.add(label);
            panel.setPreferredSize(new Dimension(200, 100));
            add(panel, pos);
        
        }
        
        /**
         * Setup GamePanel.
         */
        public void setUpGamePanel() {
            setLayout(new BorderLayout(20, 0));
            setPreferredSize(new Dimension(800, 100));
            setUpPanel(Color.decode("#E500FF"), "P2 Lives", BorderLayout.EAST, "P2 Lives");
            setUpPanel(Color.BLACK, "TRON 2020", BorderLayout.CENTER, "");
            setUpPanel(Color.decode("#03C9F0"), "P1 Lives", BorderLayout.WEST, "P1 Lives");
            setVisible(true);
        }
        
        /**
         * Add Listeners.
         * 
         * @param game The current game.
         */
        public void addListeners(final Game game) {
            game.registerListener(new GameListener() {
                public void beforeMatch(final Match match) {
                    match.registerListener(new MatchListener() {
                        public void beforeTick(final Match match) {
                            final ArrayList<Player> players = match.returnPlayers();
                            final int p1Lives = players.get(0).getLives();
                            final int p2Lives = players.get(1).getLives();
                            // change label of lives according to match
                            p1Label.setText("P1 Lives: " + p1Lives);
                            p2Label.setText("P2 Lives: " + p2Lives);
                        }

                    });
                }

                public void afterMatch(final Player player, final Match match) {
                    // does nothing. Left intentionally empty.
                }

                public void afterGame(final Player gameWinner) {
                    // does nothing. Left intentionally empty.
                }

            });
        
        }
    }
}
