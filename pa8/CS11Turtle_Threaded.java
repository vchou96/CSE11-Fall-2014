/*
 * Name: Vanessa Chou
 * Login: cs11fbv 
 * Date: November 25, 2014
 * File: CS11Turtle_Threaded.java
 * Sources of Help: Kristen Agcaoili
 *
 * This program draws the words "CS11FBV FALL 2014" on 3 separate lines using 
 * turtles.
 * 
 */
import turtleClasses.*;
import java.awt.Color;

/*
 * Name: CS11Turtle_Threaded
 * Purpose: Includes all the constants and the methods drawC, drawS, drawF, 
 * draw1, drawB, drawV, drawA, drawL, draw2, draw0, draw4, and drawTrident. 
 */
public class CS11Turtle_Threaded extends Turtle implements Runnable {
	private final static int CHAR_WIDTH = 40; //character width
	private final static int CHAR_HEIGHT = 80; //character height
	private final static int HALF_HEIGHT = CHAR_HEIGHT/2; 
	private final static int QUARTER_HEIGHT = HALF_HEIGHT/2;
	private final static int DOUBLE_HEIGHT = HALF_HEIGHT*2; 
	private final static int HALF_WIDTH = CHAR_WIDTH/2; 
	private final static int QUARTER_WIDTH = HALF_WIDTH/2; 

  //ints used in letter B
	private final static int LENGTHB1 = 30; 
	private final static int LENGTHB2 = 16; 
	private final static int LENGTHB3 = 15; 
	private final static int DEGREESB1 = 54; 
	private final static int DEGREESB2 = 36; 
	
  //ints used in letter V
  private final static int LENGTHV = 82; //length of one leg of the letter 'V'
	private final static int DEGREESV1 = 166; 
	private final static int DEGREESV2 = 208; 
	
 	private final static int PADDING_BETWEEN_CHARS = 40;/*space between any 2 
                                                        characters*/
	private final static int PADDING_BETWEEN_LINES = 40;/*space between any 2
                                                        lines*/
	private final static int CHAR_SPACING = CHAR_WIDTH + 
                           PADDING_BETWEEN_CHARS; 
	private final static int LINE_SPACING = CHAR_HEIGHT + 
	                         PADDING_BETWEEN_LINES;
	private final static int WORLD_WIDTH = 600;
	private final static int WORLD_HEIGHT = 400; 
	private final static int START_X_1 = (WORLD_WIDTH - 
	(PADDING_BETWEEN_CHARS)*6 - (CHAR_WIDTH)*7)/2; /* starting x offset for
	                                                  line 1*/
	private final static int START_X_2 = (WORLD_WIDTH - 
	(PADDING_BETWEEN_CHARS)*3 - (CHAR_WIDTH)*4)/2; /* starting x offset for 
	                                                  line 2*/
	private final static int START_X_3 = (WORLD_WIDTH - 
	(PADDING_BETWEEN_CHARS)*3 - (CHAR_WIDTH)*4)/2; /* starting x offset for 
	                                                  line 3*/
	private final static int START_Y = (WORLD_HEIGHT - 
	(PADDING_BETWEEN_LINES)*2 - (CHAR_HEIGHT)*3)/2; // starting y offset 
	private final static int PEN_WIDTH = 10; 

	private final static Color BLUE_COLOR = Color.BLUE; 
  
  private int x, y;
  private char ch;
	
  
  private final static int DELAY = 500;//Delay in milliseconds. 1000 = 1 sec. 


	/*
	 * Name: CS11Turtle_Threaded(World w, int delay) 
	 * Purpose: Briefly describe the purpose of this constructor
	 * Parameters: World w is the canvas, int delay represents the delay 
	 * between turtle actions. 
	 */
	public CS11Turtle_Threaded(World w, char ch, int x, int y, int delay) {
		super(w, delay); /* Invoke superclass's ctor to create this 
		turtle*/
    this.ch=ch;
    this.x=x;
    this.y=y;
    setPenWidth(PEN_WIDTH);
    setPenColor(BLUE_COLOR);
    new Thread(this).start();//new thread
	} 

	/* Name: drawC
	 * Purpose: Draws the letter "C".
	 * Parameters: int x, int y 
	 * Return: Void.*/	private void drawC(int x, int y) {
		penUp();
		moveTo(x, y); // start in upper left corner of character block
		turnToFace(getXPos() + 1, getYPos()); // face right
		penDown();
		forward(CHAR_WIDTH);
		backward(CHAR_WIDTH);
		turnRight();
		forward(CHAR_HEIGHT);
		turnLeft();
		forward(CHAR_WIDTH);
	}

	/* Name: drawS
	 * Purpose: Draws a "S".
	 * Parameters: int x, int y 
   * Return: Void.*/
	private void drawS(int x, int y) {
		penUp();
		moveTo(x, y); /* start in upper left corner of this character 
		block*/
		turnToFace(getXPos() + 1, getYPos()); // face right
		penDown();
		forward(CHAR_WIDTH);
		backward(CHAR_WIDTH);
		turnRight();
		forward(HALF_HEIGHT);
		turnLeft();
		forward(CHAR_WIDTH);
		turnRight();
		forward(HALF_HEIGHT);
		turnRight();
		forward(CHAR_WIDTH);
	}

	/* Name: draw1
	 * Purpose: Draws a "1".
	 * Parameters: int x, int y 
   * Return: Void.*/
	private void draw1(int x, int y) {
		penUp();
		moveTo(x, y); /* start in upper left corner of this character 
		block*/
		turnToFace(getXPos() + 1, getYPos()); //face right
		forward(HALF_WIDTH); //without putting the pen down
		turnToFace(getXPos()-1, getYPos()+1); //face left and down
		penDown();
		forward(QUARTER_WIDTH);
		backward(QUARTER_WIDTH);
		turnToFace(getXPos(), getYPos()+1);
		forward(CHAR_HEIGHT);
		turnRight();
		forward(HALF_WIDTH);
		backward(CHAR_WIDTH);
	}

	/* Name: drawF
	 * Purpose: Draws the letter "F".
	 * Parameters: int x, int y
	 * Return: Void.*/
	private void drawF(int x, int y) {
		penUp();
		moveTo(x, y); /* start in upper left corner of this character 
		block*/
		turnToFace(getXPos() + 1, getYPos()); // face right
		penDown();
		forward(CHAR_WIDTH);
		backward(CHAR_WIDTH);
		turnRight();
		forward(HALF_HEIGHT);
		turnLeft();
		forward(CHAR_WIDTH);
		backward(CHAR_WIDTH);
		turnRight();
		forward(HALF_HEIGHT);
	}

	/* Name: drawB
	 * Purpose: Draws the letter "B".
	 * Parameters: int x, int y
	 * Return: Void.*/
	private void drawB(int x, int y) {
		penUp();
		moveTo(x, y); /* start in upper left corner of this character 
		block*/
		turnToFace(getXPos() + 1, getYPos()); // face right
		penDown();
		forward(LENGTHB1);
		turn(DEGREESB1);
		forward(LENGTHB2);
		turnToFace(getXPos(), getYPos()+1);
		forward(LENGTHB3);
		turn(DEGREESB2);
		forward(LENGTHB2);
		turnToFace(getXPos()-1, getYPos());
		forward(LENGTHB1);
		backward(LENGTHB1);
		turnToFace(getXPos()+1, getYPos());
		turn(DEGREESB1);
		forward(LENGTHB2);
		turnToFace(getXPos(), getYPos()+1);
		forward(LENGTHB3);
		turn(DEGREESB2);
		forward(LENGTHB2);
		turnToFace(getXPos()-1, getYPos());
		forward(LENGTHB1);
		turnToFace(getXPos(), getYPos() - 1);
		forward(CHAR_HEIGHT);
	}

	/* Name: drawV
	 * Purpose: Draws the letter "V".
	 * Parameters: int x, int y 	 
   * Return: Void.*/
	private void drawV(int x, int y) {
		penUp();
		moveTo(x, y); /* start in upper left corner of this character 
		block*/
		turn(DEGREESV1); // face right and down
		penDown();
		forward(LENGTHV); 
		turn(DEGREESV2); 
		forward(LENGTHV);
	}

	/* Name: drawA
	 * Purpose: Draws the letter "A".
	 * Parameters: int x, int y
   * Return: Void.*/
	private void drawA(int x, int y) {
		penUp();
		moveTo(x, y); /* start in upper left corner of this character 
		block*/
		turnToFace(getXPos() + 1, getYPos()); // face right
		penDown();
		forward(CHAR_WIDTH);
		turnRight();
		forward(CHAR_HEIGHT);
		backward(HALF_HEIGHT);
		turnRight();
		forward(CHAR_WIDTH);
		turnLeft();
		forward(HALF_HEIGHT);
		backward(CHAR_HEIGHT);
	}

	/* Name: drawL
	 * Purpose: Draws the letter "L".
	 * Parameters: int x, int y
   * Return: Void.*/
	private void drawL(int x, int y) {
		penUp();
		moveTo(x, y); /*start in upper left corner of this character 
		block*/
		turnToFace(getXPos(), getYPos()+1); // face down
		penDown();
		forward(CHAR_HEIGHT); 
		turnLeft(); 
		forward(CHAR_WIDTH);
	}

	/* Name: draw2
	 * Purpose: Draws a "2".
	 * Parameters: int x is the starting x value on the top left corner, 
	 * int y is the starting y value on the top left corner.
	 * Return: Void.*/
	private void draw2(int x, int y) {
		penUp();
		moveTo(x, y); /* start in upper left corner of this character 
		block*/
		turnToFace(getXPos()+1, getYPos()); // face right
		penDown();
		forward(CHAR_WIDTH); 
		turnRight(); 
		forward(HALF_HEIGHT);
		turnRight();
		forward(CHAR_WIDTH);
		turnLeft();
		forward(HALF_HEIGHT);
		turnLeft();
		forward(CHAR_WIDTH);
	}

	/* Name: draw0
	 * Purpose: Draws a "0".
	 * Parameters: int x, int y 
	 * Return: Void.*/
	private void draw0(int x, int y) {
		penUp();
		moveTo(x, y); /*start in upper left corner of this character 
		                block*/
		turnToFace(getXPos()+1, getYPos()); // face right
		penDown();
		forward(CHAR_WIDTH); 
		turnRight(); 
		forward(CHAR_HEIGHT);
		turnRight();
		forward(CHAR_WIDTH);
		turnRight();
		forward(CHAR_HEIGHT);
	}

	/* Name: draw4
	 * Purpose: Draws a "4".
	 * Parameters: int x, int y
   * Return: Void.*/
	private void draw4(int x, int y) {
		penUp();
		moveTo(x, y); /* start in upper left corner of this character 
		                 block*/
		turnToFace(getXPos(), getYPos()+1); // face down
		penDown();
		forward(HALF_HEIGHT); 
		turnLeft(); 
		forward(CHAR_WIDTH);
		turnLeft();
		forward(HALF_HEIGHT);
		backward(CHAR_HEIGHT);
	}

	/* Name: main
	 * Purpose: 
	 * Parameters:  
	 * Return: Void.*/
	public static void main(String [] args) {
		int startX1 = START_X_1, // starting x offset for line 1
		    startX2 = START_X_2, // starting x offset for line 2
		    startX3 = START_X_3; // starting x offset for line 3
		int startY = START_Y; // starting y offset
		int x, y;


		World w = new World(WORLD_WIDTH, WORLD_HEIGHT);
		new CS11Turtle_Threaded(w, 'C', x = startX1, y = startY, DELAY);    
    new CS11Turtle_Threaded(w, 'S', x += CHAR_SPACING, y, DELAY);
    new CS11Turtle_Threaded(w, '1', x += CHAR_SPACING, y, DELAY);
    new CS11Turtle_Threaded(w, '1', x += CHAR_SPACING, y, DELAY);
    new CS11Turtle_Threaded(w, 'F', x += CHAR_SPACING, y, DELAY);
    new CS11Turtle_Threaded(w, 'B', x += CHAR_SPACING, y, DELAY);
    new CS11Turtle_Threaded(w, 'V', x += CHAR_SPACING, y, DELAY);
    new CS11Turtle_Threaded(w, 'F', x = startX2, y+=LINE_SPACING, DELAY);
    new CS11Turtle_Threaded(w, 'A', x += CHAR_SPACING, y, DELAY);
    new CS11Turtle_Threaded(w, 'L', x += CHAR_SPACING, y, DELAY);
    new CS11Turtle_Threaded(w, 'L', x += CHAR_SPACING, y, DELAY);
    new CS11Turtle_Threaded(w, '2', x = startX3, y+=LINE_SPACING, DELAY);
    new CS11Turtle_Threaded(w, '0', x += CHAR_SPACING, y, DELAY);
    new CS11Turtle_Threaded(w, '1', x += CHAR_SPACING, y, DELAY);
    new CS11Turtle_Threaded(w, '4', x += CHAR_SPACING, y, DELAY);
		
	}

	/* Name: run
	 * Purpose: Runs after the program starts
	 * Parameters: None
	 * Return: Void.*/
  public void run(){
    switch(ch) {
      case 'C': this.drawC(x,y);
      break;
      case 'S': this.drawS(x,y);
      break;
      case '1': this.draw1(x,y);
      break;
      case 'F': this.drawF(x,y);
      break;
      case 'B': this.drawB(x,y);
      break;
      case 'V': this.drawV(x,y);
      break;
      case 'A': this.drawA(x,y);
      break;
      case 'L': this.drawL(x,y);
      break;
      case '2': this.draw2(x,y);
      break;
      case '0': this.draw0(x,y);
      break;
      case '4': this.draw4(x,y);
      break;
    }
  }


} 
