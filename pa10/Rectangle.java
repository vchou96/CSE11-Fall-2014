/* Name: Vanessa Cpou
 * Login: cs11fbv 
 * Date: December 5, 2014
 * File: Rectangle.java
 * Sources of Help: */

import java.awt.*;
import objectdraw.*;

/*Name: Rectangle
*Purpose: Contains all the methods of class Rectangle*/ 
public class Rectangle extends ARectangle{
  FilledRect myRect1;
  FramedRect myRect2;
  private int width;
  private int height;
  private Location corner;
  
  /* Name: Rectangle (ctor)
  * Purpose: 
  * Parameter: None*/
  public Rectangle() { 
    super();
    this.setWidth(0);
    this.setHeight(0);
  }

  /* Name: Rectangle
  * Purpose: Sets the name of the shape as Rectangle, makes the new width and
  *          height and sends x y to ARectangle class
  * Parameter: int x, int y, int width, int height*/
  public Rectangle( int x, int y, int width, int height) { 
    super("Rectangle: Upper Left Corner: ", x, y);
    this.setWidth(width);
    this.setHeight(height);    
  }

  /* Name: Rectangle
  * Purpose: Takes the arguments and sends upperLeft to ARectangle class and 
  *          sets width and height arguments to the current width and height
  * Parameter: Point upperLeft, int width, int height)*/
  public Rectangle(Point upperLeft, int width, int height) { 
    //super();
    super("Rectangle: Upper Left Corner: ", upperLeft);
    this.setWidth(width);
    this.setHeight(height);  
  }

  /* Name: Rectangle
  * Purpose: Serves as copy ctor
  * Parameter: rectangle r*/
  public Rectangle( Rectangle r ) {
    this.setWidth( ( r.getWidth() ) );
    this.setHeight( ( r.getHeight() ) );
  }
 
  /* Name: toString
  * Purpose: Puts Rectangle's information (coordinates,name,shape) in a string
  * Parameter: None
  * Return: String*/
  @Override
  public String toString() { // super.toString() + width + height
    Point point= new Point();
    return super.toString() + "Width: " + Integer.toString(getWidth()) + 
           " Height: " + Integer.toString(getHeight());
  }
  
  /* Name: equals
  * Purpose: Checks whether two objects equal one another
  * Parameter: Object o
  * Return: boolean*/
  @Override
  public boolean equals( Object o ) { // super.equals() + width + height
    if(o!=null && this.getClass() == (o.getClass()) && 
        getWidth() == (((Rectangle)o).getWidth()) && 
        getHeight() == (((Rectangle)o).getHeight())){
      return true;
    }
    return false;//if start and end points do not equal each other
  }
  
  /* Name: draw
  * Purpose: draws the rectangle
  * Parameter: DrawingCanvas canvas, Color c, boolean fill 
  * Return: void*/
  public void draw( DrawingCanvas canvas, Color c, boolean fill ) { 
     this.corner= new Location ((double)(super.getUpperLeft().getX()), 
                                (double)(super.getUpperLeft().getY()));
   
    //filled
    if (fill){
      myRect1= new FilledRect(this.corner,(double)(getWidth()),
                             (double)(getHeight()),canvas);    
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
      myRect2= new FramedRect(this.corner,(double)(getWidth()),
                             (double)(getHeight()),canvas);
      //setting the color
      if (c==null){
        myRect2.setColor(Color.black);
      }
      else{
        myRect2.setColor(c);
      }
    }
  }
  
  /* Name: getWidth
  * Purpose: Accessor for width
  * Parameter: None 
  * Return: int*/
  public int getWidth(){
    return this.width;
  }

  /* Name: setWidth
  * Purpose: Mutator for width
  * Parameter: int w 
  * Return: void*/
  private void setWidth( int w ){
    this.width=w;
  }

  /* Name: getHeight
  * Purpose: Accessor for height
  * Parameter: None 
  * Return: int*/
  public int getHeight(){
    return this.height;
  }

  /* Name: setHeight
  * Purpose: Mutator for height
  * Parameter: int h 
  * Return: void*/
  private void setHeight( int h ){
    this.height=h;
  }
}
