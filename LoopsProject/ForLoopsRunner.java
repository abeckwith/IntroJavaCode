import java.util.Scanner;
/**
 * Gives user the choice of which forloop methods to run
 *
 * @author Beckwith
 * @version 1.0
 */
public class ForLoopsRunner
{
   public static void main(String[] args)
   {
      ForLoops f   = new ForLoops();
      Scanner  s   = new Scanner(System.in);
        
      boolean done = false;   //allows multiple runs of the code
        
      int choice   = 0;
        
        //keep allowing user to choose until they quit:
      while(!done)
      {
         System.out.print("\nMake a choice (1-10) 0 to quit: ");
            
            //List of options:
         String list = 
                "1. Count Vowels\n"  +
                "2. Reverse stuff\n" +  
                "3. Encrypt\n"       +
                "4. Show Board\n"    +
                "5. Show Primes\n"   +
                "6. Guess For Dollars\n" +
                "7. (your own here)\n"   + 
                "8. Count Consonants\n"  + 
                "9. Show fancy board\n"  +
                "10. Reverse by word\n";
      
         System.out.print("\n" + list + "Your choice: ");
            
            //get choice number:
         choice = s.nextInt();
            
            //clear the newline character still left in the stream:
         s.nextLine();
            //blank line for better readability:
         System.out.println();
            
         if(choice == 0)   //user has quit
         {
            done = true;
         }
         else  //user has chosen a method:
         {
                //calls method associated with given choice:
            switch(choice)
            {
               case 1:
                  f.countVowels();
                  break;
               case 2:
                  f.reverseIt();
                  break;
               case 3:
                  f.encrypt();
                  break;
               case 4:
                  f.showBoard();
                  break;
               case 5:
                  f.showPrimes();
                  break;
               case 6:
                  f.guessForDollars();
                  break;
               case 7:
                  f.yourOwn();
                  break;
               case 8:
                  f.countConsonants();
                  break;                  
               case 9:
                  f.showFancyBoard();
                  break;                 
               case 10:
                  f.reverseByWord();
                  break;    
               default:
                  break;
            }
         }
         System.out.println("Hit ENTER to go back to the main menu...");
         s.nextLine();
      }
      s.close();
      System.exit(0);  //closes console
   }
}
