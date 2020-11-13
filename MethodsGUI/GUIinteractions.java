import javax.swing.*;
/**
 * 
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GUIinteractions
{
    public void showIntructions(int selectedTask, JTextArea report, JTextField[] entry)
    {
        /* !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
         * TO ADD NEW METHODS, WRITE INSTRUCTIONS HERE:
         * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
         */

        switch(selectedTask)
        {

            /*
             * CASE 0: "Select" is selected, so don't do anything!
             */
            case 0:
            break;

            /*
             * CASE 1: Mr. Beckwith's SWITCHY METHOD IS SELECTED
             */
            case 1: 
            {
                report.setText("Welcome to Switchy!\n\nPlease enter 2 strings in the first two boxes" +
                    " and I will combine them  for you...");
                break;
            }
            /*
             * CASE 2: Mr. Beckwith's silly TESTING METHOD IS SELECTED
             */
            case 2:  
            {
                report.setText("Welcome to Testing!\n" +
                    "\nPlease enter y or n in the first box, depending on whether you are sleepy or not" +
                    "\nIn the second box, enter your age" +
                    "\nIn the last box, enter your favorite number" +
                    "\n\n Using my special formula, when you hit submit, " +
                    "\nI will tell you whether you will win the lottery or not");

                entry[0].setText("Are you sleepy?");
                break;
            }

            /*
             * CASE 3: THIS IS WHERE YOU START TO ADD YOURS 
             */
            case 3:
            {
                //do report.setText()
                break;
            }

            //must leave this in:
            default:
            break;
        }
    }

    public void getAndShowResults(Tasks tasks, int selectedTask, JTextArea report, 
    JTextField[] entry )
    {
        //Gets entries from boxes, calls methods sending argumentes, and sets text of report with results

        //GET ALL ANSWERS FROM USER: GETTEXT() CAN ONLY RETURN STRINGS, SO CONVERT LATER:
        String arg1 = entry[0].getText();
        String arg2 = entry[1].getText();
        String arg3 = entry[2].getText();

        String resultString; //use this for return values that are Strings
        int resultInt;       //use this for return values that are integers
        boolean resultBool;  //use this for return values that are booleans

        switch(selectedTask)
        {
            /* !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
             * TO ADD NEW METHODS, CALL THE METHOD HERE, GET THE RESULTS, AND SET THE TEXT OF THE REPORT
             * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
             */

            /*
             * CASE 0: "Select" is selected, so don't do anything!
             */
            case 0:
            break;

            /*
             * CASE 1: Mr. Beckwith's silly SWITCHY METHOD IS SELECTED
             */
            case 1:  
            {
                //call the method, sending arguments, and store the return value into a String (you don't really need this comment)
                resultString = tasks.combine(arg1, arg2);
                //set the display to show/explain the results
                report.setText("Your reverse is " + resultString);
                break;
            }

            /*
             * CASE 2: Mr. Beckwith's silly TESTING METHOD IS SELECTED
             */
            case 2:  
            {
                //convert y or n answer to a boolean (or use your Utility here!!!)
                boolean sleepy;
                if(arg1.equals("y")) sleepy = true;
                else                 sleepy = false;

                //IMPORTANT - ALL args will be Strings, so
                // here's how you can convert age and number Strings to integers:
                int age    = Integer.parseInt(arg2);
                int favNum = Integer.parseInt(arg3);

                //get results of method call:
                resultBool = tasks.testing(sleepy, age, favNum);

                if(resultBool)
                {
                    report.setText("Yes, you win!");
                }
                else
                {
                    report.setText("Awww, you lose...");
                }
                break;
            }

            /*
             * CASE 3: THIS IS WHERE YOU START TO ADD YOURS 
             */
            case 3:
            {
                //your code does something with args, calls method, does report.setText()
                break;
            }
            //must leave this in:
            default:
            break;
        }  
    }
}
