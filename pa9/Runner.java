/*Name: Vanessa Chou
 *Login: cs11fbv
 *Date: November 28, 2014
 *File: Runner.java
 *Sources of Help: */

import objectdraw.*; 
import java.awt.Color;

/*Name: Runner
*Purpose:Includes all the methods and objects of the class*/
public class Runner extends Critter{
  FilledRect runner;
  private RandomIntGenerator randBorderX;
  private RandomIntGenerator randBorderY;
  private double critterLength=15.0;
  private double halfLength=7.5;
  private double largest;
  private Location[] locations;
  private Location spot0, spot1, spot2, spot3, spot4, spot5, spot6, 
                   spot7;//8 locations runner can move to
  private Location otherLoc;//location of other critter
  private Location bigLoc;//farthest location from critter
  private Location location;
  private int two=2;
  private int three= 3;
  private int four= 4;
  private int five= 5;
  private int six= 6;
  private int seven= 7;
  private int eighth= 8;
  private int nextBorderX;//new X value if going out of borders
  private int nextBorderY;//new Y value if going out of borders
  private Location updateLoc;//updated Location
  private Location newBorderLoc;//new location after going out of borders


  /*Name: Runner (ctor)
  *Purpose: Provides info for making the runner
  *Parameter: Location, DrawingCanvas*/
  public Runner(Location location, DrawingCanvas canvas){
    super(location, canvas);
    if (canvas.getWidth()>location.getX()+critterLength && 0 < 
        location.getX() && canvas.getHeight()>location.getY()+
        critterLength && 0 < location.getY()){//if within borders   
      runner= new FilledRect(location, critterLength, critterLength, 
                             canvas); //creating the runner
      runner.setColor(Color.cyan);
      this.location=location;
    }
  }


  /*Name: reactTo
  *Purpose: 
  *Parameter: Critter
  *Return: void*/    
  public void reactTo(Critter other){
    if (other == null){
      return;
    }
    locations= new Location[eighth];
    spot0=new Location(loc.getX()+1,loc.getY()-1);
    spot1=new Location(loc.getX()+1,loc.getY());
    spot2=new Location(loc.getX()+1,loc.getY()+1);
    spot3=new Location(loc.getX(),loc.getY()-1);
    spot4=new Location(loc.getX(),loc.getY()+1);
    spot5=new Location(loc.getX()-1,loc.getY()-1);
    spot6=new Location(loc.getX()-1,loc.getY());
    spot7=new Location(loc.getX()-1,loc.getY()+1);
 
    locations[0]= spot0;
    locations[1]= spot1;
    locations[two]= spot2;
    locations[three]= spot3;
    locations[four]= spot4;
    locations[five]= spot5;
    locations[six]= spot6;
    locations[seven]= spot7;
    otherLoc = other.getLoc();

    //comparing the distances between other and the 8 locations
    for (int i=0; locations.length> i; ++i){
      if (i==0){
        largest=otherLoc.distanceTo(locations[i]);
        bigLoc=locations[i];
      }
      if (i>0){
        if (otherLoc.distanceTo(locations[i])>largest){
          largest= otherLoc.distanceTo(locations[i]);
          bigLoc= locations[i];/*getting the largest distance between runner
                                and other*/
        }
      }
    }
    this.setLoc(bigLoc);
    runner.moveTo(bigLoc);//move to the location farthest to other  
    updateLoc=new Location(this.getLoc());
    
    //if it goes out of borders
    if (canvas.getWidth()< updateLoc.getX()+critterLength || 0 > 
        updateLoc.getX() || canvas.getHeight()<updateLoc.getY()+
        critterLength || 0 > updateLoc.getY()){//out of borders
      randBorderX= new RandomIntGenerator(0,canvas.getWidth()-
                                          (int)critterLength);
        nextBorderX= randBorderX.nextValue();//random new X
      randBorderY= new RandomIntGenerator(0,canvas.getHeight()-
                                          (int)critterLength);
        nextBorderY= randBorderY.nextValue();//random new Y
      runner.moveTo(nextBorderX, nextBorderY);
      
      newBorderLoc=new Location((double)(nextBorderX),(double)(nextBorderY));
      this.setLoc(newBorderLoc);//update the location
    }
  }

   

   /*Name: kill
    *Purpose: Removes from canvas
    *Parameter: None
    *Return: void*/
    public void kill(){
      runner.removeFromCanvas();
    }
}

