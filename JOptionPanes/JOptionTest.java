import javax.swing.JOptionPane;  //needed for all JOptionPanes
import javax.swing.ImageIcon;   //needed only if using image
import javax.swing.UIManager;   //needed only if changing fonts and colors
/**
 * 5 examples of JOptionPanes
 * 
 * @author A. Beckwith
 * @version 1.0
 */
public class JOptionTest
{
    public static void main(String[] args)
    {
        
        //SEE POSTED HANDOUT ON JOPTION PANGES FOR SOME MORE DETAIL
        /*
         * 1. SHOW SIMPLE MESSAGE WITH OK BUTTON
         */

        String directions = "You have completed your mission";
        String title      = "END OF QUEST";

        JOptionPane.showMessageDialog(null,
            directions,    //text that appears in the window
            title,		   //text that appears in the title bar
            JOptionPane.PLAIN_MESSAGE); //see below	      
        //icon type: ”WARNING” = ! symbol, “ERROR” = X symbol, “PLAIN” = no symbol 
        //“INFORMATION” = i

        directions = "Wha?  You can do images???";
        title      = "Yes, you can do images!";
        ImageIcon sun = new ImageIcon("sunset.png");  /**MAKE ICON OBJECT*/
   
        JOptionPane.showMessageDialog(null,
            directions,    //text that appears in the window
            title,		   //text that appears in the title bar
            JOptionPane.PLAIN_MESSAGE,
            sun);  
        /*
         *  2. MULTIPLE BUTTONS
         */
        String[] options = {"Yes!",					//array of button
                "No!",					// titles, see**
                "More examples, please!"};	// below
        String message2 = "Do you understand OptionPane?";
        String title2   = "JOptionPane Survey";

        int choice = JOptionPane.showOptionDialog(null,
                message2,		//text that appears in window
                title2,			//text that appears in titlebar
                JOptionPane.YES_NO_CANCEL_OPTION,			//see** below
                JOptionPane.PLAIN_MESSAGE,				//sets icon type
                null,								//would use for user icon
                options,				//*list of options to appear on buttons
                options[2]);		//specified which button is selected as default

        /*
         *  3. PULL DOWN MENU OF OPTIONS
         */
        int xCoord = 0; //just so if statement example below works...
        int yCoord = 0;

        String[] choices = {"North", "South", "East", "West", "Hyperspace"};
        String instructions = "How would you like to proceed?";
        String title3       = "Your Adventure";

        String s = (String)JOptionPane.showInputDialog(
                null,					//could specify location in 	frame
                instructions,	//text that appears in window
                title3,		//text that appears in the titlebar
                JOptionPane.PLAIN_MESSAGE,		//the icon type
                null,						//an icon you select
                choices,					//array of options
                choices[0]);				//the default to be selected
        //you could also put “North”

        //example of how to use the user's choice:
        if(s != null)  //if user hits CANCEL, null, is returned - this line prevents error
        {
            if(s.equals(choices[0]))      yCoord++;  //North
            else if(s.equals(choices[1])) yCoord--;  //South
            else if(s.equals(choices[2])) xCoord++;  //East
            else                          xCoord--;  //West
        }

        /*
         * 4. Pull down menu with custom icon
         */

        ImageIcon img = new ImageIcon("compass.jpg");  /**MAKE ICON OBJECT*/

        s = (String)JOptionPane.showInputDialog(
            null,                   //could specify location in     frame
            "How would you like to proceed?",   //the question
            "Your Adventure",               //the frame title
            JOptionPane.PLAIN_MESSAGE,      //the icon type 
            img,                       /**THIS IS THE IMAGE ICON*/
            choices,                    //array of options
            choices[0]);                //the default to be selected
        /*
         *  5a. USER TYPES IN A STRING THAT YOU STORE IN A VARIABLE:
         */

        String name = JOptionPane.showInputDialog("What is your name?");

        /*
         *  5b.  USER TYPES IN A NUMBER THAT YOU STORE IN A VARIABLE
         */
        String ageString = JOptionPane.showInputDialog("What is your age?");
        int age = 0;
        //turn into an integer:
        if(ageString != null) age = Integer.parseInt(ageString); //if user hits cancel, do nothing

        String gpaString = JOptionPane.showInputDialog("Pick a number betwee 0 and 1");
        double gpa;
        ///tuirn into a double:
        if(gpaString != null) gpa = Double.parseDouble(gpaString);
        
        //create a silly display of names
        String display = "";
        for(int i = 0; i < age * 3; i++)
        {
            display += name;
            if(i % 9 == 0) display += "\n";  //break up the lines
        }
        JOptionPane.showMessageDialog(null,
             "Hello " + name + ".  Here is your name shown 3 times your age number of times:\n" + display,
            "A lotta you",		   //text that appears in the title bar
            JOptionPane.PLAIN_MESSAGE); //see below

        //SPECIAL ALTERATIONS TO LOOK AND FEEL:
        /*
         * To change font of text (not entry box, though), 
         * do this before any JOptionPane is created:
         * 
         * (YOU'LL NEED import java.awt.Font; !!!!!)
         * Font font = new Font(Font.SANS_SERIF, Font.ITALIC, 20); //or whatever

         * UIManager um = new UIManager();

         * um.put("OptionPane.messageFont", font);  //message

         * um.put("OptionPane.buttonFont", font);  //button

         * um.put("OptionPane.messageForeground", Color.red); //text COLOR

         * um.put("Panel.background", Color.yellow);  //background COLOR
         * 
         */
    }
}
