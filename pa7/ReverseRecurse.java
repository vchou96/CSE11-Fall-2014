/*
 * Name: Vanessa Chou
 * Login: cs11fbv
 * Date: November 10, 2014
 * File: ReverseRecurse.java
 * Sources of Help: Connor Smith, Luis Llobera
 * 
 * This program will set a series of numbers inputted by the user into an 
 * array and manipulate the order of the numbers. 
 */

import java.util.Scanner;


  /*Name: ReverseRecurse
  Purpose: Includes all the methods to manipulate the arrays in multiple ways
  */
  public class ReverseRecurse {
    private Scanner in = new Scanner(System.in);//scanner for integers
    private Scanner maxNum = new Scanner(System.in);//scanner for max number
    private int[] array;//used when putting integers into the array
    private int[] array2;/*copies the numbers from array. This is in case array
                           gets less integers than indicated by the max number*/
    private int size = 0;
    private int i = 0;
    private int second=2;
    

  /*Name: initArray
    Purpose: Sets up the array 
    Parameters: none
    Return: int[]*/
    public int[] initArray() { 
      
      //Asking for the max number
      while(size <= 0) {
        System.out.print(PA7Strings.MAX_NUM); 
        
        if (!maxNum.hasNextInt()){/*if EOF or non-integer inputted when asking
                                  for the max number*/
          System.exit(1);
        }

        size = maxNum.nextInt();
        if (size > 0){
          array = new int[size];//makes array as large as the max # of ints
          System.out.printf(PA7Strings.ENTER_INTS, size);
        }
        else {//If max number entered is 0 or smaller than 0
          System.out.print(PA7Strings.TOO_SMALL);
          System.out.println("");
        }
      }

      //If no integers entered  
      if (!in.hasNextInt()){
        array2=new int[0];//Empty Array           
      }

      //Assigning the integers into the array
      while (i < size && in.hasNextInt()){
        array[i]=in.nextInt();   
        i++;
        array2= new int[i];
        System.arraycopy(array, 0, array2, 0, i);/*in case array gets less 
                                                  integers than max number*/     
      }
      return array2;  
    }


    /*Name: printArray
    Purpose: Prints the array in order
    Parameters: array
    Return: void*/
    public void printArray( int[] array ) { 
      //Empty Array
      if (array.length==0){
        System.out.print(PA7Strings.EMPTY);  
      }

      //Prints integers in order
      for (int i = 0; i < array.length; i++) {
        System.out.print(array[i] + " ");
      }    
      System.out.println("");   
      System.out.println(""); 
    }


  /*
  * The following two reverse() methods must be implemented using
  * recursion.
  */

  /*Name: reverse
    Purpose: Reverses the original array directly
    Parameters: originalArray, int low, int high
    Return: void
    */
    public void reverse( int[] originalArray, int low, int high ) { 
      if (low<high && originalArray!=null) {/*base case: when low becomes equal 
                                          to or greater than high*/     
      int temp;
      temp= originalArray[low];
      originalArray[low] = originalArray[high];
      originalArray[high] = temp; //swaps the high and low numbers
      reverse(originalArray, ++low, --high);/*high is now the integer before 
                                            the original high and low is now 
                                            the integer after original low*/
    }
  }

  /*Name: reverse
  Purpose: To reverse the array by recursively creating new arrays and 
           swapping the first and last integers each time. 
  Parameters: originalArray
  Return: int[]
  */
  public int[] reverse( int[] originalArray ) { 
    int[] newArray;
    int[] newArray2;
    
    if (originalArray == null){
      return originalArray; 
      }
    else if (originalArray.length <= 1){
      return originalArray;//base case
    }  

    /*Makes two new arrays each time; one has the first and last integers
    swapped while the other has the rest of the middle numbers*/
    else{      
      newArray = new int[originalArray.length];
      newArray[originalArray.length-1] = originalArray[0];
      newArray[0] = originalArray[originalArray.length-1];
      if (newArray.length == second){
        return newArray;      
      }
      newArray2 = new int[newArray.length-second];
      System.arraycopy(originalArray, 1, newArray2, 0, newArray.length-second);
      newArray2 = reverse(newArray2);
    }

      //Building the array back together
      for (i=0; i < newArray2.length; i++) {
        newArray[i+1] = newArray2[i];
      }
    return newArray;
  }
}
