import java.io.IOException;  //MUST HAVE THIS!!!!
import java.util.Scanner;

/**
 * Example of using Terminal command say
 */
public class Speak
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);  
        
        String voice = "Victoria";

        //simle example of using voice by using terminal command say:
        try 
        {    
            Runtime.getRuntime().exec("say this is the first example");
            System.out.println("Hit ENTER to continue...");
            scan.nextLine();
            
            Runtime.getRuntime().exec("say now a different voice -v " + voice);
        } 
        catch (IOException e) 
        {
        }

        //BUT YOU CAN ALSO SAY THINGS THAT ARE STORED IN A VARIABLE:

        //getting what to say from user:
        System.out.println("What do you want to say?");

        String msg = scan.nextLine();

        //these are the only lines of code you need:
        try 
        {    
            Runtime.getRuntime().exec("say " + msg + " -v " + voice);
        } 
        catch (IOException e) 
        {
        }

    }
}
