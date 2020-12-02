import java.awt.*;
import javax.swing.*;
/**
 * Rabbit
 * 
 * @author Beckwith
 * @version 0.1
 */

public class Rabbit
{
    /* 
     *                 TO-DO!!!!! 
     *  1. create 4 instance variables below for xLoc, yLoc, color (of type Color),
     *  squareSize, and numMoves. 
     *  
     *  2. In the body of the constructor below, set those instance variables to the
     *  args given - everything except numMoves is an argument - set nummoves to zero
     */

    /**
     * Constructor for Graphics display
     */
    public Rabbit(int xLoc, int yLoc, Color color, int squareSize)
    {

    }

    /**
     * Moves the Rabbit in any of 8 directions
     * @param moveCode 0-7 code, starts with 0 = Right and goes counter-clockwise
     */
    public void move(int moveCode)
    {
        /*
         * TO-DO: 
         * 1. complete the switch statement to move in 1 of 8 directions given a 
         * moveCode value between 0 and 7 that is received as an argument from Window
         * 
         * To move, increment or decrement the xLoc and/or yLoc
         * 
         * 2. You'll also need to  INCREMENT numMoves after the entire switch statement 
         */

        //I've started it for you:
        switch(moveCode)
        {
            case 0:  //moves right
            xLoc++; 
            break;

            case 1:  //moves diagonally up and right
            xLoc++;
            yLoc--;  
            break;
            //YOU do the rest below!
        }
    }

    public void draw(Graphics g)
    {
        g.setColor(color);   //sets the color of this rabbit before drawing

        //location of this Rabbit on grid:
        int x =  (int)(squareSize * xLoc);  
        int y =  (int)(squareSize * yLoc);

        //draw the rabbit square:
        g.fillRect(x, y, squareSize, squareSize);  //rectangle with equal w and h is a square located at (x,y)
    }

    public void checkForRecenter(int numSquaresAcross)
    {
        //if off an edge, recenter:
        if(xLoc < 0                  //left
        || yLoc < 0                  //top
        || xLoc >= numSquaresAcross  //right
        || yLoc >= numSquaresAcross) //bottom
        {
            xLoc = numSquaresAcross / 2;  //center coordinates
            yLoc = numSquaresAcross / 2;
        }   
    }
}
