/* Name: Vanessa Cpou
 * Login: cs11fbv 
 * Date: December 5, 2014
 * File: Point.java
 * Sources of Help: Kristin Agcaoili*/

/* Name: Point 
* Purpose: Contains all the methods of class Point*/ 
public class Point{
  private int x;
  private int y;

  /* Name: Point (ctor)
  * Purpose: Sets new x y ints
  * Parameter: None*/
  public Point(){
    this.setX(0);
    this.setY(0);
  }

  /* Name: Point
  * Purpose: Takes x y arguments and sets as current x y 
  * Parameter: int x, int y*/
  public Point( int x, int y ) {
    this.setX(x);
    this.setY(y);
  }
  
  /* Name: Point (copy ctor)
  * Purpose: Functions as point's copy ctor
  * Parameter: Point point*/
  public Point( Point point ) {
    this.setX (( point.getX() ) );
    this.setY((point.getY()));
  }

  /* Name: getX
  * Purpose: get the X value 
  * Parameter: None
  * Return: int*/
  public int getX() {
    return this.x;
  }
  
  /* Name: getY
  * Purpose: get the Y value
  * Parameter: None
  * Return: int*/
  public int getY() { 
    return this.y;
  }
  
  /* Name: setX
  * Purpose: Sets the X value
  * Parameter: int x
  * Return: void*/
  private void setX( int x ) { 
    this.x = x;
  } // Private! so Points are immutable
  
  /* Name: setY
  * Purpose: Sets the Y value
  * Parameter: int y
  * Return: void*/
  private void setY( int y ) { 
    this.y = y;
  } // Private! so Points are immutable
  
  /* Name: move
  * Purpose: Moves the point
  * Parameter: int xDelta, int yDelta
  * Return: void*/  
  public void move( int xDelta, int yDelta ) {
    setX(getX()+xDelta);
    setY(getY()+yDelta);
  }

  /* Name: toString
  * Purpose:  Puts the points in a string
  * Parameter : None
  * Return: String*/  
  @Override
  public String toString() { 
    return "Point: (" + this.getX() + "," + this.getY() + ")";
  }

  /* Name: equals
  * Purpose: Checks whether two objects equal one another
  * Parameter: Object o
  * Return: boolean*/  
  @Override
  public boolean equals( Object o ) {
    if(o!=null && this.getClass() == (o.getClass()) && 
       this.getX() == (((Point)o).getX()) && 
       this.getY() == (((Point)o).getY())){      
      return true;
    }
    return false;
  }

  /* Name: hashCode
  * Purpose: Computes the hashcode 
  * Parameter: None
  * Return: int*/  
  @Override
  public int hashCode() {
    return this.toString().hashCode();
  }
}
