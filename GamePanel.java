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
        final JComponent canvas = new Canvas(game);
        // TopPanel bcs it implements matchListener --> allows me to have it as a
        // listener
        final TopPanel topPanel = new TopPanel(game);

        // topPanel.setBorder(BorderFactory.createEmptyBorder(-5,0,0,0));
        // canvas.setBorder(BorderFactory.createEmptyBorder(-5,0,0,0));

        add(topPanel);
        add(canvas);
        // add topPanel to match listeners to change lives number of each player
        setVisible(true);

    }

    // canvas only draws
    private class Canvas extends JComponent {
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

    // matchListener to show decreasing of lives
    private class TopPanel extends JPanel {
        private JLabel p1Label;
        private JLabel p2Label;

        public TopPanel(final Game game) {
            super();
            setLayout(new BorderLayout(20, 0));
            setPreferredSize(new Dimension(800, 100));

            final JPanel topRightPanel = new JPanel();
            final JPanel topCenterPanel = new JPanel();
            final JPanel topLeftPanel = new JPanel();

            topRightPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#03C9F0")));
            topCenterPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            topLeftPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#E500FF")));

            p1Label = new JLabel("P1 Lives");
            p1Label.setPreferredSize(new Dimension(100, 100));
            p1Label.setHorizontalAlignment(JLabel.CENTER);

            final JLabel titleLabel = new JLabel("TRON 2020");
            titleLabel.setPreferredSize(new Dimension(100, 100));
            titleLabel.setHorizontalAlignment(JLabel.CENTER);

            p2Label = new JLabel("P2 Lives");
            p2Label.setPreferredSize(new Dimension(100, 100));
            p2Label.setHorizontalAlignment(JLabel.CENTER);

            topRightPanel.add(p1Label);
            topLeftPanel.add(p2Label);
            topCenterPanel.add(titleLabel);

            topRightPanel.setPreferredSize(new Dimension(200, 100));
            topCenterPanel.setPreferredSize(new Dimension(200, 100));
            topLeftPanel.setPreferredSize(new Dimension(200, 100));

            add(topRightPanel, BorderLayout.WEST);
            add(topCenterPanel, BorderLayout.CENTER);
            add(topLeftPanel, BorderLayout.EAST);
            setVisible(true);

            // register listener
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
