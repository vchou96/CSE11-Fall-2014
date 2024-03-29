/*
 * Name: Vanessa Chou
 * Login: cs11fbv
 * Date: November 6, 2014
 * File: ResizablePacMan.java
 * Sources of Help: Connor Smith
 * 
 * This program will provide information for the PacMen themselves. 
 * ResizablePacManController will use this information when it opens the 
 * applet and creates the PacMen on the canvas.    
 * 
 */
 
import java.awt.Color;
import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


//Name: ResizablePacMan
//Purpose: To include all the PacMan information necessary and the run method 
//to create PacMen when ResizablePacManController is run. All the pacMan 
//related actions are in here.
public class ResizablePacMan extends ActiveObject implements MouseListener, 
MouseMotionListener, ActionListener, ChangeListener {
  private final double GROWTH = 2, ARC_ANGLE = 300, MAX_DEGREES = 360, 
  START_SIZE = 40, START_ANGLE = 0;  
  private final int CHANGE_ANGLE = 10;
   
  private FilledArc pacMan;
  private Line vLine, hLine;

  private double SIZE= 40, TWICE_SIZE= SIZE*2, HALF_SIZE= 
  SIZE/2, WIDTH= 40, HEIGHT = 40, HALF_GROWTH = GROWTH/2, TOP_MARGIN = 5, 
  LEFT_MARGIN = 5, RIGHT_MARGIN, BOTTOM_MARGIN, oldX, oldY, distanceCenterX, 
  distanceCenterY, centerX, centerY, HALF=2; 

  private boolean growingPacMan = true, stopped, pacManGrab= false, 
  pacManCreated=false, clockwise= true;/*if pacMan is growing; if the stop 
  button was clicked and the pacMan are stopped; if a pacMan is grabbed; if
  a pacMan was created; if the pacMan is spinning clockwise;*/     

  private int newStartAngle = 0, PAUSE_TIME = 50, MIN_SPEED = 1, MAX_SPEED= 
  100, speedCount;
  /*start angle; pause time; max and minimum speeds; speed of the Pacmen*/
  
  private Location point, center;//mouse location; location of center of pacMan
  private DrawingCanvas canvas;


//Name: ResizablePacMan (constructor)
//Purpose: Codes for the actual PacMen. 
//Parameter: Location center, double size, canvas, line, line, int, boolean 
//clockwise, boolean clockwise 
  public ResizablePacMan (Location center, double size, DrawingCanvas canvas,
  Line hLine, Line vLine, int speedCount, boolean stopped, boolean clockwise) {
    
    pacMan = new FilledArc(center, WIDTH, HEIGHT, 
    START_ANGLE, ARC_ANGLE, canvas);
    pacManCreated= true;
    this.center = center;
    this.vLine= vLine;
    this.hLine= hLine;
    this.canvas= canvas;
    this.speedCount = speedCount;
    this.stopped = stopped;
    this.clockwise = clockwise;
    this.pacManCreated = pacManCreated; 
    start();
  }

  //MouseListener
  /*Name: mouseClicked
  Purpose: Runs when mouse is clicked (press and release without movement).
  Parameter: MouseEvent evt
  Return: void*/
  public void mouseClicked(MouseEvent evt) {
  }

  /*Name: mouseEntered
  Purpose: Runs when mouse enters the canvas.
  Parameter: MouseEvent evt
  Return: void*/
  public void mouseEntered(MouseEvent evt) { 
  }
  
  /*Name: mouseExited
  Purpose: Runs when mouse exits the canvas.
  Parameter: MouseEvent evt
  Return: void*/
  public void mouseExited(MouseEvent evt) {
  }
  
  /*Name: mouseMoved
  Purpose: Runs when mouse is moved.
  Parameter: MouseEvent evt
  Return: void*/
  public void mouseMoved(MouseEvent evt) {
  
  /*Name: mouseReleased
  Purpose: Runs when mouse is released after being pressed.
  Parameter: MouseEvent evt
  Return: void*/
  }
  public void mouseReleased(MouseEvent evt) {
    pacManGrab = false;
  }


  //MouseMotionListener
  /*Name: mousePressed  
  Purpose: Runs when mouse is pressed.
  Parameter: MouseEvent evt
  Return: void*/
  public void mousePressed(MouseEvent evt) {
    point = new Location (evt.getX(), evt.getY());
    if (pacMan.contains(point)) {//if the mouse is pressed on the pacMan
      pacManGrab = true;
      oldX = evt.getX();//previous x value used when dragging
      oldY = evt.getY();//previous y value used when dragging
      centerX= pacMan.getX() + pacMan.getWidth()/HALF;//x value of the center
      centerY= pacMan.getY() + pacMan.getHeight()/HALF;//y value of the center
      distanceCenterX = oldX - pacMan.getX() - HALF_SIZE;/*distance from oldX 
      to x value of the center of face*/
      distanceCenterY = oldY - pacMan.getY() - HALF_SIZE;/*distance from oldY 
      to y value of the center of face*/  
    }
  }

  /*Name: mouseDragged
  Purpose: Runs when the mouse is being dragged (press and moved).
  Parameter: MouseEvent evt
  Return: void*/
  public void mouseDragged(MouseEvent evt) {
    RIGHT_MARGIN= canvas.getWidth() - 5;
    BOTTOM_MARGIN= canvas.getHeight() - 5;
    
    center = new Location(pacMan.getX() +pacMan.getWidth()/HALF, pacMan.getY()
    + pacMan.getHeight()/HALF);/*moving the center appropriately when running*/

    if ((evt.getX() - HALF_SIZE - distanceCenterX + pacMan.getWidth()/HALF) > 
    LEFT_MARGIN && (evt.getX() - HALF_SIZE - distanceCenterX < RIGHT_MARGIN - 
    pacMan.getWidth()/HALF) &&  (evt.getY() - HALF_SIZE - distanceCenterY + 
    pacMan.getHeight()/HALF) > TOP_MARGIN && (evt.getY() - HALF_SIZE - 
    distanceCenterY < BOTTOM_MARGIN - pacMan.getHeight()/HALF)) {
    /*makes the pacMen not go past the margins*/  
      
      if (pacManGrab) { 
        
        if (centerX >= LEFT_MARGIN && centerX <= RIGHT_MARGIN && centerY >= 
        TOP_MARGIN && centerY <= BOTTOM_MARGIN) { /*if the center is within 
        the margins*/ 
        
          pacMan.moveTo(evt.getX() - HALF_SIZE - distanceCenterX, evt.getY() 
          - HALF_SIZE - distanceCenterY);/*dragging the pacMan*/
        }
      }
    }
  }



//Name: Run
//Purpose: To make the PacMen rotate counterclockwise and resize themselves 
//in an infinity loop. Also provides the colors of the PacMen depending on 
//the quadrant.  
//Parameter: None.  
//Return: void.
  public void run() {
    //infinity loop so this always runs
    while (true) {
      //need to update size
      if (center.getX() >= vLine.getStart().getX() && center.getY() <= 
        hLine.getStart().getY()) {//if the center is in the 1st quadrant
        pacMan.setColor(Color.cyan);
      }
      if (center.getX() <= vLine.getStart().getX() && center.getY() <=
        hLine.getStart().getY()) {//if the center is in the 2nd quadrant
        pacMan.setColor(Color.magenta);
      }
      if (center.getX() <= vLine.getStart().getX() && center.getY() >=
        hLine.getStart().getY()) {//if the center is in the 3rd quadrant
        pacMan.setColor(Color.yellow);
      }
      if (center.getX() >= vLine.getStart().getX() && center.getY() >=
        hLine.getStart().getY()) {//if center is in the 4th quadrant
        pacMan.setColor(Color.black);
      }
      if (pacMan == null) {
        pacManCreated= false;
      }
      if (!stopped) {/*begins as not stopped, turns into stopped when Stop 
      button is pressed*/
        if (SIZE < TWICE_SIZE && growingPacMan) {//Growing
          SIZE= SIZE + GROWTH;
          WIDTH= WIDTH + GROWTH;
          HEIGHT= HEIGHT + GROWTH;
          pacMan.setSize(WIDTH, HEIGHT);
          pacMan.move(-HALF_GROWTH, -HALF_GROWTH);
        }
        else if (SIZE == TWICE_SIZE && growingPacMan) {//stops growing
          growingPacMan= false;

        }
        else if (SIZE > HALF_SIZE && !growingPacMan) {//Shrinking
          SIZE = SIZE - GROWTH;
          WIDTH= WIDTH - GROWTH;
          HEIGHT= HEIGHT - GROWTH;
          pacMan.setSize(WIDTH, HEIGHT);
          pacMan.move(HALF_GROWTH, HALF_GROWTH);
        }
        else if (SIZE == HALF_SIZE && !growingPacMan) {//stops shrinking       
          growingPacMan = true;
        }
            
        //Rotates the PacMen clockwise
        if (clockwise) {
          newStartAngle = (newStartAngle - CHANGE_ANGLE) % (int)MAX_DEGREES;
          pacMan.setStartAngle(newStartAngle); 
        }
        //Rotates the PacMan counterclockwise
        if (!clockwise) {
          newStartAngle = (newStartAngle + CHANGE_ANGLE) % (int)MAX_DEGREES;
          pacMan.setStartAngle(newStartAngle); 
        }
        
        pause(MAX_SPEED- speedCount);//pauses after each iteration
      }
    }
  }
  //ActionListener
  /*Name: actionPerformed
  Purpose: Runs when an action is performed
  Parameter: ActionEvent evt
  Return: void*/
  public void actionPerformed(ActionEvent evt) {
    if (((JButton)(evt.getSource())).getText().equals("Start")) { /*if Start 
    button pressed*/
        stopped = false;//pacMen run 
            
    }
    if (((JButton)(evt.getSource())).getText().equals("Stop")) { /*if stop 
    button pressed*/
        stopped = true;//pacMen stop    
      
    }
    if (((JButton)(evt.getSource())).getText().equals("Clear All")) { /*if 
    Clear All button pressed*/
      if (pacManCreated) {//if there are pacMen on the canvas
        pacMan.removeFromCanvas();
        pacManCreated = false;//no pacMen on canvas
      }
    }
    if (((JButton)(evt.getSource())).getText().equals("Switch Spin")) { /*if
    Switch Spin button pressed*/
      if (clockwise) {//if it was spinning clockwise
        clockwise = false;//it is now counterclockwise
      }
      else {
        clockwise = true;//it is now spinning clockwise
      }
    }
  }


  //ChangeListener
  //get new rotation speed from slider    
  /*Name: stateChanged
  Purpose: Runs when state changes in the slider.
  Parameter: ChangeEvent evt
  Return: void*/
  public void stateChanged(ChangeEvent evt) {
    //speedCount = speedSlider.getValue();
    speedCount = ((JSlider)(evt.getSource())).getValue();
     
  }
  
   
}

