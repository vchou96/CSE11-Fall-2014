import objectdraw.*;
import java.awt.Color;

/*Name: Duck
Purpose: Includes all the information for the duck card and when it is selected.
Parameter: None*/
public class Duck implements AnimalCard {
  VisibleImage myDuck;
  FramedRect outline, smallerOutline;
  private static final String DUCK_SPEAK = "Quack";
  private int second = 2;
  private Location point;
  private Color color;
  
  /*Name: Duck
  Purpose: Contains information for the duck image and its border.
  Parameter: Image, Location, DrawingCanvas*/
  public Duck(java.awt.Image duck, Location point, DrawingCanvas canvas) { 
    myDuck = new VisibleImage(duck, point, canvas);
    outline = new FramedRect(myDuck.getX(), myDuck.getY(), myDuck.getWidth(), myDuck.getHeight(),
                               canvas);
    smallerOutline= new FramedRect(outline.getX() + 1, outline.getY() + 1, myDuck.getWidth()-second, myDuck.getHeight()-second, canvas);
    hideHighlight();
  }
  
  public String speak() {
    return DUCK_SPEAK;
  }
  public boolean contains(Location point) {
    if (myDuck.contains(point)){
      return true;
    } 
    else {
      return false;
    }
  }
  public void hide() {
    myDuck.hide();
  }
  public void show() {
    myDuck.show();
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

