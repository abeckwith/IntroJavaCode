import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Creates the window in which the JPanel can do all the drawings
 */
public class Window extends JFrame implements ActionListener
{
    Drawing d;
    Timer t;
    int SPEED = 50;   //SMALLER NUMBER IS FASTER
    int linesDrawn = 0;
    int linesToDraw = 1000;  //default: 1000
    
    int screenWidth = 1100;
    int screenHeight = 800;
    /**
     * Constructor sets up the window and puts the JPanel (Drawing) into it
     */
    public Window()
    {
        super("Spirals");
        
        d = new Drawing();
        setLayout(new BorderLayout());
        add(d, BorderLayout.CENTER);

        this.setLocationByPlatform(true);
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        t = new Timer(SPEED, this);
        t.setActionCommand("timer");
        t.start();

    }

    /**
     * When the Timer fires, this is called and repaints everything - all ines
     */
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("timer"))
        {
            d.repaint();  
            linesDrawn++;
            if(linesDrawn > linesToDraw) t.stop();
        }

    }

}

