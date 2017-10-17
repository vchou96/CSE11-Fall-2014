/* Name: Vanessa Cpou
 * Login: cs11fbv 
 * Date: December 5, 2014
 * File: ARectangle.java
 * Sources of Help: */

/*Name: ARectangle
*Purpose: Contains all the methods of class ARectangle*/ 
public abstract class ARectangle extends Shape{
  private Point upperLeft; //Upper left corner-Common to all rectangle shapes

  /* Name: ARectangle
  * Purpose: Makes upperLeft a new point
  * Parameter: None*/
  public ARectangle() { 
    setUpperLeft (new Point());
  }

  /* Name: ARectangle
  * Purpose: Takes the arguments and sets x and y as the upperLeft and sends
  *          name to Shape class
  * Parameter: String name, int x, int y*/
  public ARectangle( String name, int x, int y ) { 
    super(name);
    setUpperLeft(new Point (x,y));
  }

  /* Name: ARectangle
  * Purpose: Sends name argument to Shape class and sets upperLeft argument
  *          as new upperLeft
  * Parameter: String namem Point upperLeft*/
  public ARectangle( String name, Point upperLeft ) { 
    super(name);
    this.setUpperLeft(new Point (upperLeft));
  }

  /* Name: ARectangle 
  * Purpose: Serves as ARectangle's copy ctor
  * Parameter: ARectangle r*/
  public ARectangle( ARectangle r ) {
    this.setUpperLeft( new Point( r.getUpperLeft() ) );
  }

  /* Name: move
  * Purpose: Moves the ARectangle
  * Parameter: int xDelta, intyDelta
  * Return: Void*/
  public void move( int xDelta, int yDelta ) {
    this.setUpperLeft(new Point (this.getUpperLeft().getX()+ xDelta, 
                      this.getUpperLeft().getY()+yDelta));
  }

  /* Name: toString
  * Purpose: Puts ARectangle's information (coordinates,name,shape) in a 
  *          string
  * Parameter: None
  * Return: String*/
  @Override
  public String toString() { 
    return super.getName() + getUpperLeft().toString() + " ";  
  } // getName() + upperLeft

  /* Name: equals
  * Purpose: Checks if two objects are equal
  * Parameter: Object o
  * Return: boolean*/
  @Override
  public boolean equals( Object o ) {
    if (o!=null && this.getClass() == (o.getClass()) && 
        this.getUpperLeft().equals(((ARectangle)o).getUpperLeft())){   
      return true;
    }
    return false;//if not equal
  } // std checks + upperLeft

  /* Name: hashCode
  * Purpose: Computes the hashcode 
  * Parameter: None
  * Return: int*/
  @Override
  public int hashCode() {
    return this.toString().hashCode();  
  }
  
  /* Name: getUpperLeft
  * Purpose: Accessor for upperLeft
  * Parameter: None 
  * Return: Point*/
  public Point getUpperLeft(){
    return this.upperLeft;
  }

  /* Name: setUpperLeft
  * Purpose: Mutator for upperLeft
  * Parameter: Point p 
  * Return: void*/
  private void setUpperLeft( Point p ){
    this.upperLeft= new Point(p);
  }
}
