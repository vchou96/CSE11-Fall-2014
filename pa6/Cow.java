import objectdraw.*;
import java.awt.Color;

/*Name: Cow
Purpose: Includes all the information for the cow card and when it is selected.
Parameter: None*/
public class Cow implements AnimalCard {
  VisibleImage myCow;
  FramedRect outline, smallerOutline;
  private static final String COW_SPEAK = "Moo";
  private int second = 2;
  private Location point;
  private Color color;

  /*Name: Cow
  Purpose: Contains information for the cow image and its border.
  Parameter: Image, Location, DrawingCanvas*/
  public Cow(java.awt.Image cow, Location point, DrawingCanvas canvas) { 
    myCow = new VisibleImage(cow, point, canvas);
    outline = new FramedRect(myCow.getX(), myCow.getY(), myCow.getWidth(), myCow.getHeight(),
                               canvas);
    smallerOutline= new FramedRect(outline.getX() + 1, outline.getY()+1, myCow.getWidth() - second, myCow.getHeight() - second, canvas);
    hideHighlight();
  }
  public String speak() {
    return COW_SPEAK;
  }
  public boolean contains(Location point) {
    if (myCow.contains(point)) {
      return true;
    } 
    else {
      return false;
    }
  }
  public void hide() {
    myCow.hide();
  }
  public void show() {
    myCow.show();
  }
  public void showHighlight(Color color){
    outline.setColor(color);
    smallerOutline.setColor(color);
    outline.show();
    smallerOutline.show();
  }
  public void hideHighlight(){
    outline.hide();
    smallerOutline.hide();    
  }
  public Color getHighlightColor(){
    return color;
  }
  public boolean equals (Object o) {
    return this.getClass()==o.getClass(); 
  }
  

}


