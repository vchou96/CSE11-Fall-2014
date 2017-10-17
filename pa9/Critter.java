/* Name: Vanessa Chou
 * Login: cs11fbv
 * Date: November 28, 2014
 * File: Critter.java
 * Sources of Help:*/

import objectdraw.*;

/*Name: Critter
 *Purpose: Includes all the methods and objects of the Critter class*/
public abstract class Critter{
  private double critterLength= 15.0;
  private double halfLength= 7.5;
  protected Location loc;
  protected DrawingCanvas canvas;
 
  /*Name: Critter (ctor)
  *Purpose:
  *Parameter: None*/
  public Critter (Location loc, DrawingCanvas canvas){
    this.loc=loc;
    this.canvas=canvas;
  }

  /*Name: reactTo
  *Purpose:Codes for how each critter reacts to other critters
  *Parameter: Critter
  *Return: void*/
  public abstract void reactTo(Critter other);

  /*Name: kill
  *Purpose:Removes critter from canvas
  *Parameter: None
  Return: void*/
  public abstract void kill();

  /*Name: getLoc
  *Purpose:gets the Location of the Critter
  *Parameter: None
  *Return: Location*/
  public Location getLoc(){
    return loc;
  }
 
  /*Name: setLoc
  *Purpose:sets the Location
  *Parameter: Location loc
  *Return: void*/
  public void setLoc(Location loc){
    this.loc=loc;
  }
}
