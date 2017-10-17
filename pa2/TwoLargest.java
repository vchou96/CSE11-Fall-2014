/*
 * Name: Vanessa Chou
 * Login: cs11fbv
 * Date: October 11, 2014
 * File: TwoLargest.java
 * Sources of Help: Connor Smith, Sherman Lee, Kristen Agcaoili
 *
 * This program identifies the two largest distinct integers inputted from a 
 * command line. 
 */

import java.util.Scanner;

public class TwoLargest {
	private static int largestNumber;
	private static int secondLargest;
	private static Scanner input = new Scanner(System.in);
  private static boolean uniqueNumbers = false;/*boolean for if the two values 
  being compared are unique or not*/

	public static void main(String [] args) {
		System.out.println("Enter a series of integers; EOF to Quit.");
		// Construct a Scanner that produces values scanned from standard input
    
    if (input.hasNext()) { //if there is at least 1 value in the series
      int number = input.nextInt();//set the first value to "number" 
		  largestNumber = number;//set number as the largest value
      if (input.hasNext()) { //if there is a second value in the series
        number = input.nextInt();/*set the second value as number, replacing 
        the first value*/

        //The following if statements compare the first and second values
        if (largestNumber != number) {/*if the first value is not equal to the
        second value*/
          uniqueNumbers = true;//the two numbers are different and unique
        }
        if (largestNumber < number) {/*if the first number is smaller than the 
        second number*/
          secondLargest = largestNumber;/*set the largest number (first value)
          to the second largest number*/ 
          largestNumber= number;//the second value is now the largest number
        }       
      }

        //This while loop runs if there are more than two values inputted
        while (input.hasNext()) { /*while there is more input (user has not
        hit EOF)*/
		      number = input.nextInt(); // read next integer
          if (largestNumber != number) { 
            uniqueNumbers = true;//the numbers are unique
				  }
          if (number > largestNumber) {/*if the number is larger than 
          largestNumber, it will replace largestNumber, and the value of the 
          original largestNumber moves to secondLargest*/
				    secondLargest = largestNumber;
					  largestNumber = number;
				  } else if (number > secondLargest && number < largestNumber) {/*if the 
          number is between the value of secondLargest and largestNumber, it 
          will replace secondLargest*/
 				      secondLargest = number;
            }
        }
        System.out.println("Largest distinct number entered was" + " " +
        largestNumber);
        if (uniqueNumbers == true) { //If at least two values are unique
          System.out.println("Second largest distinct number entered was" + " "
          + secondLargest);	 
        }    
    }
    else { //when no numbers are inputted
 			System.out.println("No numbers entered.");
		} 
  }
}

        
 
         
     
 
		
	




