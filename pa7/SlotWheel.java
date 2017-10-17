/*
 * Name: Vanessa Chou
 * Login: cs11fbv
 * Date: November 10, 2014
 * File: SlotWheel.java
 * Sources of Help: Kristin Agcaoili 
 * 
 * This program wil create the wheels that will be displayed in Slots.java* 
 */

import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/*Name: SlotWheel
Purpose: Contains the run method that makes the slot wheels spin and 
the methods that randomize the images shown in the array. 
*/
public class SlotWheel extends ActiveObject implements ActionListener {
  private FramedRect slotWheelBorder;
  private RandomDoubleGenerator rand;
  private VisibleImage slotWheel;
  private DrawingCanvas canvas;
  private Image[] pic;
  private boolean pressButton =false;//button is not pressed

  private double quarter = 0.25; 
  private double half = 0.5;
  private double threeQuarter = 0.75;
  private double decimal;
  private static final double IMAGE_WIDTH = 110;
  private static final double IMAGE_HEIGHT = 145;

  private int newIndex;
  private int ticks;
  private int delay;
  private int originalTicks;//used when resetting the ticks
  private int two = 2;
  private int four = 4;
  private int six = 6;
  
  

  /*Name: SlotWheel (constructor)
  Purpose: Includes all the methods to manipulate the arrays in multiple ways
  Parameter: (Array, int, int, location, drawingcanvas)
  */
  public SlotWheel (Image[] pic, int ticks, int delay, Location location,
                    DrawingCanvas canvas) {

    rand = new RandomDoubleGenerator(0,1);
    decimal = rand.nextValue();//assigns the random double to decimal 
    int newIndex = getWheelIndex(decimal);/*newIndex is the int from 
                                          getWheelIndex*/    
    //1st random image that appears
    slotWheel = new VisibleImage(pic[newIndex], location, canvas);
    originalTicks= ticks;
    slotWheelBorder = new FramedRect (location, IMAGE_WIDTH, IMAGE_HEIGHT, canvas);
    this.ticks = ticks;
    this.delay = delay;
    this.pic = pic;
    start();
  }


  //Name: getWheelIndex
  //Purpose: Indicates which full picture to show on the slot wheel  
  //Parameter: double   
  //Return: int
  private int getWheelIndex(double decimal) {
    if (decimal < quarter){//if double is less than 0.25
      return 0;
      }
    if (quarter <= decimal && decimal < half){/*if the double is between
                                                0.25 and 0.5*/
      return two;
    }
    if (half <= decimal && decimal < threeQuarter){/*if the double is between
                                                     0.5 and 0.75*/
      return four;
    }
    if (threeQuarter <= decimal){//if the double is larger than 0.75
      return six;
    }
    else
      return six;
  }


  //Name: actionPerformed
  //Purpose: Resets the number of ticks the slot wheel spins  
  //Parameter: None.  
  //Return: void.
  public void actionPerformed(ActionEvent evt) {
    synchronized(this){ 
      if (((JButton)(evt.getSource())).getText().equals("Click to Spin")) { /*if 
      spinButton is clicked*/
        decimal= rand.nextValue();
        newIndex= getWheelIndex(decimal);
        slotWheel.setImage(pic[newIndex]);//new image when button is clicked
        ticks= originalTicks;//resets the ticks
        pressButton= true;
      }
    }
  }


  //Name: Run
  //Purpose: Runs in a forever loop. Makes the slotwheels spin. 
  //Parameter: None.  
  //Return: void.
  public void run(){
    while (true){
      synchronized(this){ 

        if (pressButton){//if button is pressed
          if (ticks>0){//if there are still ticks
            ++newIndex;
            if (newIndex == 8){
              newIndex= newIndex % 2;/*wraps back to the beginning of the 
                                       array*/
            }
            slotWheel.setImage(pic[newIndex]);//next image in the spin
            --ticks;//tick decrement
          }
        }
      }

      pause(delay);//pause after each iteration  
    }
  }
}
