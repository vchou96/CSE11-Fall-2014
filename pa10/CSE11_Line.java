/* Name: Vanessa Cpou
 * Login: cs11fbv 
 * Date: December 5, 2014
 * File: CSE11_Line.java
 * Sources of Help: */

import java.awt.*;
import objectdraw.*;

/* Name: CSE11_Line
* Purpose: Contains the methods for drawing lines*/ 
public class CSE11_Line extends Shape{
  Line myLine1;
  private Point start;
  private Point end;
  
  /* Name: CSE11_Line (ctor)
  * Purpose: Sets the name of the shape as CSE11_Line, makes new start/end 
  *          points
  * Parameter: None*/
  public CSE11_Line() {
    super("CSE11_Line: ");
    this.setStart(new Point());
    this.setEnd(new Point());
  }
  
  /* Name: CSE11_Line (ctor)
  * Purpose: Takes the arguments and sets them to start/end and sends name 
  *          to Shape class
  * Parameter: Point start, Point end*/
  public CSE11_Line( Point start, Point end ) { 
    super("CS11_Line: ");
    this.setStart(start);
    this.setEnd(end);
  }
  
  /* Name: CSE11_Line
  * Purpose: Functions as copy ctor
  * Parameter: None*/
  public CSE11_Line( CSE11_Line line ) {
    super("CS11_Line: ");
    this.setStart( new Point( line.getStart() ) );
    this.setEnd( new Point( line.getEnd() ) );
  }
  
  /* Name: move
  * Purpose: Moves the CSE_Line
  * Parameter: int xDelta, intyDelta
  * Return: void*/
  public void move( int xDelta, int yDelta ) { 
    setStart(new Point (getStart().getX()+xDelta, getStart().getY()+yDelta));
    setEnd(new Point (getEnd().getX()+xDelta, getEnd().getY()+yDelta));
  }
  
  /* Name: toString
  * Purpose: Puts Triangle's information (coordinates,name,shape) in a string
  * Parameter: None
  * Return: String*/
  @Override
  public String toString() {
    return super.getName() + getStart().toString() + " to " + 
           getEnd().toString();
  }
  
  /* Name: equals
  * Purpose: Checks whether two objects equal one another
  * Parameter: Object o
  * Return: boolean*/
  @Override
  public boolean equals( Object o ) { 
    if (o!=null && this.getClass() == (o.getClass()) && 
        getStart().equals(((CSE11_Line)o).getStart()) && 
        getEnd().equals(((CSE11_Line)o).getEnd())){     
      return true;
    }
    return false;//if not equal 
  }
  
  /* Name: hashCode
  * Purpose: Computes the hashcode 
  * Parameter: None
  * Return: int*/
  @Override
  public int hashCode() {
    return this.toString().hashCode();
  }

  /* Name: draw
  * Purpose: draws the CSE11_Line
  * Parameter: DrawingCanvas canvas, Color c, boolean fill 
  * Return: void*/
  public void draw( DrawingCanvas canvas, Color c, boolean fill ) { 
    myLine1= new Line(getStart().getX(), getStart().getY(),getEnd().getX(), 
                      getEnd().getY(),canvas);    
      //setting the color
      if (c==null){
        myLine1.setColor(Color.black);
        }
      else{
        myLine1.setColor(c);
      }     
  }

  /* Name: getStart
  * Purpose: Accessor for start
  * Parameter: None 
  * Return: start*/
  public Point getStart(){
    return this.start;
  }

  /* Name: setStart
  * Purpose: Mutator for start 
  * Parameter: Point p
  * Return: void*/
  private void setStart( Point p ){
    this.start=p;
  }

  /* Name: getEnd
  * Purpose: Accessor for end
  * Parameter: None 
  * Return: start*/
  public Point getEnd(){
    return this.end;
  }

  /* Name: setEnd
  * Purpose: Mutator for end 
  * Parameter: Point p
  * Return: void*/
  private void setEnd( Point p ){
    this.end=p;
  }
}
