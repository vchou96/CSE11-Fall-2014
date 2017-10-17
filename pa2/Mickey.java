/*
 * Name: Vanessa Chou
 * Login: cs11fbv
 * Date: October 11, 2014
 * File: Mickey.java
 * Sources of Help: Kristen Agcaoili 
 *
 * This program will draw a Mickey Mouse-shaped silhouette that responds to 
 * different mouse events.  
 */

import objectdraw.*;
import java.awt.*;

public class Mickey extends WindowController {
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
	private Text instructions1;//first line of instructions
	private Text instructions2;//second line of instructions
	private FilledOval face;//the face
	private FilledOval leftEar;//the left "ear"
	private FilledOval rightEar; //the right "ear"
	private boolean mouseClicked = false;/*true/false value if the mouse has been
  clicked; currently set to false*/
	private double oldX;
	private double oldY;
  private double distanceCenterX;
  private double distanceCenterY;
		                                                   
	public void begin() {//the start
		instructions1 = new Text ("Click to display a Mickey silhouette" + " " + 
    "centered at the mouse click.", INSTR1_X, INSTR1_Y, 
		canvas); //displays 1st line of instructions
		instructions2 = new Text("Mouse press in any part of the image" + " " + 
    "and drag to move image around.", INSTR2_X, INSTR2_Y, 
		canvas); //displays 2nd line of instructions
	}

	public void onMouseClick(Location point) {//when the mouse is clicked
		instructions1.hide();//hides 1st line when mouse is clicked
		instructions2.hide();//hides 2nd line when mouse is clicked
		if (mouseClicked == false) { //if mouse was not clicked before	
			face = new FilledOval(point.getX() - FACE_RADIUS, point.getY() - 
      FACE_RADIUS, FACE_DIAMETER, FACE_DIAMETER, canvas); //the face
			leftEar = new FilledOval(point.getX() - EAR_RADIUS - EAR_OFFSET, 
      point.getY() - EAR_RADIUS - EAR_OFFSET, EAR_DIAMETER, EAR_DIAMETER, 
      canvas); //the left ear
			rightEar = new FilledOval(point.getX() - EAR_RADIUS + EAR_OFFSET, 
      point.getY() - EAR_RADIUS - EAR_OFFSET, EAR_DIAMETER, EAR_DIAMETER, 
      canvas); //the left ear
			mouseClicked = true;//mouse is now considered "clicked"
		}
	}

	public void onMousePress(Location point) {//when the mouse is pressed
    if (mouseClicked == true) {
      if (face.contains(point) || leftEar.contains(point) || 
      rightEar.contains(point)) { 		 
        oldX = point.getX();
		    oldY = point.getY();
        distanceCenterX = oldX - face.getX() - FACE_RADIUS;/*distance from oldX 
        to x value of the center of face*/
        distanceCenterY = oldY - face.getY() - FACE_RADIUS;/*distance from oldY 
        to y value of the center of face*/      
	    }
    }
  }

	public void onMouseDrag(Location point) {//when the mouse is dragged
      if (face.contains(point) || leftEar.contains(point) || 
      rightEar.contains(point)) { 		
        double currentX = point.getX(); 
				double currentY = point.getY();
        face.moveTo(currentX - FACE_RADIUS - distanceCenterX, currentY - 
        FACE_RADIUS - distanceCenterY); //drag the face
				leftEar.moveTo(currentX - EAR_RADIUS - EAR_OFFSET - distanceCenterX, 
        currentY - EAR_RADIUS - EAR_OFFSET - distanceCenterY); //drag left ear
				rightEar.moveTo(currentX - EAR_RADIUS + EAR_OFFSET - distanceCenterX, 
        currentY - EAR_RADIUS - EAR_OFFSET - distanceCenterY); //drag right ear
	  }
  }
	
	public void onMouseExit(Location point) { //when mouse exits screen
      if (mouseClicked == true) {
        face.hide();
		    leftEar.hide();
		    rightEar.hide();
		    mouseClicked = false; /*mouse click set to false so Mickey will appear 
    again when the screen is clicked next time*/
      }
  }

	
	public void onMouseEnter(Location point) {//when mouse enters the screen
		instructions1.show();//1st line of instructions reappear
		instructions2.show();//2nd line of instructions reappear
	}	
}
