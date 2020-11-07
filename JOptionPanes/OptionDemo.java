
import javax.swing.JOptionPane; //needed for all JOptionPanes
import javax.swing.ImageIcon;  //for image icons to change icon in JOptionPane
import java.text.*; //for number format
/**
 * Demo of a variety of JOptionPanes
 * 
 * @author Beckwith
 * @version 11.30.14
 * 
 * @link https://docs.oracle.com/javase/7/docs/api/javax/swing/JOptionPane.html
 * @link https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
 */
public class OptionDemo
{
    public static void main(String[] args)
    {
        NumberFormat commaFormat = NumberFormat.getInstance();
        commaFormat.setGroupingUsed(true);  //comma separators for large numbers
        /*
         * SIMPLEST JOptionPane: showMessageDialog JUST SHOWS A MESSAGE WITH AN OKAY BUTTON
         */
        JOptionPane.showMessageDialog(null,
            "Warning - the icon on the left is about to explode...", //message inside frame
            "IJP Course Example",                                   //title of frame
            JOptionPane.WARNING_MESSAGE);                           //icon used

            //choices for icon: JOptionPane.WARNING_MESSAGE
                            //  JOptionPane.ERROR_MESSAGE
                            //  JOptionPane.PLAIN_MESSAGE
                            //  JOptionPane.INFORMATION_MESSAGE
        /*  
         *  ANOTHER SIMPLE JOptionPane: showConfirmDialog RETURNS AN INTEGER
         * 
         * HERE ARE THE DIFFERENT CONSTANTS/INTEGERS THAT CAN BE RETURNED:
         *  JOptionPane.YES_OPTION            
         *  JOptionPane.NO_OPTION 
         *  JOptionPane.CANCEL_OPTION        
         *  JOptionPane.OK_OPTION
         *  JOptionPane.CLOSED_OPTION  
         */
        int answer = JOptionPane.showConfirmDialog(null, 
                "Do you understand JOptionPanes?",             //message inside frame
                "Click Yes or No:",         //title of frame
                JOptionPane.YES_NO_OPTION); //SETS THE TYPE OF JOPTIONPANE

        if (answer == JOptionPane.YES_OPTION)
            System.out.println("I'm glad you understand - now you can use them");
        else if (answer == JOptionPane.NO_OPTION)
            System.out.println("That's too bad - try making your own and you'll understand better");

        /*
         * showOptionDialog: you can name and have any number of buttons
         * RETURNS: integer aligned with choice
         */
        String[] options = {"Go to sleep",              //list of Strings that will be on each button
                "Win the lottery",                  
                "Not sure"};       //ADD MORE IF YOU WANT!!!
        int choice = JOptionPane.showOptionDialog(null,
                "What would you like to do next?",      //message in frame
                "Time for your next move!!!",           //text in titlebar
                JOptionPane.YES_NO_CANCEL_OPTION,       //3-button joptionpane
                JOptionPane.QUESTION_MESSAGE,           //sets icon type
                null,                                   //would use for user icon
                options,                  //list of options to appear on buttons
                options[2]);              //specified which button is selected as default
                
        //NOTE: YOU COULD USE IF-ELSE, INSTEAD OF THIS:
        switch(choice)
        {
            case 0: 
            System.out.println("Nighty-night...");
            break;
            
            case 1: 
            System.out.format("You've won $"+ commaFormat.format( (int)(Math.random() * 999999999 + 10000)) + "!!!!!");
            System.out.println();
            break;
            
            case 2: 
            System.out.println("I'll give you more time to think about it...");
            break;
            
            default: 
            break;
        }

        /*
         * showInputDialog: allows for pull-down menu
         * options stored in an array
         * RETURNS: one of the Strings in choices
         */
        String[] choices = {"North", "South", "East", "West", "Hyperspace"};
        String direction = (String)JOptionPane.showInputDialog(
                null,                   //could specify location in     frame
                "How would you like to proceed?",   //the question
                "Your Adventure",                   //the frame title
                JOptionPane.PLAIN_MESSAGE,          //the icon type
                null,                               //an icon you select
                choices,                            //array of options
                choices[0]);                        //the default to be selected
        //you could also put “North” instead of possibilities[0]
   
        //react to chosen direction:
        //NOTE: you could just use if-else instead of this:
        switch(direction)
        {
            case "North": System.out.println("Moving NORTH");
            break;
            case "South": System.out.println("Moving SOUTH");
            break;
            case "East": System.out.println("MOVING EAST");
            break;
            case "West": System.out.println("MOVING WEST");
            break;
            case "Hyperspace": System.out.println("LEAVING THIS UNIVERSE (temporarily)");
            break;
            default: break;
        }  
        
        /*
         * showInputDialog, allowing user to enter text (can convert to integer)
         * followed by showMessageDialogs, to show using imageIcons
         */
        //GET 3 GRADES:
        String test1 = JOptionPane.showInputDialog("Enter 1st test grade (integer):");
        int testG1 = Integer.parseInt(test1); 
        String test2 = JOptionPane.showInputDialog("Enter 2nd test grade (integer):");
        int testG2 = Integer.parseInt(test2);
        String test3 = JOptionPane.showInputDialog("Enter 2nd test grade (integer):");
        int testG3 = Integer.parseInt(test3);

        //GET NAME:
        String name = JOptionPane.showInputDialog("What is your name?");
        
        //CALCULATE AVERAGE
        double avg = (testG1 + testG2 + testG3) / 3.0;
        
        //DISPLAY RESULTS IN JOPTIONPANE:
        JOptionPane.showMessageDialog(null, 
            "Test average for " + name + " = " + avg + "\n(enter and see console for rounded version)");

        //DISPLAY IN CONSOLE WITH ONLY 2 DIGITS AFTER DECIMAL PLACE, USING  "%2f%n":
        System.out.format(name + ": test average is " + "%.2f%n", avg);  

        //SET IMAGE FOR OPTIONPANE:
        ImageIcon cchsIcon = new ImageIcon(OptionDemo.class.getResource("cc.jpeg"));  
        
        JOptionPane.showMessageDialog(null,"Game Over.  Enter to see final score... ", "Game Over",
            JOptionPane.PLAIN_MESSAGE, 
            cchsIcon);  //image to appear in optionpane

        //SET OTHER IMAGE:
        ImageIcon otherIcon = new ImageIcon(OptionDemo.class.getResource("Unknown.jpeg"));  //image for JOptionPanes
        
        JOptionPane.showMessageDialog(null,
            "What the....?",        //message inside frame
            "What the...?",         //title of frame
            JOptionPane.OK_OPTION,
            otherIcon);              //image to appear in optionpane
            
        JOptionPane.showMessageDialog(null, "SEE COMMENTS AT END OF CODE FOR HOW\n TO CHANGE FONTS AND COLORS!");

        /*
         * YES!  YOU CAN CHANGE COLORS AND FONTS

         * FOR THIS TO WORK, include this code before any JOptionPane is created:
         
         * this will be used in the lines below it:
         * Font font = new Font(Font.SANS_SERIF, Font.ITALIC, 20); 

         * UIManager um = new UIManager();

         * um.put("OptionPane.messageFont", font);            //message font
         * um.put("OptionPane.buttonFont", font);             //button font
         * um.put("OptionPane.messageForeground", Color.red); //message COLOR

         * um.put("Panel.background", Color.yellow);          //background COLOR

         *  YOU WOULD NEED THESE AT THE TOP:
         * import javax.swing.UIManager;  //needed only if changing fonts and colors
         * import java.awt.Font;          //for changing fonts
         * import java.awt.Color;         //for changing colors
         */
    }
}
