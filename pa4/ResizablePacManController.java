/*
 * Name: Vanessa Chou
 * Login: cs11fbv
 * Date: October 24, 2014
 * File: ResizablePacManController.java
 * Sources of Help: Kristen Agcaoili, Connor Smith, Sherman Lee 
 *
 * This program will create the applet/canvas and implement the information 
 * provided by ResizablePacMan to create the PacMen. It will also create a
 * vertical and horizontal line that can be dragged and will proportionally 
 * adjust when the canvas size changes.   
 * 
 */

import objectdraw.*;
import java.awt.Color;

/*Name: ResizablePacManController
Purpose: Includes all the mouse event methods (press, release, click, drag)
and variables necessary to run the program. Also accounts for when the canvas
size is changed and where to put PacMen at on the canvas (at the mouse point
when it is clicked).  */
public class ResizablePacManController extends WindowController {
  private Line vLine, hLine;
  private double xValofhLine, yValofhLine, xValofvLine, yValofvLine, 
  widthProportionv, heightProportionv, widthProportionh, heightProportionh;
  private boolean vLineGrab, hLineGrab;//vertical, horizontal line is grabbed
  private double TOP_MARGIN = 5, LEFT_MARGIN = 5, RIGHT_MARGIN, BOTTOM_MARGIN,
  START_SIZE = 40;
  private ResizablePacMan pacMan;

/*Name: begin
Purpose: Runs when the program starts. Draws the lines on the canvas.
Parameter: None.
Return: void */
  public void begin() {
    vLine= new Line(getWidth()/2, 0 , getWidth()/2, getHeight(), canvas);
    /*draws the vertical line*/
    hLine= new Line(0, getHeight()/2, getWidth(), getHeight()/2, canvas);
    /*draws the horizontal line*/
    xValofvLine= getWidth()/2; //x value of vline is 1/2 of canvas Width
    yValofvLine= getHeight(); //y value of vline is canvas height   
    xValofhLine= getWidth(); //x value of hline is canvas width
    yValofhLine= getHeight()/2; //y value of hline is 1/2 of canvas height
    widthProportionv= xValofvLine/canvas.getWidth();/*widthProportion of 
    vline is the x value over canvas width*/
    heightProportionv= yValofvLine/canvas.getHeight();/*heightProportion
    of vline is the y value over canvas height*/
    widthProportionh= xValofhLine/canvas.getWidth();/*widthProportion of 
    hline is the x value over canvas height*/
    heightProportionh= yValofhLine/canvas.getHeight();/*heightProportion 
    of hline is the y value over canvas height*/
  }

  /*Name: onMousePress  
  Purpose: Runs when mouse is pressed.
  Parameter: Mouse location
  Return: void*/
  public void onMousePress(Location point) {
    if (vLine.contains(point)) {//if the mouse was pressed on vLine 
      vLineGrab = true;//vLine is grabbed
    }
    if (hLine.contains(point)) {//if the mouse was pressed on hLine
      hLineGrab = true;//hLine is grabbed
    }
  }
  
  /*Name: onMouseRelease
  Purpose: Runs when mouse is released after being pressed.
  Parameter: Mouse location
  Return: void*/
  public void onMouseRelease(Location point) {
    vLineGrab= false;//vLine is not being grabbed
    hLineGrab= false;//hLine is not being grabbed
  }
 
  /*Name: onMouseClick
  Purpose: Runs when mouse is clicked (press and release without movement).
  Parameter: Mouse location
  Return: void*/
  public void onMouseClick(Location point) {
    pacMan = new ResizablePacMan(point, START_SIZE, canvas, hLine, vLine);/*create
    a new ResizeablePacMan*/
  }
 
  /*Name: onMouseDrag
  Purpose: Runs when the mouse is being dragged (press and moved).
  Parameter: Mouse location
  Return: void*/
  public void onMouseDrag(Location point) {
    RIGHT_MARGIN= getWidth() - 5;
    BOTTOM_MARGIN= getHeight() - 5;
    if (vLineGrab && LEFT_MARGIN <= point.getX() && point.getX() <= RIGHT_MARGIN) { 
      vLine.setEndPoints(point.getX(),0, point.getX(), canvas.getHeight());
      //moves vLine when dragged
      xValofvLine= point.getX();/*updates x value of vline as the x value of
      the point where the mouse dragged to*/
      widthProportionv= xValofvLine/canvas.getWidth();/*updates widthProportion
      of vline*/
    }
    else if (hLineGrab && TOP_MARGIN <= point.getY() && point.getY() <= BOTTOM_MARGIN) {
      hLine.setEndPoints(0, point.getY(), canvas.getWidth(), point.getY());
      //moves hLine when dragged
      yValofhLine= point.getY();/*updates y value of hline as the y value of the 
      point where the mouse dragged to*/
      heightProportionh= yValofhLine/canvas.getHeight();//updates heightProportion of hline
    }
  }

  /*Name: paint
  Purpose: When canvas size changes
  Parameter: g
  Return: void*/
  public void paint( java.awt.Graphics g ) {
    super.paint( g );
    vLine.setEndPoints(canvas.getWidth() * widthProportionv, 0, 
    canvas.getWidth() * widthProportionv, canvas.getHeight()* 
    heightProportionv);/*moves vLine proporionally when the canvas size is 
    changed.*/
    hLine.setEndPoints(0, canvas.getHeight() * heightProportionh, 
    canvas.getWidth() * widthProportionh, canvas.getHeight() * 
    heightProportionh);/*moves hLine proportionally when the canvas size is 
    changed.*/
  }
}

