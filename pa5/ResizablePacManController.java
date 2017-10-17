/*
 * Name: Vanessa Chou
 * Login: cs11fbv
 * Date: November 6, 2014
 * File: ResizablePacManController.java
 * Sources of Help: Khoi Phan, Sherman Lee, Connor Smith
 * 
 * This program will create the applet/canvas and implement the information 
 * provided by ResizablePacMan to create the PacMen. It creates all the 
 * panels/buttons and connects the buttons to methods. The vertical 
 * and horizontal lines (that can be dragged and will proportionally 
 * adjust) are retained from the previous program.   
 * 
 */

import objectdraw.*;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


/*Name: ResizablePacManController
Purpose: Includes all the methods and variables necessary to run the program.
Implements MouseListener, MouseMotionListener, ActionListener, and 
ChangeListener to connect buttons to actions.*/
public class ResizablePacManController extends WindowController implements 
MouseListener, MouseMotionListener, ActionListener, ChangeListener {

  private Line vLine, hLine;
  
  private double xValofhLine, yValofhLine, xValofvLine, yValofvLine, 
  widthProportionv, heightProportionv, widthProportionh, heightProportionh, 
  TOP_MARGIN = 5, LEFT_MARGIN = 5, RIGHT_MARGIN, BOTTOM_MARGIN, START_SIZE = 
  40, HALF_SIZE= START_SIZE/2, xValue, yValue; 
  
  private boolean vLineGrab, hLineGrab, pacManCreated= false, clockwise = 
  true, stopped = false, pacManGrab = false; /*if vertical line is grabbed; 
  if horizontal line is grabbed; if a pacMan was created; if it is spinning 
  clockwise; if the run method is stopped; if the pacman is grabbed*/
  
  private int MIN_SPEED = 1, MAX_SPEED= 100, CURRENT_SPEED=50, speedCount= 50;
  /*minimum speed; maximum speed; starting speed when applet opens*/ 

  private ResizablePacMan pacMan;
  private JPanel topPanel, labelPanel, buttonPanel, bottomPanel;
  private JButton startButton, stopButton, clearAllButton, switchSpin;
  private JSlider speedSlider;//the slider for speed
  private Container contentPane;
  private JLabel topLabel, speedLabel;
  private Location point, center;

  
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
 
   
    /*making the top panel with 3 buttons for starting/stopping 
    rotation and clearing the canvas*/
    topPanel = new JPanel();//creates the panel with label + buttons
    labelPanel= new JPanel();
    buttonPanel= new JPanel();

    topLabel = new JLabel ("Resizable PacMen Controls");
    startButton = new JButton("Start");
    stopButton = new JButton("Stop");
    clearAllButton = new JButton("Clear All");
    switchSpin= new JButton("Switch Spin");

    labelPanel.add(topLabel);
    buttonPanel.add(startButton);
    buttonPanel.add(stopButton);
    buttonPanel.add(clearAllButton);
    buttonPanel.add(switchSpin);
    contentPane = getContentPane();
    contentPane.add(topPanel, BorderLayout.NORTH);
    topPanel.setLayout(new BorderLayout());
    topPanel.add(labelPanel, BorderLayout.NORTH);
    topPanel.add(buttonPanel, BorderLayout.SOUTH);

    /*making the bottom panel with a slider to set rotation speed*/
    bottomPanel = new JPanel();
    speedSlider = new JSlider(JSlider.HORIZONTAL, MIN_SPEED, 
    MAX_SPEED, CURRENT_SPEED);
    speedLabel = new JLabel("The speed is 50");
    bottomPanel.add(speedLabel);
    bottomPanel.add(speedSlider);    
    contentPane.add(bottomPanel, BorderLayout.SOUTH);
    contentPane.validate();

    startButton.addActionListener(this); 
    stopButton.addActionListener(this); 
    clearAllButton.addActionListener(this);
    switchSpin.addActionListener(this);
    speedSlider.addChangeListener(this);
    canvas.addMouseListener(this);
    canvas.addMouseMotionListener(this);
  }
  

  //MouseListener
  /*Name: mouseClicked
  Purpose: Runs when mouse is clicked (press and release without movement).
  Parameter: MouseEvent evt
  Return: void*/
  public void mouseClicked(MouseEvent evt) {
    center = new Location (evt.getX()-HALF_SIZE, evt.getY()-HALF_SIZE);
    pacMan = new ResizablePacMan(center, START_SIZE, canvas, 
    hLine, vLine, speedCount, stopped, clockwise); /*create a new 
    ResizeablePacMan*/
    
    pacManCreated = true; //a PacMan is created
    
    startButton.addActionListener(pacMan); 
    stopButton.addActionListener(pacMan); 
    clearAllButton.addActionListener(pacMan);
    switchSpin.addActionListener(pacMan);
    speedSlider.addChangeListener(pacMan);
    canvas.addMouseListener(pacMan);
    canvas.addMouseMotionListener(pacMan);
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
  }

  /*Name: mouseReleased
  Purpose: Runs when mouse is released after being pressed.
  Parameter: MouseEvent evt
  Return: void*/
  public void mouseReleased(MouseEvent evt) {
    vLineGrab= false;//vLine is not being grabbed
    hLineGrab= false;//hLine is not being grabbed
    pacManGrab = false;
  }
 

  //MouseMotionListener
  /*Name: mousePressed  
  Purpose: Runs when mouse is pressed.
  Parameter: MouseEvent evt
  Return: void*/
  public void mousePressed(MouseEvent evt) {
    
    xValue= (double) evt.getX();
    yValue= (double) evt.getY();
    point = new Location(xValue, yValue);
    
    if (vLine.contains(point)) {//if the mouse was pressed on vLine 
      vLineGrab = true;//vLine is grabbed
    }
    if (hLine.contains(point)) {//if the mouse was pressed on hLine
      hLineGrab = true;//hLine is grabbed
    }
  }


  /*Name: mouseDragged
  Purpose: Runs when the mouse is being dragged (press and moved).
  Parameter: MouseEvent evt
  Return: void*/
  public void mouseDragged(MouseEvent evt) {
    RIGHT_MARGIN= getWidth() - 5;
    BOTTOM_MARGIN= getHeight() - 5;

    //dragging the vertical line
    if (vLineGrab && LEFT_MARGIN<=evt.getX() && evt.getX() <= RIGHT_MARGIN) { 
      
      vLine.setEndPoints(evt.getX(),0, evt.getX(), canvas.getHeight());
      //moves vLine when dragged
      xValofvLine= evt.getX();/*updates x value of vline as the x value of
      the point where the mouse dragged to*/
      widthProportionv= xValofvLine/canvas.getWidth();/*updates widthProportion
      of vline*/
    }

    //dragging the horizontal line
    if (hLineGrab && TOP_MARGIN <= evt.getY() && evt.getY() <= BOTTOM_MARGIN) {
      
      hLine.setEndPoints(0, evt.getY(), canvas.getWidth(), evt.getY());
      //moves hLine when dragged
      yValofhLine= evt.getY();/*updates y value of hline as the y value of the 
      point where the mouse dragged to*/
      heightProportionh= yValofhLine/canvas.getHeight();/*updates 
      heightProportion of hline*/
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


  //ActionListener
  /*Name: actionPerformed
  Purpose: Runs when an action is performed
  Parameter: ActionEvent evt
  Return: void*/
  public void actionPerformed(ActionEvent evt) {
    if (evt.getActionCommand().equals("Start")) {//if Start button is pressed
      stopped = false;
    }
    if (evt.getActionCommand().equals("Stop")) {
      stopped = true;
    }
    if (evt.getActionCommand().equals("Clear All")) {
      pacManCreated = false;
    }
    if (evt.getActionCommand().equals("Switch Spin")) {
      if (clockwise) {//if it was spinning clockwise
        clockwise = false;//set to spinning counterclockwise
      }
      else {
        clockwise = true;//set to spinning clockwise 
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
    speedCount = speedSlider.getValue();
    speedLabel.setText("The speed is " + speedCount);  
  }
}

