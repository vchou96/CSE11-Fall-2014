/* Name: Vanessa Cpou
 * Login: cs11fbv 
 * Date: December 5, 2014
 * File: Circle.java
 * Sources of Help: */

import java.awt.*;
import objectdraw.*;

/*Name: Circle
*Purpose: Contains all the methods of class Circle*/ 
public class Circle extends Shape{
  FilledOval myCircle1;
  FramedOval myCircle2;
  private Point center;
  private int radius;
  private int two=2;
  private Location corner;

  /* Name: Circle (ctor)
  * Purpose: Sets the name of the shape as circle, makes the new center 
  *          point and radius
  * Parameter: None*/
  public Circle() {
    super("Circle: Center: ");
    this.setCenter(new Point());
    this.setRadius(0);
  }

  /* Name: Circle
  * Purpose: Takes the arguments and sets them to the the center and radius
  * Parameter: Point center, int radius*/
  public Circle( Point center, int radius ) { 
    super("Circle: Center: ");
    this.setCenter(new Point (center));
    this.setRadius(radius);
  }
  
  /* Name: Circle 
  * Purpose: Serves as copy ctor
  * Parameter: Circle c*/
  public Circle( Circle c ) {
    super("Circle: Center: ");
    this.setCenter( new Point( c.getCenter() ) );
    this.setRadius( (c.getRadius()) );
  }

  /* Name: move
  * Purpose: Moves the circle
  * Parameter: int xDelta, intyDelta
  * Return: void*/
  public void move( int xDelta, int yDelta ) { 
    setCenter(new Point (getCenter().getX()+xDelta, 
              getCenter().getY()+yDelta));
  }
  
  /* Name: toString
  * Purpose: Puts Circle's information (coordinates,name,shape) in a string
  * Parameter: None
  * Return: String*/
  @Override
  public String toString() { 
    return super.getName() + getCenter().toString() + "; " + "Radius: "  + 
           Integer.toString(getRadius());
             
  }
  
  /* Name: equals
  * Purpose: Checks whether two objects equal one another
  * Parameter: Object o
  * Return: boolean*/
  @Override
  public boolean equals( Object o ) { 
    if (o!=null && this.getClass() == (o.getClass()) && 
        this.getCenter().equals(((Circle)o).getCenter())){
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
  * Purpose: draws the circle
  * Parameter: DrawingCanvas canvas, Color c, boolean fill 
  * Return: void*/
  public void draw( DrawingCanvas canvas, Color c, boolean fill ) { 
    corner= new Location(getCenter().getX()-getRadius(),getCenter().getY()-
                         getRadius());
    
    //filled
    if (fill){
      myCircle1= new FilledOval(corner,(double)(radius*two),
                               (double)(radius*two),canvas);    
      //setting the color
      if (c==null){
        myCircle1.setColor(Color.black);
        }
      else{
        myCircle1.setColor(c);
      }
    }
    //empty
    else {
      myCircle2= new FramedOval(corner,(double)(radius*two),
                               (double)(radius*two),canvas);
      //setting the color
      if (c==null){
        myCircle2.setColor(Color.black);
      }
      else{
        myCircle2.setColor(c);
      }
    }
  }
  
  /* Name: getCenter
  * Purpose: Accessor for center
  * Parameter: None 
  * Return: Point*/
  public Point getCenter(){
    return this.center;
  }

  /* Name: setCenter
  * Purpose: Mutator for center
  * Parameter: Point center 
  * Return: void*/
  private void setCenter( Point center ){
    this.center=center;
  }

  /* Name: getRadius
  * Purpose: Accessor for radius
  * Parameter: None 
  * Return: int*/
  public int getRadius(){
    return this.radius;
  }

  /* Name: setRadius
  * Purpose: Mutator for radius
  * Parameter: int radius 
  * Return: void*/
  private void setRadius( int radius ){
    this.radius=radius;
  }
}

