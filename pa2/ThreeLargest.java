/*
 * Name: Vanessa Chou
 * Login: cs11fbv
 * Date: October 11, 2014
 * File: ThreeLargest.java
 * Sources of Help: Connor Smith, Sherman Lee, Kristen Agcaoili
 *
 * This program identifies the three largest dinstinct integers inputted from a 
 * command line. 
 */

import java.util.Scanner;

public class ThreeLargest {
	private static int largestNumber;
	private static int secondLargest;
  private static int thirdLargest;
	private static Scanner input = new Scanner(System.in);
  private static boolean uniqueNumbers = false;/*boolean for if the largest
  number is unique*/
  private static boolean uniqueNumbers2 = false;/*boolean for if the second
  largest value is unique*/
  private static boolean uniqueNumbers3 = false;/*boolean for if the third 
  largest value is unique*/

	public static void main(String [] args) {
		System.out.println("Enter a series of integers; EOF to Quit.");
		// Construct a Scanner that produces values scanned from standard input
    
    if (input.hasNext()) { //if there is at least 1 value in the series
      int number = input.nextInt(); 
      largestNumber = number;//set the first value as the largest 
		  if (input.hasNext()) { //if there is a second value in the series
        number = input.nextInt();
        secondLargest = number;/*set the second value as the second
        largest*/

        /*The following if statements compare the first and second values*/
        if (largestNumber != secondLargest) {/*if the first value is not equal 
        to the second value*/
          uniqueNumbers = true;//the largest number is unique
        }
        if (largestNumber < secondLargest) {/*if the first number is smaller 
        than the second number*/
          secondLargest = largestNumber;/*set the largest number (first value)
          to the second largest number*/ 
          largestNumber= number;//the second value is now the largest number
        } 
      }        
        if (input.hasNext()) { //if there is a third value in the series
          number = input.nextInt();//set the third value as number
          thirdLargest = number;

          /*The following if statements compare the second and third values*/
          if (secondLargest != thirdLargest) {
          uniqueNumbers2 = true;/*the second largest number is unique*/
          }
          if (thirdLargest != largestNumber) { 
            uniqueNumbers3 = true;/*the third largest number is unique*/
          }
          if (thirdLargest > largestNumber) {/*if the third value is bigger 
          than the first and second value*/
            thirdLargest = secondLargest;
            secondLargest = largestNumber;
            largestNumber = number;
          }
          else if (thirdLargest<largestNumber && thirdLargest>secondLargest) {
          /*if the third value is bigger than the second largest but smaller 
            than largest)*/
            thirdLargest = secondLargest; 
            secondLargest= number;
          } 
        } 
      
          //This while loop runs if there are more than three values inputted
          while (input.hasNext()) { /*while there is more input (user has not
          hit EOF)*/
		        number = input.nextInt(); // read next integer
            if (largestNumber != number) { 
              uniqueNumbers = true;//the largest number is unique
				    }
            if (secondLargest !=number) {
              uniqueNumbers2 = true;//the second largest number is unique
            }
            if (thirdLargest != number) {
              uniqueNumbers3= true;//the third largest number is unique
            }
            if (number > largestNumber) {/*if the number is larger than 
            largestNumber, it will replace largestNumber. The value of the 
            original largestNumber moves to secondLargest, and the original
            secondLargest will move to thirdLargest*/
				      thirdLargest = secondLargest;
              secondLargest = largestNumber;
					    largestNumber = number;
				    } else if (number > secondLargest && number < largestNumber) {/*if 
            the number is between the value of secondLargest and largestNumber,
            it will replace secondLargest. The original secondLargest will move 
            to thirdLargest*/
 				        thirdLargest = secondLargest;
                secondLargest = number;
            } else if (number > thirdLargest && number < secondLargest) {/*if 
            the number is between the value of thirdLargest and secondLargest, 
            it will replace thirdLargest*/
                thirdLargest = number;
              }
         
          }
          if (secondLargest == largestNumber) {/*check if second largest number
          is unique*/
            uniqueNumbers2 = false;
          }  
          if (thirdLargest == largestNumber || thirdLargest == secondLargest) {
          /*check if third largest number is unique*/
            uniqueNumbers3 = false;
          }
          System.out.println("Largest distinct number entered was" + 
          " " + largestNumber);
          if (uniqueNumbers2 == true) { //If the second largest number is unique
            System.out.println("Second largest distinct number entered was" + 
            " " + secondLargest);	 
            if (uniqueNumbers3 == true) {/*if the 
            third largest number is unique*/ 
              System.out.println("Third largest distinct number entered was" + 
              " " + thirdLargest);    
            }
          }
    }
    else { //when no numbers are inputted
 			System.out.println("No numbers entered.");
		}
  }
}

        
 
         

