import java.util.Scanner;
public class TasksTester
{
   public static void main(String[] args)
   {
      Scanner keybd = new Scanner(System.in);
        
      Tasks tasks = new Tasks(); //object to be able to call methods from
        
        //EXAMPLE:
      
      //find out if one car can fit all others, given test data:
      boolean answer;
      answer = tasks.fourFitInOne(1, 2, 3, 40, 5); //you'll need to write this
                                                   // method in Tasks.java!!!!
      
      //display results to user (this will later be done in GUI):
      if(answer == true) //or just if(answer)
         System.out.println("You'll only need one car!!!");
      else
         System.out.println("You'll need all 5 cars :(");   
   }
}