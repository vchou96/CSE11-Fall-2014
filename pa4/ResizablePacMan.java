/*
 * Name: Vanessa Chou
 * Login: cs11fbv
 * Date: October 24, 2014
 * File: ResizablePacMan.java
 * Sources of Help: Nick Crow, Connor Smith
 *
 * This program will provide information for rotating Pacman shapes that can
 * be resized. ResizablePacMan will use this information when it opens the 
 * applet and presents the PacMen on the canvas.    
 * 
 */
 
import java.awt.Color;
import objectdraw.*;

//Name: ResizablePacMan
//Purpose: To include all the PacMan information necessary and the run method 
//to create PacMen when ResizablePacManController is run. 
public class ResizablePacMan extends ActiveObject {
  private static final double PAUSE_TIME = 33;
  private static final double GROWTH = 2;
  private static final double ARC_ANGLE = 300;
  private static final double MAX_DEGREES = 360;
  private final int CHANGE_ANGLE = 7;
  private int newStartAngle = 0;
  private static final double START_SIZE = 40, RADIUS= START_SIZE/2, 
  START_ANGLE = 0;   
  private FilledArc pacMan;
  private double SIZE= 40, TWICE_SIZE= SIZE*2, HALF_SIZE= SIZE/2, 
  WIDTH= 40, HEIGHT = 40, HALF_GROWTH = GROWTH/2; 
  private Location center;
  private Line vLine, hLine;
  private boolean growingPacMan = true;
  
//Name: ResizablePacMan (constructor)
//Purpose: Codes for the actual PacMen. 
//Parameter: Location, size, canvas, line, line 
  public ResizablePacMan (Location center, double size, DrawingCanvas canvas,
  Line hLine, Line vLine) {
    pacMan = new FilledArc(center.getX() - RADIUS, center.getY() - RADIUS, 
    WIDTH, HEIGHT, START_ANGLE, ARC_ANGLE, canvas);
    this.vLine= vLine;
    this.hLine= hLine;
    this.center = center;
    start();
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
            
      //Rotates the PacMen counterclockwise
      newStartAngle = (newStartAngle + CHANGE_ANGLE) % (int)MAX_DEGREES;
      pacMan.setStartAngle(newStartAngle); 

      if (center.getX() >= vLine.getStart().getX() && center.getY() <= 
      hLine.getStart().getY()) {//if it is in the 1st quadrant
        pacMan.setColor(Color.cyan);
      }
      if (center.getX() <= vLine.getStart().getX() && center.getY() <=
      hLine.getStart().getY()) {//if it is in the 2nd quadrant
        pacMan.setColor(Color.magenta);
      }
      if (center.getX() <= vLine.getStart().getX() && center.getY() >=
      hLine.getStart().getY()) {//if it is in the 3rd quadrant
        pacMan.setColor(Color.yellow);
      }
      if (center.getX() >= vLine.getStart().getX() && center.getY() >=
      hLine.getStart().getY()) {//if it is in the 4th quadrant
        pacMan.setColor(Color.black);
      }
      pause(PAUSE_TIME);//pauses after each iteration
    }
  }
}

