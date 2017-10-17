/*Name: Vanessa Chou
*Login: cs11fbv
*Date: November 28, 2014
*File: Random.java
*Sources of Help: */

import objectdraw.*; 
import java.awt.Color;

/*Name: Random
*Purpose:Includes all the methods and objects of the class*/
public class Random extends Critter{
  Line random1;
  Line random2;
  private RandomIntGenerator randX;//randomly generates X coordinate
  private RandomIntGenerator randY;//randomly generates Y coordinate
  private RandomIntGenerator randBorderX;
  private RandomIntGenerator randBorderY;
  private double critterLength= 15.0;
  private double halfLength= 7.5;
  private int nextX;
  private int nextY;
  private int newX;
  private int newY;
  private int nextBorderX;//new X value if going out of borders
  private int nextBorderY;//new Y value if going out of borders
  private Location location;
  private Location updateLoc;
  private Location newLoc;
  private Location newBorderLoc;//new location after going out of borders


  /*Name: Random (ctor)
  *Purpose: Provides info for making randoms 
  *Parameter: Location, DrawingCanvas*/
  public Random(Location location, DrawingCanvas canvas){
    super(location, canvas);
    if (canvas.getWidth()>location.getX()+critterLength && 0 < 
        location.getX() && canvas.getHeight()>location.getY()+
        critterLength && 0 < location.getY()){//if within borders
      random1= new Line(location.getX(), location.getY()+ halfLength, 
                        location.getX()+ critterLength, location.getY()+
                        halfLength, canvas);
      random1.setColor(Color.orange);
      random2= new Line(location.getX()+ halfLength, location.getY(), 
                        location.getX()+ halfLength, location.getY()+
                        critterLength, canvas);
      random2.setColor(Color.orange);
      this.location=location;
    }
  }


  /*Name: reactTo
  *Purpose: Tells Random how to react when simulation is running
  *Parameter: None
  *Return: void*/
  public void reactTo(Critter other){
    //moving the Random
    randX = new RandomIntGenerator(-10,10);
    nextX= randX.nextValue();
    randY = new RandomIntGenerator(-10,10);
    nextY= randY.nextValue();
    random1.move(nextX, nextY);
    random2.move(nextX,nextY);
    
    //updating the location
    updateLoc=new Location(random1.getStart());
    newLoc= new Location(updateLoc.getX(), updateLoc.getY()-halfLength);
    this.setLoc(newLoc);

    //if it goes out of borders
    if (canvas.getWidth()< newLoc.getX()+critterLength || 0 > 
        newLoc.getX() || canvas.getHeight()<newLoc.getY()+
        critterLength || 0 > newLoc.getY()){//out of borders
      randBorderX= new RandomIntGenerator(0,canvas.getWidth()-
                                         (int)critterLength);
        nextBorderX= randBorderX.nextValue();
      randBorderY= new RandomIntGenerator(0,canvas.getHeight()-
                                         (int)critterLength);
        nextBorderY= randBorderY.nextValue();
      random1.moveTo(nextBorderX, nextBorderY+halfLength);
      random2.moveTo(nextBorderX+halfLength, nextBorderY);
      newBorderLoc=new Location((double)(nextBorderX),(double)(nextBorderY));
      this.setLoc(newBorderLoc);
    }
  }


  /*Name: kill
  *Purpose: Removes from canvas
  *Parameter: None
  *Return: void*/
  public void kill(){
    random1.removeFromCanvas();
    random2.removeFromCanvas();
  }
}

