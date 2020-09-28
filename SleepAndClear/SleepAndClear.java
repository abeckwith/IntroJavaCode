
/**
 * Code example forsleep and clearing screen
 * 
 * @author A.Beckwith
 * @version 1.0
 */
public class SleepAndClear
{
    public static void main(String args[]){
        try{ //needed JUST for the SLEEP statements (along with the 'catch' below)
            System.out.println("Launching in...");
            Thread.sleep(2500);
            System.out.println("3...");
            Thread.sleep(2000);
            System.out.println("2...");
            Thread.sleep(1500);
            System.out.println("1...");
            Thread.sleep(1000);
            System.out.println("BLAST OFF!!!");
            Thread.sleep(1500);
            System.out.println("read it now, because it will be gone soon..");
            Thread.sleep(1500);
        }
        catch(Exception e){}

        System.out.println("\u000c"); //clear the screen
        System.out.println("A fresh start...");
        try{
            Thread.sleep(1500);
        }
        catch(Exception e){}
        System.out.println("\f");  //also clears the screen
        System.out.println("gone again!");
    }
}
