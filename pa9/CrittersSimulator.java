/* Name: Vanessa Chou
 *Login: cs11fbv
 *Date: November 28, 2014
 *File: CrittersController.java
 *Sources of Help: Kristin Agcaoili
 */

import objectdraw.*;
import java.util.ArrayList;
import java.awt.Color;

/*Name: CrittersSimulator 
 *Purpose:Includes all the methods and objects of the class*/
public class CrittersSimulator extends ActiveObject{
  private int DELAY= 75;
  private ArrayList<Critter> critters;    
  private ArrayList<Location> locations;
  private double smallest;
  private Location smallestLoc;
  private Critter closestCritter;
  private boolean firstTime = true;
  private boolean isRunning = true;
  private boolean chaserFirstTime= true;

  /*Name: CrittersSimulator (ctor)
  *Purpose: Contains reference to ArrayList 
  *Parameter: None*/
  public CrittersSimulator(ArrayList<Critter> critters){
    this.critters= critters;
    start();
  }

 /*Name: runChange
  *Purpose: Updates if the critters are running or not
  *Parameter: boolean
  *Return: void*/
  public void runChange(boolean running){
    if (isRunning!=running){
      isRunning= running;
    }
  }
  
 /*Name: Run
  *Purpose: Runs immediately
  *Parameter: None
  *Return: void*/
  public void run(){
    while (true){
      pause(DELAY);        
      if (isRunning){//if start button pressed or is running
        locations= new ArrayList<Location>();
        
        if (critters.size()>=2){        
          //finding locations of all critters & putting into array
          for (int i=0; critters.size() > i ; ++i){
            locations.add(critters.get(i).getLoc());
          }
          
          //calculating which critter is closest to another critter
          for (int i=0; critters.size()> i; ++i){//critter that will react       
            for (int j=0; locations.size()> j; ++j){//the closest critter
              if (locations.get(i).distanceTo(locations.get(j))!=0 && 
                  firstTime && critters.get(i).getClass()!=Chaser.class){
                  //finding the first time in the array that is not the critter
                  //itself
                firstTime=false;
                smallest = locations.get(i).distanceTo(locations.get(j));
                closestCritter= critters.get(j);
              }
              if (locations.get(i).distanceTo(locations.get(j))!=0 && 
                  critters.get(i).getClass()!=Chaser.class){              
                if (locations.get(i).distanceTo(locations.get(j)) < smallest){
                  smallest= locations.get(i).distanceTo(locations.get(j)); 
                  closestCritter= critters.get(j);                
                }
              }
              
              //if the critter is a Chaser (does not react to other chasers)
              if (critters.get(i).getClass()==Chaser.class){
                if (chaserFirstTime && 
                    locations.get(i).distanceTo(locations.get(j))!=0 && 
                    critters.get(j).getClass()!=Chaser.class){//first other 
                    //critter that is not a chaser 
                  chaserFirstTime=false;
                  smallest = locations.get(i).distanceTo(locations.get(j));
                  closestCritter= critters.get(j);
                }
                if (locations.get(i).distanceTo(locations.get(j))!=0 && 
                    critters.get(i).getClass()==Chaser.class && 
                    critters.get(j).getClass()!=Chaser.class){              
                  if (locations.get(i).distanceTo(locations.get(j)) < 
                      smallest){
                    smallest= locations.get(i).distanceTo(locations.get(j)); 
                    closestCritter= critters.get(j);                
                  }
                }
              }                                       
            }  
            //if the critter is a Runner
            if (critters.get(i).getClass()==Runner.class){             
              critters.get(i).reactTo(closestCritter);
              firstTime=true;
            }

            //if the critter is a Chaser
            if (!chaserFirstTime){
              if (critters.get(i).getClass()==Chaser.class && 
                  closestCritter.getClass()!= Chaser.class){
                critters.get(i).reactTo(closestCritter);
                firstTime=true;
                chaserFirstTime=true;
              }
            }

            //if the critter is a Random
            if (critters.get(i).getClass()==Random.class){
              critters.get(i).reactTo(closestCritter);
              firstTime=true;
            }
          }
        }
      }
    }
  }  
}
