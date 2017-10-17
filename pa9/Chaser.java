/*Name: Vanessa Chou
 *Login: cs11fbv
 *Date: November 28, 2014
 *File: Chaser.java
 *Sources of Help: */
 
import objectdraw.*;
import java.awt.Color;

/*Name: Chaser
*Purpose:Includes all the methods and objects of the class*/
public class Chaser extends Critter{
  FilledOval chaser;
  private double critterLength=15.0;
  private double halfLength=7.5;
  private double smallest;
  private Location[] locations;
  private Location spot0, spot1, spot2, spot3, spot4, spot5, spot6, 
                   spot7;//8 locations chaser can move to
  private Location otherLoc;//location of other critter
  private Location smallLoc;
  private Location location;
  private int two=2;
  private int three= 3;
  private int four= 4;
  private int five= 5;
  private int six= 6;
  private int seven= 7;
  private int eighth= 8;

  /*Name: Chaser (ctor)
  *Purpose: Provides info for making the chaser
  *Parameter: Location, DrawingCanvas*/
  public Chaser(Location location, DrawingCanvas canvas){
    super(location, canvas);
    if (canvas.getWidth()>location.getX()+critterLength && 0 < 
        location.getX() && canvas.getHeight()> location.getY()+
        critterLength && 0 < location.getY()){//if within borders
      chaser= new FilledOval(location, critterLength, critterLength, 
                             canvas); //creating the chaser
      chaser.setColor(Color.magenta);
      this.location= location;
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
        smallest=otherLoc.distanceTo(locations[i]);
        smallLoc= locations[i];
      }
      if (i>0){
        if (otherLoc.distanceTo(locations[i])<smallest){
          smallest= otherLoc.distanceTo(locations[i]);
          smallLoc= locations[i];
        }
      }
    }    
    chaser.moveTo(smallLoc);//move to the location closest to other  
    this.setLoc(smallLoc);

  }
 
  /*Name: kill
  *Purpose: Removes from canvas
  *Parameter: None
  *Return: void*/
  public void kill(){
    chaser.removeFromCanvas();
  }
}

