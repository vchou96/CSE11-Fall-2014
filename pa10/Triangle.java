/* Name: Vanessa Chou
 *Login: cs11fbv
 *Date: December 5, 2014
 *File: Triangle.java
 *Sources of Help: 
 */

import java.awt.*;
import objectdraw.*;

/*Name: Triangle
*Purpose: Contains the methods of Class Triangle*/
public class Triangle extends Shape{
  Line myTriLine1;
  Line myTriLine2;
  Line myTriLine3;
  private Point p1;
  private Point p2;
  private Point p3;

  /*Name: Triangle (ctor)
  *Purpose: Sets the name of the shape as triangle, makes the new 3 points
  *Parameter: None*/
  public Triangle() { 
    super("Triangle: ");
    this.setP1(new Point());
    this.setP2(new Point());
    this.setP3(new Point());
  }
  
  /*Name: Triangle
  *Purpose: Takes the arguments and sets them to the 3 points
  *Parameter: Point p1, Point p2, Point p3*/
  public Triangle( Point p1, Point p2, Point p3 ) {
    super("Triangle: ");
    this.setP1(p1);
    this.setP2(p2);
    this.setP3(p3);
  }
  
  /*Name: Triangle 
  *Purpose: Functions as Triangle's copy ctor
  *Parameter: Triangle tri*/
  public Triangle( Triangle tri ) {
    super("Triangle: ");
    this.setP1( new Point( tri.getP1() ) );
    this.setP2( new Point( tri.getP2() ) );
    this.setP3( new Point( tri.getP3() ) );
  }
  
  /*Name: move
  *Purpose: Moves the Triangle
  *Parameter: int xDelta, int yDelta
  *Return: void*/
  public void move( int xDelta, int yDelta ) {
    setP1(new Point (getP1().getX()+xDelta, getP1().getY()+yDelta));
    setP2(new Point (getP2().getX()+xDelta, getP2().getY()+yDelta));
    setP3(new Point (getP3().getX()+xDelta, getP3().getY()+yDelta));
  }

  /* Name: toString
  * Purpose: Puts Triangle's information (coordinates,name,shape) in a string
  * Parameter: None
  * Return: String*/
  @Override
  public String toString() { 
    return super.getName() + getP1().toString() + ", " + getP2().toString() 
           + ", " + getP3().toString();
  }

  /* Name: equals
  * Purpose: Checks whether two objects equal one another
  * Parameter: Object o
  * Return: boolean*/
  @Override
  public boolean equals( Object o ) { 
    if (o!=null && this.getClass() == (o.getClass()) && 
        getP1().equals(((Triangle)o).getP1()) && 
        getP2().equals(((Triangle)o).getP2()) && 
        getP3().equals(((Triangle)o).getP3())){
      return true;
    }
    return false;//if not equal to each other

  }

  /* Name: hashCode
  * Purpose: Computes the hashcode
  * Parameter: None
  * Return: int*/
  @Override
  public int hashCode() { 
    return this.toString().hashCode();
  }

  /*Name: draw
  *Purpose: Draws the Triangle
  *Parameter: DrawingCanvas canvas, Color c, boolean fill
  *Return: void*/
  public void draw( DrawingCanvas canvas, Color c, boolean fill ) { 
    myTriLine1= new Line((double)getP1().getX(), (double)getP1().getY(), 
                 (double)getP2().getX(),(double)getP2().getY(), canvas);    
    myTriLine2= new Line((double)getP2().getX(), (double)getP2().getY(), 
                 (double)getP3().getX(),(double)getP3().getY(), canvas);    
    myTriLine3= new Line((double)getP3().getX(), (double)getP3().getY(), 
                 (double)getP1().getX(),(double)getP1().getY(), canvas);
    //filled
    if (fill){
      if (c==null){
        myTriLine1.setColor(Color.black);
        myTriLine2.setColor(Color.black);
        myTriLine3.setColor(Color.black);
      }
      else{
        myTriLine1.setColor(c);
        myTriLine2.setColor(c);
        myTriLine3.setColor(c);
      }
    }
    //empty
    else{
      if (c==null){
        myTriLine1.setColor(Color.black);
        myTriLine2.setColor(Color.black);
        myTriLine3.setColor(Color.black);
      }
      else{
        myTriLine1.setColor(c);
        myTriLine2.setColor(c);
        myTriLine3.setColor(c);
      }
    }
  }
  
  /* Name: getP1
  * Purpose: Accessor for p1
  * Parameter: None 
  * Return: Point*/
  public Point getP1(){
    return this.p1;
  }

  /* Name: setP1
  * Purpose: Mutator for p1
  * Parameter: Point P1 
  * Return: void*/
  private void setP1( Point p1 ){
    this.p1=p1;
  }

  /* Name: getP2
  * Purpose: Accessor for p2
  * Parameter: None 
  * Return: Point*/
  public Point getP2(){
    return this.p2;
  }

  /* Name: setP2
  * Purpose: Mutator for p2
  * Parameter: Point P2 
  * Return: void*/
  private void setP2( Point p2 ){
    this.p2=p2;
  }
  /* Name: getP3
  * Purpose: Accessor for p3
  * Parameter: None 
  * Return: Point*/
  public Point getP3(){
    return this.p3;
  }

  /* Name: setP3
  * Purpose: Mutator for p3
  * Parameter: Point P3 
  * Return: void*/
  private void setP3( Point p3 ){
    this.p3=p3;
  }

 }
