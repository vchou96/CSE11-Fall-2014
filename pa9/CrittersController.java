/*
 *Name: Vanessa Chou
 *Login: cs11fbv
 *Date: November 28, 2014
 *File: CrittersController.java
 *Sources of Help:  
 */ 
 
import objectdraw.*;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


/*Name: CrittersController
 *Purpose: Includes the buttons and labels*/
public class CrittersController extends WindowController 
                                implements ActionListener {
  private ArrayList<Critter> critters;
  private CrittersSimulator simulation;
  private boolean chaserClick= false, runnerClick=false, randomClick=false;
                //false if button is not clicked, true if button is clicked
  private JPanel topPanel, bottomPanel, buttonPanel, leftPanel, rightPanel;
  private JButton startButton, stopButton, clearButton, chaserButton, 
                  runnerButton, randomButton;
  private JLabel topLabel, bottomLabel;
  private Chaser myChaser;
  private Runner myRunner;
  private Random myRandom;
  private Location loc;
  private double halfLength= 7.5;
  private double critterLength= 15.0;
  private boolean running=true;//if simulation is running
  private boolean firstTime=true;//first time simulation runs
  private boolean clearClick= false;//if clear button is clicked


  /*Name: begin
  Purpose: Runs when the program starts. 
  Parameter: None.
  Return: void */
  public void begin() {
    topPanel = new JPanel();
    bottomPanel=new JPanel();
    buttonPanel=new JPanel();
    leftPanel=new JPanel();
    rightPanel=new JPanel();   

    topLabel = new JLabel ("Please add two or more critters.");
    bottomLabel= new JLabel ("Select which critter to place:", JLabel.CENTER);
     
    startButton = new JButton("Start");
    stopButton = new JButton("Stop");
    clearButton = new JButton("Clear");
    chaserButton= new JButton("Chaser");
    runnerButton= new JButton("Runner");
    randomButton= new JButton("Random");
    
    topPanel.setLayout(new GridLayout());
    leftPanel.add(topLabel);
    topPanel.add(leftPanel);
    rightPanel.setLayout(new GridLayout());
    rightPanel.add(startButton);
    rightPanel.add(stopButton);
    rightPanel.add(clearButton);
    topPanel.add(rightPanel);
       
    bottomPanel.setLayout(new BorderLayout());
    bottomPanel.add(bottomLabel, BorderLayout.NORTH);
    buttonPanel.setLayout(new GridLayout());  
    buttonPanel.add(chaserButton);
    buttonPanel.add(runnerButton);
    buttonPanel.add(randomButton);
    bottomPanel.add(buttonPanel, BorderLayout.SOUTH);
    this.add(topPanel, BorderLayout.NORTH);
    this.add(bottomPanel, BorderLayout.SOUTH);
      
    startButton.addActionListener(this);
    stopButton.addActionListener(this);
    clearButton.addActionListener(this);
    chaserButton.addActionListener(this);
    runnerButton.addActionListener(this);
    randomButton.addActionListener(this);
    topPanel.validate();
    bottomPanel.validate();
    this.validate();
    critters= new ArrayList<Critter>();
    simulation = new CrittersSimulator(critters); 
  }


  /*Name: onMouseClick
  *Purpose: Runs when the mouse is clicked
  *Parameter: Location loc
  *Return: void*/
  public void onMouseClick(Location loc){
    loc.translate(-halfLength, -halfLength);
    if (canvas.getWidth()>loc.getX()+critterLength && 0 < 
      loc.getX() && canvas.getHeight()>loc.getY()+
      critterLength && 0 < loc.getY()){//if within borders
      if (chaserClick){//if chaser button clicked
        myChaser= new Chaser(loc, canvas);
        critters.add(myChaser);
      }
      if (runnerClick){//if runner button clicked
        myRunner= new Runner(loc, canvas);
        critters.add(myRunner);
      }
      if (randomClick){//if random button clicked
        myRandom= new Random(loc, canvas);
        critters.add(myRandom);
      }
      if (critters.size() >= 2 && firstTime && running){ //2 or more Critters
        topLabel.setText("Simulation is running.");
        firstTime=false;
      }
      if (clearClick && critters.size()>=2 && running){
        topLabel.setText("Simulation is running.");        
        clearClick=false;
      }
    }  
  }


  /*Name: actionPerformed
  *Purpose: Runs when an action is performed
  *parameter: ActionEvent evt
  *Return: void*/
  public void actionPerformed(ActionEvent evt){
    //Start Button
    if (((JButton)(evt.getSource())).getText().equals("Start")){
      running=true;
      simulation.runChange(running);
      if (critters.size() < 2){//less than 2 Critters
        topLabel.setText("Please add two more critters.");
      }
      if (critters.size() >= 2){ //2 or more Critters
        topLabel.setText("Simulation is running.");
      }
    }

    //Stop Button
    if (((JButton)(evt.getSource())).getText().equals("Stop")){
      topLabel.setText("Simulation is stopped.");
      running=false;
      simulation.runChange(running);
    }

    //Clear Button
    if (((JButton)(evt.getSource())).getText().equals("Clear")){
      for (int i = 0; critters.size() > i; ++i){
        critters.get(i).kill();//kills each critter in the ArrayList 
      }
      critters.clear();//clears the ArrayList
      if (running){
        topLabel.setText("Please add two more critters.");
      }
      clearClick= true;
    }  

    //Chaser Button
    if (((JButton)(evt.getSource())).getText().equals("Chaser")){
      chaserClick= true;
      runnerClick= false;
      randomClick= false;
      bottomLabel.setText("Click on canvas to place a Chaser");
    }

    //Runner Button
    if (((JButton)(evt.getSource())).getText().equals("Runner")){
      runnerClick= true;
      chaserClick= false;
      randomClick= false;
      bottomLabel.setText("Click on canvas to place a Runner");
    }

    //Random Button
    if (((JButton)(evt.getSource())).getText().equals("Random")){
      randomClick= true;
      chaserClick= false;
      runnerClick= false;
      bottomLabel.setText("Click on canvas to place a Random");
    }
  }

}





