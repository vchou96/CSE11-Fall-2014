/*
 * Name: Vanessa Chou
 * Login: cs11fbv
 * Date: October 17, 2014
 * File: Triangles.java
 * Sources of Help: Kristen Agcaoili, Luis Llobrera
 *
 * This program displays triangle patterns using asterisks and spaces. The 
 * number of rows of asterisks is a number from 1 < x that can be inputted 
 * directly into the terminal. */

import java.util.Scanner;

public class Triangles {
  private static int number;
  private static int rowCounter = 1;//counts number of rows starting with row 1
  private static int asteriskCounter = 0;/*number of asterisks in a line. 
  First triangle will be incrementing until it reaches number so set this as 
  0 first.*/
  private static int spaceCounter;//number of spaces in a line
  private static int spaceRowCounter= rowCounter + 1;/*space triangles are 1 
  vertical column smaller than a asterisk triangle. The singular space in 
  between a space triangle and asterisk triangle for each row will be added 
  later. spaceRowCounter is the rowCounter specifically for space triangles. It
  is set to rowCounter + 1 currently so that the while loop for the second 
  triangle will loop one time less than if it used rowCounter, and so there is 
  one less space in each row for that triangle.*/
  private static int MIN_NUMBER = 1;//number inputted cannot be smaller than 1
  private static Scanner input = new Scanner(System.in);
  
  public static void main(String [] args) {
    System.out.print ("Enter the size of the triangles to display:");
    if (input.hasNext()) {//if there is a value inputted  
    number = input.nextInt();//set number to the value inputted
    spaceCounter = number;/*Second triangle will be decrementing until it 
    reaches 0 so set this as number.*/
      if (number > MIN_NUMBER) {//if the value inputted is larger than 1  
        while (rowCounter <= number) {/*loops for every row made until it goes 
        over number, then it stops. Ensures number of rows will be equal to 
        number inputted*/
          
          //Forms first triangle (of asterisks) starting from left*/
          while (asteriskCounter < rowCounter) {/*loops until number of 
          asterisks is equal to row number*/
            System.out.print("*");
            ++asteriskCounter;//asteriskCounter increment by 1
          }
          asteriskCounter = number;/*sets for next asterisk triangle (the 
          third triangle)*/ 
   
          //Forms second triangle (of spaces) starting from left*/
          while (spaceCounter >= spaceRowCounter) {/*loops until number of 
          spaces is equal to row number - 1*/
 	          System.out.print(" ");
            --spaceCounter;//spaceCounter decrement by 1
          }          
          spaceCounter = 0;//sets for next space triangle (the fourth triangle)
          System.out.print(" ");//forms the vertical column of spaces
          
          //Forms third triangle (of asterisks) starting from left*/
          while (asteriskCounter >= rowCounter) {/*loops until asteriskCounter
          decrements to the row number*/
            System.out.print("*");
            --asteriskCounter;//asteriskCounter decrement by 1
          }
          asteriskCounter = number;/*sets for next asterisk triangle (the sixth
          triangle*/
          spaceRowCounter = rowCounter - 1;/*Since the next two space triangles
          are incrementing as they go down the rows, spaceRowCounter for them 
          needs to be rowCounter - 1 to ensure that it will loop one less 
          time*/

          //Forms fourth triangle (of spaces) starting from left*/
          while (spaceCounter < spaceRowCounter) {/*loops until number of 
          spaces is equal to row number - 1*/
 	          System.out.print(" ");
            ++spaceCounter;//spaceCounter increment by 1
          }
          spaceCounter = 0;//sets for next space triangle (the fifth triangle)
          System.out.print(" ");
          
          //Forms fifth triangle (of spaces) starting from left*/
          while (spaceCounter < spaceRowCounter) {/*loops until number of 
          spaces is equal to row number  - 1*/
            System.out.print(" ");
            ++spaceCounter;//spaceCounter increment by 1
          }
          spaceCounter = number;/*sets for next space triangle (the seventh 
          triangle*/
          spaceRowCounter = rowCounter + 1;/*Since the next space triangle
          is decrementing as it go down the rows, spaceRowCounter for it 
          needs to be rowCounter + 1 to ensure that it will loop one less time*/

          //Forms sixth triangle (of asterisks) starting from left*/
          while (asteriskCounter >= rowCounter) {/*loops until asteriskCounter
          decrements to the row number*/
 	          System.out.print("*");
            --asteriskCounter;//asteriskCounter decrement by 1
          }      
          asteriskCounter = 0;/*sets for next asterisk triangle (the eighth
          triangle)*/

          //Forms seventh triangle (of spaces) starting from left*/
          while (spaceCounter >= spaceRowCounter) {/*loops until spaceCounter
          decrements to spaceRowCounter AKA row number - 1*/ 
            System.out.print(" ");
            --spaceCounter;//spaceCounter decrement by 1
          }
          spaceCounter = number;/*sets for next space triangle (the second 
          triangle)*/
          System.out.print(" ");
          
          //Forms eighth triangle (of asterisks) starting from left*/
          while (asteriskCounter < rowCounter) { /*loops until number of 
          asterisks is equal to row number*/
 	          System.out.print("*");
            ++asteriskCounter;//asteriskCounter increment by 1
          }
          asteriskCounter = 0;/*sets for next asterisk triangle (the first 
          triangle*/ 
          
          System.out.println("");//forms the next row
          ++rowCounter;//row count goes up by 1
          ++spaceRowCounter;//row count for spaces goes up by 1
        }
      }
      else { //if the number inputted is 1 or less
        System.out.println("Triangle size must be > 1; Try again.");
      }
    }
  }
}
