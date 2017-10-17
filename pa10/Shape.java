/* Name: Vanessa Cpou
 * Login: cs11fbv 
 * Date: December 5, 2014
 * File: Shape.java
 * Sources of Help: */

import java.awt.*;
import objectdraw.*;

/* Name: Shape (ctor)
* Purpose: Keeps track of name of shape objects*/
public abstract class Shape{
  private String name;
  
  /* Name: Shape 
  * Purpose: Names new shape
  * Parameter: None*/
  public Shape() {
    setName(getName());
  }
  
  /* Name: Shape
  * Purpose: Takes name argument and sets it
  * Parameter: String name*/
  public Shape( String name ) {
    this.setName(name);
  }
  
  /* Name: getName 
  * Purpose: Accessor for name
  * Parameter: None
  * Return: String*/
  public String getName() { 
    return this.name;
  }
    
  /* Name: setName
  * Purpose: Mutator for name
  * Parameter: String name
  * Return: void*/
  private void setName( String name ) { 
    this.name=name;
  }
  
  /* Copy this as is in your Shape.java */
  /* Name: equals
  * Purpose: Checks if objects are equal type
  * Parameter: Object o
  * Return: boolean*/
  @Override
  public boolean equals( Object o ) {
  String s = "\n**********************************************************\n"
  + "This should never print. If it does print, then\n"
  + "you did not override equals() properly in class "
  + this.getClass().getName() + "\n"
  + "**********************************************************\n";
  System.out.println( s );
  return this == o;
  }
  
  /* Name: move
  * Purpose: Moves the shape
  * Parameter: int xDelta, intyDelta
  * Return: void*/
  public abstract void move( int xDelta, int yDelta );  
  
  /* Name: draw
  * Purpose: draws the shape
  * Parameter: DrawingCanvas canvas, Color c, boolean fill 
  * Return: void*/
  public abstract void draw( DrawingCanvas canvas, Color c, boolean fill );
}

