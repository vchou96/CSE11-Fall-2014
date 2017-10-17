/*
 * Name: Vanessa Chou
 * Login: cs11fbv
 * Date: November 10, 2014
 * File: Slots.java
 * Sources of Help: Kristin Agcaoili 
 * 
 * This program makes a slot machine game by cycling through image arrays.  
 */

import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/*Name: Slots
* Purpose: Creates the label/buttons and makes the three slotwheels on 
* the screen.
*/
public class Slots extends WindowController implements ActionListener {

  private static final int NUM_OF_IMAGES = 8;
  private static final double IMAGE_WIDTH = 110;
  private static final double IMAGE_HEIGHT = 145;
  private static final double WHEELS_Y_OFFSET = 5;
  private static final double SPACE_BETWEEN_WHEELS = 5;
  private static final int WHEEL_1_TICKS = 22;
  private static final int WHEEL_2_TICKS = WHEEL_1_TICKS + 6;
  private static final int WHEEL_3_TICKS = WHEEL_2_TICKS + 6;
  private static final int WHEEL_1_DELAY = 100;
  private static final int WHEEL_2_DELAY = WHEEL_1_DELAY + 25;
  private static final int WHEEL_3_DELAY = WHEEL_2_DELAY + 25;
  private int two=2;
  private int three= 3;
  private int four= 4;
  private int five= 5;
  private int six= 6;
  private int seven= 7;

  private JPanel topPanel, bottomPanel;
  private JLabel topLabel;
  private JButton spinButton;
  private Container contentPane;
    
  private Location locWheel1;//left wheel location
  private Location locWheel2;//middle wheel location
  private Location locWheel3;//right wheel location  
  private Location point;

  private SlotWheel wheel1;//left wheel
  private SlotWheel wheel2;//middle wheel
  private SlotWheel wheel3;//right wheel

  private Image[] pic;//array of pictures


  /*Name: begin
  Purpose: Runs immediately when the program starts
  Parameter: None
  Return: void*/
  public void begin() { 

  //Adding the buttons and labels
  topPanel= new JPanel();
  bottomPanel= new JPanel();
  topLabel = new JLabel("Vanessa's Viva Lost Wages!");
  topLabel.setFont(new Font("Serif", Font.PLAIN, 24));//changing font
  spinButton = new JButton("Click to Spin");
  spinButton.addActionListener(this);  
  topPanel.add(topLabel);
  bottomPanel.add(spinButton);
  this.add(topPanel, BorderLayout.NORTH);//adds title to top
  this.add(bottomPanel, BorderLayout.SOUTH);//adds button to bottom
  topPanel.validate();
  bottomPanel.validate();
  this.validate();

  //Makes the image array
  pic = new Image[NUM_OF_IMAGES]; 
  pic[0] = getImage("sungod.jpg");
  pic[1] = getImage("sungod-bear.jpg");
  pic[two] = getImage("bear.jpg");
  pic[three] = getImage("bear-triton.jpg");
  pic[four] = getImage("triton.jpg");
  pic[five] = getImage("triton-library.jpg");
  pic[six] = getImage("library.jpg");
  pic[seven] = getImage("library-sungod.jpg");

  //Puts the wheels on the applet canvas
  locWheel1= new Location(((canvas.getWidth() - IMAGE_WIDTH)/two)- IMAGE_WIDTH
                            - SPACE_BETWEEN_WHEELS, WHEELS_Y_OFFSET);
  locWheel2= new Location((canvas.getWidth() - IMAGE_WIDTH)/two, 
                           locWheel1.getY());
  locWheel3= new Location(locWheel2.getX() + IMAGE_WIDTH + 
                          SPACE_BETWEEN_WHEELS, locWheel2.getY());
  wheel1 = new SlotWheel(pic, WHEEL_1_TICKS, WHEEL_1_DELAY, locWheel1, 
                         canvas);//creates left wheel
  wheel2 = new SlotWheel(pic, WHEEL_2_TICKS, WHEEL_2_DELAY, locWheel2, 
                         canvas);//creates middle wheel
  wheel3 = new SlotWheel(pic, WHEEL_3_TICKS, WHEEL_3_DELAY, locWheel3, 
                         canvas);//creates right wheel
  
  //Makes wheels listen to button
  spinButton.addActionListener(wheel1);  
  spinButton.addActionListener(wheel2);
  spinButton.addActionListener(wheel3);
  }


  //ActionListener
  /*Name: actionPerformed
  Purpose: Runs when an action is performed
  Parameter: ActionEvent evt
  Return: void*/
  public void actionPerformed(ActionEvent evt) {
    if (((JButton)(evt.getSource())).getText().equals("Click to Spin")) { /*if 
    spinButton is clicked*/              
    }
  }
}
