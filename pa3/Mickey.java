/*
 * Name: Vanessa Chou
 * Login: cs11fbv
 * Date: October 11, 2014
 * File: Mickey.java
 * Sources of Help: Kristen Agcaoili, Connor Smith, Sherman Lee 
 *
 * This program will draw a Mickey Mouse-shaped silhouette that responds to 
 * different mouse events.  
 */

import objectdraw.*;
import java.awt.*;

/*Name: Mickey
Purpose: FlippingMickey will call this class to provide the flipping events
and parts of Mickey.*/ 
public class Mickey {
	private static final int INSTR1_X = 50; /*x position of the start of the 
  first line of instructions*/
	private static final int INSTR1_Y = 50; /*y position of the start of the
  first line of instructions*/
	private static final int INSTR2_X = INSTR1_X;/*x position of the beginning
  of the second line is the same as the x position of the first line*/
	private static final int INSTR2_Y = INSTR1_Y + 20;/*y position of the 
  start of the second line is 20 pixels under the y position of the first 
  line*/ 
	private static final int FACE_RADIUS = 50;//radius of the "face"
	private static final int EAR_RADIUS = 30;//radius of each "ear"
	private static final int EAR_OFFSET = 50; /* Center of each ear is this 
  offset up and over (x and y) from center of face.*/
	private static final int FACE_DIAMETER = FACE_RADIUS * 2;/*diameter of the 
  "face" is twice the radius of the "face"*/
	private static final int EAR_DIAMETER = EAR_RADIUS * 2;/*diameter of the 
  "ear" is twice the radius of a "ear"*/
	private FilledOval face;
	private FilledOval leftEar;
	private FilledOval rightEar; 
	private boolean mouseClicked = false;/*true/false value if the mouse has 
  been clicked; currently set to false*/
  private boolean flippedDown = false;/*if the silhouette had been flipped 
  down before*/
	private DrawingCanvas canvas;
  
  /*Name: contains
  Purpose: Sees if a point is contained in the face or leftEar or rightEar or 
  not
  Parameter: Mouse location
  Return:boolean true/false*/
  public boolean contains( Location point ) {
    if (face.contains(point)||leftEar.contains(point)||
    rightEar.contains(point)){
      return true;
    }
    else {
      return false;
    }
  }
  
  /*Name: inFace
  Purpose: To make sure the point is in the face  
  Parameter: Mouse location
  Return: boolean true/false*/
  public boolean inFace( Location point ) {
    if (face.contains(point)) {
      return true;
    }
    else {
      return false;
    }
  }
  
  /*Name: inLeftEar
  Purpose:Makes sure point is in the leftEar
  Parameter:Mouse location
  Return: boolean true/false*/
  public boolean inLeftEar( Location point ) {
    if (leftEar.contains(point)) {
      return true;
    }
    else {
      return false;
    }
  }

  /*Name: inRightEar
  Purpose:Makes sure point is in the rightEar 
  Parameter:Mouse location
  Return: boolean true/false*/
  public boolean inRightEar( Location point ) {
    if (rightEar.contains(point)) {
      return true;
    }
    else {
      return false;
    }
  }

  /*Name: move
  Purpose:Moves object 
  Parameter:Double change in x, double change in y
  Return:void*/
  public void move( double dx, double dy ) {
    face.move(dx, dy);    
    leftEar.move(dx,dy);
    rightEar.move(dx,dy);
  }

  /*Name: removeFromCanvas
  Purpose:Removes object from canvas
  Parameter:None
  Return:void*/
  public void removeFromCanvas() {
    face.removeFromCanvas();
    leftEar.removeFromCanvas();
    rightEar.removeFromCanvas();
  }
  
 /*Name: Mickey 
   Purpose: Create mickey object
   Parameter: Mouse location, canvas*/
  public Mickey( Location point, DrawingCanvas canvas ) { // ctor
    //Creation of Mickey
    face = new FilledOval(point.getX() - FACE_RADIUS, point.getY() - 
    FACE_RADIUS, FACE_DIAMETER, FACE_DIAMETER, canvas); //creates the face
    leftEar = new FilledOval(point.getX() - EAR_RADIUS - EAR_OFFSET, 
    point.getY() - EAR_RADIUS - EAR_OFFSET, EAR_DIAMETER, EAR_DIAMETER, 
    canvas); //creates the left ear
    rightEar = new FilledOval(point.getX() - EAR_RADIUS + EAR_OFFSET, 
    point.getY() - EAR_RADIUS - EAR_OFFSET, EAR_DIAMETER, EAR_DIAMETER, 
    canvas); //creates the left ear
    mouseClicked = true;//mouse is now considered "clicked"
  }
  
  //Name: flipLeft
  /*Purpose: To flip the silhouette left (when the mouse is pressed on the 
  ear for more than 500 miliseconds and released) using the middle of the ear
  as the axis.
  Parameter: none
  Return: void*/
  public void flipLeft() {
    rightEar.move(-FACE_DIAMETER, 0);//moves rightEar left
    leftEar.move(-FACE_DIAMETER, 0); //moves leftEar left 
    face.move(-FACE_RADIUS - FACE_RADIUS, 0); /*flips the face across the 
    middle axis of the left ear*/
  }
  
  //Name: flipRight
  /*Purpose: To flip the silhouette right (when the mouse is pressed on the 
  ear for more than 500 miliseconds and released) using the middle of the ear 
  as the axis.
  Parameter: none
  Return: void*/
  public void flipRight() {
    leftEar.move(FACE_DIAMETER, 0); /*moves left ear rightr*/
    rightEar.move(FACE_DIAMETER, 0);/*moves right ear right*/ 
    face.move(FACE_RADIUS + FACE_RADIUS, 0); /*flips the face across the 
    middle axis of the right ear*/
  }
  
  //Name: flipUpDown
  /*Purpose: To flip the silhouette down (when the mouse is pressed on the 
  ear for more than 500 miliseconds and released) using the middle of the ear 
  as the axis and flip the silhouette up after it is flipped down.
  Parameter: none
  Return: void*/
  public void flipUpDown() {
    if (!flippedDown) {//if the face had not been flipped upside-down before
      rightEar.move(0, FACE_DIAMETER); /*flips the right ear 
      down and left*/
      leftEar.move(0, FACE_DIAMETER); /*flips the left ear down 
      and right*/
      flippedDown = true;//face has been flipped
    }
    else if (flippedDown) { //if the face had been flipped upside-down 
      rightEar.move(0, -FACE_DIAMETER);/*makes the face right-
      side up*/
      leftEar.move(0, -FACE_DIAMETER);
      flippedDown= false;
    }
  }
}
