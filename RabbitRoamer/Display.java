import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author Beckwith & (your name here)
 * @version 1.2.0
 */
public class Display extends JPanel
{
    Rabbit bunny;
    int numSquaresAcross;  
    Font myFont; 

    /**
     * CONSTRUCTOR saves bunny and number of squares and sets font and size of display
     */
    public Display(Rabbit bunny, int w, int h, int numSquaresAcross) 
    {
        this.bunny = bunny;
        this.numSquaresAcross = numSquaresAcross;

        this.myFont = new Font("Verdana", Font.BOLD, 16);  //nice font for display purposes
        setPreferredSize(new Dimension(w, h));             //set size of display       
    }

    /**
     * Draw text, grid, and rabbit; called in Window class by a timer calling repaint()
     * @param g the graphics object, automatically sent when repaint() is called
     */
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);    //clear the old drawings
        
        g.setColor(Color.BLACK);    //creates background color  
        g.fillRect(0, 0, 950, 700); 

        bunny.draw(g);              //draw the bunny
        
        //drawString - can be used to show any updates or information:
        g.setFont(myFont);
        g.drawString("" + bunny.numMoves, 650, 15);

        // show a yellow square in the middle:
        g.setColor(Color.YELLOW);
        int middle = numSquaresAcross / 2;

        //fillRect(x,y,w,h) draws a rectangle at (x,y) of dimensions w x h:
        g.fillRect( middle * bunny.squareSize, //x
                    middle * bunny.squareSize, //y
                    bunny.squareSize,          //w
                    bunny.squareSize);         //h
                    
        //draw the grid:
        for(int col = 0; col < numSquaresAcross; col++)
        {
            for(int row = 0; row < numSquaresAcross; row++)
            {
                //set location of where to draw current rectangle
                int x =  (int)(bunny.squareSize * col);
                int y =  (int)(bunny.squareSize * row);

                g.setColor(Color.GREEN);
                
                g.drawRect(x, y, bunny.squareSize, bunny.squareSize);
            }
        }
    }
}
