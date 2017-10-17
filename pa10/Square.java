/* Name: Vanessa Cpou
 * Login: cs11fbv 
 * Date: December 5, 2014
 * File: square.java
 * Sources of Help: */

import java.awt.*;
import objectdraw.*;

/* Name: Square
* Purpose: Contains the methods for drawing squares*/ 
public class Square extends ARectangle{
  FilledRect myRect1;
  FramedRect myRect2;
  private int side;
  private Location corner;
  
  /* Name: Square
  * Purpose: Sets the name of the shape of Square, makes new side
  * Parameter: None*/
  public Square() { 
    super();
    setSide(0);
  }
  
  /* Name: Square
  * Purpose:  Takes x y arguments and sends to ARectangle and takes side 
  *           argument and sets it
  * Parameter: int x, int y, int side*/
  public Square( int x, int y, int side ) { 
    super("Square: Upper Left Corner: ", x, y);
    this.setSide(side);
  }
  
  /* Name: Square
  * Purpose: Sends name/ upperLeft to ARectangle class and takes side 
  *          argument and sets it
  * Parameter: Point upperLeft, int side*/
  public Square( Point upperLeft, int side ) { 
    super("Square: Upper Left Corner: ", upperLeft);
    this.setSide(side);
  }
  
  /*Name: Square
  * Purpose: Functions as Square's's copy ctor
  * Parameter: Square r*/
  public Square( Square r ) {
    super("Square: Upper Left Corner: ", r.getUpperLeft());  
    this.setSide( ( r.getSide() ) );
  }
  
  /* Name: toString
  * Purpose: Puts Square's information (coordinates,name,shape) in a string
  * Parameter: None
  * Return: String*/
  @Override
  public String toString() { 
    return super.toString() + "Sides: " + Integer.toString(getSide());
  } // super.toString() + side
  
  /* Name: equals
  * Purpose: Checks whether two objects equal one another
  * Parameter: Object o
  * Return: boolean*/
  @Override  
  public boolean equals( Object o ) {
    if (o!=null && this.getClass() == (o.getClass()) && 
        getSide()==(((Square)o).getSide())){      
      return true;
    }
    return false;//if not equal 
  } // super.equals() + side
  
  /* Name: draw
  * Purpose: draws the square
  * Parameter: DrawingCanvas canvas, Color c, boolean fill 
  * Return: void*/
  public void draw( DrawingCanvas canvas, Color c, boolean fill ) {     
    this.corner= new Location ((double)(super.getUpperLeft().getX()), 
                               (double)(super.getUpperLeft().getY()));

    //filled
    if (fill){
      myRect1= new FilledRect(this.corner, (double)(getSide()),
                             (double)(getSide()),canvas);    
      //setting the color
      if (c==null){
        myRect1.setColor(Color.black);
        }
      else{
        myRect1.setColor(c);
      }
    }
    //empty
    else {
      myRect2= new FramedRect(this.corner,(double)(getSide()),
                             (double)(getSide()),canvas);
      //setting the color
      if (c==null){
        myRect2.setColor(Color.black);
      }
      else{
        myRect2.setColor(c);
      }
    }
  }
    
  /* Name: getSide
  * Purpose: Accessor for side
  * Parameter: None 
  * Return: int*/
  public int getSide(){
    return this.side;
  }

  /* Name: setSide
  * Purpose: Mutator for side
  * Parameter: int side 
  * Return: void*/
  private void setSide( int side ){
    this.side=side;
  }
}
