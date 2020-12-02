import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * Provides a window for buttons, entry boxes and displaying of grahpics
 * 1. Sets up all imporant control variable values,
 * 2. makes a Window for buttons and graphics and timer control
 * 3. and makes a Display to show graphics
 * 4. starts the timer to start animation
 * 
 * @author Beckwith & (your name here)
 * @version 1.2.0
 */
public class GraphicsWindow extends JFrame implements ActionListener
{
    final int TIMER_DELAY;  //milliseconds for updating graphics/motion
    Timer t;

    //components and objects:
    JButton button;
    JPanel topPanel, displayPanel;
    JTextField info;
    Display display;
    Rabbit bunny;

    //size of window:
    int WIDTH;
    int HEIGHT;

    int numSquaresAcross; 
    int middleX, middleY;
    int squareSize;

    /**
     * Constructor for Window
     */
    public GraphicsWindow()
    {
        //calls constructor of the "super class"- JFrame - arg is titlebar name
        super("(set name of window here!!!!!!)");

        //the JFrame/Graphics Window size:
        WIDTH  = 950;
        HEIGHT = 700;

        /******** NUMBERS YOU MIGHT CHANGE: **********/
        
        TIMER_DELAY = 200;  //SPEED of graphics, lower number = faster
        //(# of milliseconds between updates to graphics)
        
        numSquaresAcross = 11; //will establish size of each square     
        //(you could ask the user what size they want)

        /*********************************************/
        
        
        middleX = numSquaresAcross / 2;  //starting point for bunny - middle
        middleY = numSquaresAcross / 2;

        //size of 1 Bunny or 1 blank square - change 600 for larger or smaller grid
        squareSize = 600 / numSquaresAcross; 

        //make blue bunny at middle:
        bunny    = new Rabbit(middleX, middleY, Color.BLUE, squareSize);

        //make display for showing all drawings and animation in:
        display = new Display(bunny, WIDTH, HEIGHT, numSquaresAcross);

        //save bunny from Display object
        this.bunny   = this.display.bunny;

        //allows you to place things where you want them (see this.add() below)
        this.setLayout(new BorderLayout());

        //make a button for possible future use:
        button = new JButton("button name");
        button.addActionListener(this);
        button.setActionCommand("button");

        //panel to buttons and textfields in:
        topPanel = new JPanel();
        topPanel.setBackground(Color.BLACK);
        topPanel.add(button);

        //add a text field for getting stuff from user, if needed
        info = new JTextField(20);
        topPanel.add(info);

        //add the display to this JFrame:
        this.add(topPanel, BorderLayout.NORTH);
        this.add(display,  BorderLayout.CENTER);

        //final setup
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));  
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    /**
     * Creates a Timer object and starts timer
     */
    public void startTimer()
    {
        t = new Timer(TIMER_DELAY ,this); 
        t.setActionCommand("timerFired");
        t.start();
    }

    /**
     * Called automatically when a button is pressed
     * @param e contains information about button that was pressed/sent automatically
     */
    public void actionPerformed(ActionEvent e)
    {

        if(e.getActionCommand().equals("button"))      //button has been pressed
        {
            //do something 
        }
        if(e.getActionCommand().equals("timerFired"))  //timer has fired
        {
            updateAll();            //does all motion and checking and logic (see below)
            display.repaint();      //calls paintComponent to redraw everything
        }
    }

    /**
     * Called by the timer. You'll do all altering of bunnies here - 
     * this is followed by a repaint of everything
     */
    public void updateAll()
    {
        int moveCode = (int)(Math.random() * 8);  //choose direction to move

        bunny.move(moveCode);                     //update location
        
        bunny.checkForRecenter(numSquaresAcross); //if off edge, recenter
        
        //DO ALL OTHER LOGIC HERE: MAYBE CHECKING OTHER BUNNIES OR FOR COLLISION, ETC.

    }
}
