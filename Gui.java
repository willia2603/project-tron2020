import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {

    /**
     * Default GUI constructor
     * @param title the application's title
     */
    public Gui(String title) {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setBackground(Color.DARK_GRAY);
        init();
    }

    /**
     * Create the Grid, add the Screen, and set it to Visible.
     */
    public void init() {
        setLayout(new GridLayout(1, 1, 0, 0));
        Screen s = new Screen();
        add(s);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
