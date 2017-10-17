/*
 * Name: Vanessa Chou
 * Login: cs11fbv
 * Date: October 11, 2014
 * File: FlippingMickey.java
 * Sources of Help: Kristen Agcaoili, Connor Smith, Sherman Lee 
 *
 * This program will add onto the Mickey.java file by adding more mouse 
 * events.  
 */

import objectdraw.*;
import java.awt.*;

/*Name: FlippingMickey
Purpose: To create an applet that presents instructions and the ability 
to create one Mickey-Mouse shaped face on a canvas at a time. Upon 
creation of the face the instructions will disappear. The face can be 
dragged and when the mouse leaves the canvas the silhouette disappears. 
It calls the mickey class to provide flipping methods and to create the parts 
of the Mickey.*/
public class FlippingMickey extends WindowController {
  private Text instr1, instr2, instr3;
  private static final int INSTR1_X = 50;
  private static final int INSTR1_Y = 50;
  private static final int INSTR2_X = INSTR1_X;
  private static final int INSTR2_Y = INSTR1_Y + 20;
  private static final int INSTR3_X = INSTR1_X;
  private static final int INSTR3_Y = INSTR2_Y + 20;
  private static final int FLIP_PRESS_THRESHOLD = 500; // Half a second
  private boolean mouseClicked = false;/*true or false value if the mouse 
  has been clicked; currently set to false*/
  private double oldX;
	private double oldY;
  private double currentX;
  private double currentY;
  private double sameX;
  private double sameY;
  private Mickey flippingMickey;
  private Timer timer;
  private boolean insideMickey = false;//if the mouse is inside Mickey


  /*Name: begin
    Purpose: To run when the program is first run. This creates the timer, 
    creates the Mickey object, and presents the instructions on the canvas.
    Parameter: None
    Return: void*/
  public void begin() {    
    timer = new Timer(); //creates the timer
    instr1 = new Text ("Click to display a Mickey silhouette" + " " + 
    "centered at the mouse click.", INSTR1_X, INSTR1_Y, 
    canvas); //displays 1st line of instructions
    instr2 = new Text("Mouse press in any part of the image" + " " + 
    "and drag to move image around.", INSTR2_X, INSTR2_Y, 
    canvas); //displays 2nd line of instructions
    instr3 = new Text("Mouse click in any part of the image" + " " + 
    "with a mouse press for more than 0.5 seconds to flip image.", INSTR3_X,
    INSTR3_Y, canvas);//displays 3rd line of instructions
  }

  /*Name: onMousePress
    Purpose: To run when the mouse is pressed, including when it is the start
    of a click.
    Parameter: Mouse location
    Return: void*/
  public void onMousePress(Location point) {//when the mouse is pressed
    timer.reset();//starts the timer when the mouse is pressed on Mickey
    
    //this is for when Mickey is being dragged 
    if (mouseClicked == true) {/*if the mouse has been clicked before & thus
    Mickey has been created*/
		  if (flippingMickey.contains(point)) {
        oldX = point.getX();//set point as oldX
        oldY = point.getY();//set point as oldY
        sameX= point.getX();
        sameY= point.getY();
        insideMickey = true;
      }
    }   
  }
  
  
  /*Name: onMouseRelease
    Purpose: To run when the mouse is released after a press. A press and a
    release equal a click. If the mouse is moved between the press and 
    release, it equals a drag. Running the method calculates the time 
    elapsed on the timer since the mouse was pressed.
    Parameter: Mouse location
    Return: void*/
  public void onMouseRelease(Location point){/*when the mouse is released 
  after being pressed*/
    /*Checks if Mickey has been pressed for more than 500 milliseconds and 
    then released; will flip Mickey if true*/
    if (timer.elapsedMilliseconds() > FLIP_PRESS_THRESHOLD && 
    point.getX()==sameX && point.getY()==sameY) {/*makes sure that it will 
    only flip if the location of the press and release are the same*/
      if (flippingMickey.inFace(point) && mouseClicked) {
        flippingMickey.flipUpDown();
      }
      else if (flippingMickey.inRightEar(point)) {
        flippingMickey.flipRight();
      }
      else if (flippingMickey.inLeftEar(point)) {
        flippingMickey.flipLeft();
      }
    }
    insideMickey = false;
  }

  /*Name: onMouseClick
    Purpose: Runs when the mouse is pressed and then released without movement
    in the middle. It hides the instructions and creates the silhouette if 
    mouseClicked is false; it then sets mouseClicked as true so another mouse 
    will not be created.
    Parameter: Mouse location
    Return: void*/  
  public void onMouseClick(Location point) {//when the mouse is clicked
    instr1.hide();//hides 1st line when mouse is clicked
    instr2.hide();//hides 2nd line when mouse is clicked
    instr3.hide();//hides 3rd line when mouse is clicked
    if (!mouseClicked) { //if mouse was not clicked before 	
      flippingMickey = new Mickey (point, canvas);/*creates a new Mickey 
      Object*/
      mouseClicked = true;
    }
  }
  
  /*Name: onMouseDrag
    Purpose: Runs if the mouse was pressed and released with movement in 
    between. This method allows the silhouette to be dragged around the canvas
    as long as the initial press was within either ear or the face.
    Parameter: Mouse location
    Return: void*/
  public void onMouseDrag(Location point) {//when the mouse is dragged
    //Moves Mickey as mouse is being dragged
        currentX = point.getX(); 
        currentY = point.getY();
        if (flippingMickey.contains(point) && insideMickey){/*if the first 
        click was insideMickey*/
          flippingMickey.move(currentX-oldX, currentY - oldY);
        }
        oldX= point.getX();
        oldY= point.getY();
  }
  
	
  //Name: onMouseExit
  /*Purpose: Runs when the mouse exits the canvas. If a silhouette had been 
   * created beforehand, this method makes it disappear. mouseClicked is set 
   * to false so it is possible that the silhouette can be created again.
   * Parameter: Mouse location
     Return: void*/
  public void onMouseExit(Location point) { //when mouse exits screen
    if (mouseClicked == true) {//if Mickey has been created beforehand
      flippingMickey.removeFromCanvas();
      mouseClicked = false; /*mouse click set to false so Mickey will appear 
      again when the screen is clicked next time*/
    }
  }

  //Name: onMouseEnter
  /*Purpose: Runs when the mouse re-enters the canvas. The instructions are
   * once again shown in the same position as before.
   * Parameter: Mouse location
   * Return: void*/
  public void onMouseEnter(Location point) {//when mouse enters the screen
    instr1.show();//1st line of instructions reappear
    instr2.show();//2nd line of instructions reappear
    instr3.show();//3rd line of instructions reappear
  }	
} 
