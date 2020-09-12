import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseEvent;
/**
 * Creates the window in which the JPanel can do the drawings
 */
public class WindowFast extends JFrame
{
    DrawingFast d;

    int screenWidth = 1100;
    int screenHeight = 800;
    public WindowFast()
    {
        super("Spiral s- FAST");
        
        //create new drawing canvas:
        d = new DrawingFast(screenWidth, screenHeight);
        
        //set up overall window:
        setLayout(new BorderLayout());
        add(d, BorderLayout.CENTER);

        this.setLocationByPlatform(true);
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

}

