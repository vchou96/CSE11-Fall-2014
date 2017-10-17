/*
 * Name: Vanessa Chou
 * Login: cs11fbv 
 * Date: October 8, 2014
 * File: CS11Turtle.java
 * Sources of Help: Connor Smith, Anish Kannan, Sherman Lee
 *
 * This program draws the words "CS11FBV FALL 2014" on 3 separate lines using 
 * turtles.
 * 
 */
import turtleClasses.*;
import java.awt.Color;

/*
 * Name: CS11Turtle
 * Purpose: Includes all the constants and the methods drawC, drawS, drawF, 
 * draw1, drawB, drawV, drawA, drawL, draw2, draw0, draw4, and drawTrident. 
 */
public class CS11Turtle extends Turtle {
	private final static int CHAR_WIDTH = 40; //width of a character
	private final static int CHAR_HEIGHT = 80; //height of a character
	private final static int HALF_HEIGHT = CHAR_HEIGHT/2; 
	//half of the height of a normal character
	private final static int QUARTER_HEIGHT = HALF_HEIGHT/2; 
	//quarter of the height of a normal character
	private final static int DOUBLE_HEIGHT = HALF_HEIGHT*2; 
	//double of the height of a normal character
	private final static int HALF_WIDTH = CHAR_WIDTH/2; 
	//half of the width of a normal character
	private final static int QUARTER_WIDTH = HALF_WIDTH/2; 
	//quarter of the width of a normal character
	private final static int LENGTHB1 = 30; 
	//length of the horizontal line in the letter 'B' 
	private final static int LENGTHB2 = 16; 
	//length of the diagonal in the letter 'B' 
	private final static int LENGTHB3 = 15; 
	//length of the small vertical lines in the letter 'B' 
	private final static int DEGREESB1 = 54; 
	//angle clockwise at which the diagonal in 'B' is drawn    
	private final static int DEGREESB2 = 36; 
	//angle clockwise at which the small vertical part in 'B' is drawn
	private final static int LENGTHV = 82; 
	//length of one leg of the letter 'V'
	private final static int DEGREESV1 = 166; 
	//angle clockwise at which the first leg of the letter 'V' is drawn
	private final static int DEGREESV2 = 208; 
	//angle clockwise at which the second leg of letter 'V' is drawn
	private final static int LENGTH_TRIDENT = 10; 
	//length of a side of the triangle that forms the trident's tips
	private final static int HALF_LENGTH_TRIDENT = LENGTH_TRIDENT/2;  
	//half of the length of a side of the triangle
	private final static int DEGREES_TRIDENT = 240;
	//degrees used to draw the triangles of the trident's tips
	private final static int PADDING_BETWEEN_CHARS = 40; 
	//space between any 2 characters
	private final static int PADDING_BETWEEN_LINES = 40; 
	//space between any 2 lines
	private final static int CHAR_SPACING = CHAR_WIDTH + 
	PADDING_BETWEEN_CHARS; 
	/*space used by a character and the blank space between any two 
	characters*/
	private final static int LINE_SPACING = CHAR_HEIGHT + 
	PADDING_BETWEEN_LINES;
	/*space used by a line of words and the blank space between any two 
	lines*/
	private final static int WORLD_WIDTH = 600; //width of the world
	private final static int WORLD_HEIGHT = 400; //height of the world
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
	private final static int START_TRIDENT1X = START_X_2/2 - HALF_WIDTH; 
	// setting the X of trident on the left 
	private final static int START_TRIDENT2X = WORLD_WIDTH-(START_X_2)/2 - 
		HALF_WIDTH; 
	// setting the X of trident on the right 
	private final static int START_TRIDENTY = WORLD_HEIGHT/2; 
	// setting the Y of the tridents 
	private final static int PEN_WIDTH = 10; //pen width for the words
	private final static int PEN_SMALLWIDTH = 4; /*pen width for the 
	tridents*/
	private final static Color RED_COLOR = Color.RED; //red color
	private final static Color MAGENTA_COLOR = Color.MAGENTA; /*magenta 
	color*/
	private final static Color GREEN_COLOR = Color.GREEN; //green color
	private final static Color BLUE_COLOR = Color.BLUE; //blue color

	/*
	 * Delay between turtle actions (turns, moves) in milliseconds.
	 * 1000 = 1 sec. so 10 = 0.01 sec.
	 */
	private final static int DELAY = 10;

	/*
	 * Name: CS11Turtle(World w, int delay) 
	 * Purpose: Briefly describe the purpose of this constructor
	 * Parameters: World w is the canvas, int delay represents the delay 
	 * between turtle actions. 
	 */
	public CS11Turtle(World w, int delay) {
		super(w, delay); /* Invoke superclass's ctor to create this 
		turtle*/
	} // on World w with delay of each turtle's action.

	/*
	 * Name: drawC
	 * Purpose: Draws the letter "C".
	 * Parameters: int x is the starting x value on the top left corner, 
	 * int y is the starting y value on the top left corner.
	 * Return: Void.
	 */
	private void drawC(int x, int y) {
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

	/*
	 * Name: drawS
	 * Purpose: Draws a "S".
	 * Parameters: int x is the starting x value on the top left corner, 
	 * int y is the starting y value on the top left corner.
	 * Return: Void.
	 */
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

	/*
	 * Name: draw1
	 * Purpose: Draws a "1".
	 * Parameters: int x is the starting x value on the top left corner, 
	 * int y is the starting y value on the top left corner.
	 * Return: Void. 
	 */
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

	/*
	 * Name: drawF
	 * Purpose: Draws the letter "F".
	 * Parameters: int x is the starting x value on the top left corner, 
	 * int y is the starting y value on the top left corner.
	 * Return: Void.
	 */
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

	/*
	 * Name: drawB
	 * Purpose: Draws the letter "B".
	 * Parameters: int x is the starting x value on the top left corner, 
	 * int y is the starting y value on the top left corner.
	 * Return: Void.
	 */
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

	/*
	 * Name: drawV
	 * Purpose: Draws the letter "V".
	 * Parameters: int x is the starting x value on the top left corner, 
	 * int y is the starting y value on the top left corner.
	 * Return: Void.
	 */
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

	/*
	 * Name: drawA
	 * Purpose: Draws the letter "A".
	 * Parameters: int x is the starting x value on the top left corner, 
	 * int y is the starting y value on the top left corner.
	 * Return: Void.
	 */
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

	/*
	 * Name: drawL
	 * Purpose: Draws the letter "L".
	 * Parameters: int x is the starting x value on the top left corner, 
	 * int y is the starting y value on the top left corner.
	 * Return: Void.
	 */
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

	/*
	 * Name: draw2
	 * Purpose: Draws a "2".
	 * Parameters: int x is the starting x value on the top left corner, 
	 * int y is the starting y value on the top left corner.
	 * Return: Void.
	 */
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

	/*
	 * Name: draw0
	 * Purpose: Draws a "0".
	 * Parameters: int x is the starting x value on the top left corner, 
	 * int y is the starting y value on the top left corner.
	 * Return: Void.
	 */
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

	/*
	 * Name: draw4
	 * Purpose: Draws a "4".
	 * Parameters: int x is the starting x value on the top left corner, 
	 * int y is the starting y value on the top left corner.
	 * Return: Void.
	 */
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

	/*
	 * Name: drawTrident
	 * Purpose: Draws a Trident.
	 * Parameters: int x is the starting x value on the top left corner, 
	 * int y is the starting y value on the top left corner.
	 * Return: Void.
	 */
	private void drawTrident(int x, int y) {
		penUp();
		moveTo(x, y); // start in upper left corner of this char block
		turnToFace(getXPos()+1, getYPos()); //face right
		penDown();
		forward(HALF_LENGTH_TRIDENT); /*starts drawing the left 
		triangle tip of the trident*/
		turn(DEGREES_TRIDENT);
		forward(LENGTH_TRIDENT);
		turn(DEGREES_TRIDENT);
		forward(LENGTH_TRIDENT);
		turn(DEGREES_TRIDENT);
		forward(HALF_LENGTH_TRIDENT); /*finished drawing the left 
		triangle tip*/
		turnRight(); //starts drawing the left arm of the trident
		forward(HALF_HEIGHT);
		turnLeft(); 
		forward(HALF_WIDTH); //finished drawing the left arm
		turnLeft(); //starts drawing the middle arm of the trident
		forward(HALF_HEIGHT); 
		turnRight(); 
		forward(HALF_LENGTH_TRIDENT); /*starts drawing the middle 
		triangle tip of the trident*/
		turn(DEGREES_TRIDENT);
		forward(LENGTH_TRIDENT);
		turn(DEGREES_TRIDENT);
		forward(LENGTH_TRIDENT);
		turn(DEGREES_TRIDENT);
		forward(HALF_LENGTH_TRIDENT); /*finished drawing the middle 
		triangle tip of the trident*/
		turnRight();
		forward(HALF_HEIGHT);
		turnLeft();
		forward(HALF_WIDTH); //finished drawing the middle arm
		turnLeft(); //starts drawing the right arm of the trident
		forward(HALF_HEIGHT);
		turnRight();
		forward(HALF_LENGTH_TRIDENT); /*starts drawing the right 
		triangle tip of the trident*/ 
		turn(DEGREES_TRIDENT);
		forward(LENGTH_TRIDENT);
		turn(DEGREES_TRIDENT);
		forward(LENGTH_TRIDENT);
		turn(DEGREES_TRIDENT);
		forward(HALF_LENGTH_TRIDENT); /*finished drawing the right
 		triangle tip*/
		turnRight();
		forward(HALF_HEIGHT);
		turnRight();
		forward(HALF_WIDTH); //finished drawing the right arm 
		turnLeft();
		forward(DOUBLE_HEIGHT); //draws the handle of the trident
	}

	public static void main(String [] args) {
		int startX1 = START_X_1, // starting x offset for line 1
		    startX2 = START_X_2, // starting x offset for line 2
		    startX3 = START_X_3; // starting x offset for line 3
		int startXTrident1 = START_TRIDENT1X; /*starts x offset for 
		left Trident*/
		int startXTrident2 = START_TRIDENT2X; /*starts x offset for 
		right Trident*/
		int startY = START_Y; // starting y offset
		int startYTrident = START_TRIDENTY; /*starts y offset for 
		Tridents*/
		int x, y;
		World w = new World(WORLD_WIDTH, WORLD_HEIGHT);
		CS11Turtle myTurtle = new CS11Turtle(w, DELAY);
		myTurtle.setPenWidth(PEN_WIDTH);
		myTurtle.setPenColor(RED_COLOR);
		myTurtle.drawC(x = startX1, y = startY); 
		myTurtle.drawS(x += CHAR_SPACING, y); 
		myTurtle.draw1(x += CHAR_SPACING, y); 
		myTurtle.draw1(x += CHAR_SPACING, y);  
		myTurtle.drawF(x += CHAR_SPACING, y); 
		myTurtle.drawB(x += CHAR_SPACING, y);
		myTurtle.drawV(x += CHAR_SPACING, y);
		myTurtle.setPenColor(MAGENTA_COLOR);
		myTurtle.drawF(x = startX2, y+=LINE_SPACING); 
		myTurtle.drawA(x += CHAR_SPACING, y);
		myTurtle.drawL(x += CHAR_SPACING, y);
		myTurtle.drawL(x += CHAR_SPACING, y);
		myTurtle.setPenColor(GREEN_COLOR);
		myTurtle.draw2(x = startX3, y+=LINE_SPACING);
		myTurtle.draw0(x += CHAR_SPACING, y);
		myTurtle.draw1(x += CHAR_SPACING, y);
		myTurtle.draw4(x += CHAR_SPACING, y);
		myTurtle.setPenWidth(PEN_SMALLWIDTH);
		myTurtle.setPenColor(BLUE_COLOR);
		myTurtle.drawTrident(x = startXTrident1, y = startYTrident);
		myTurtle.drawTrident(x = startXTrident2, y =startYTrident);
	}

} // End of public class CS11Turtle extends Turtle
