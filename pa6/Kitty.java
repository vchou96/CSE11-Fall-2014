import objectdraw.*;
import java.awt.Color;

/*Name: Kitty
Purpose: Includes all the information for the kitty card and when it is selected.
Parameter: None*/
public class Kitty implements AnimalCard {
  VisibleImage myKitty;
  FramedRect outline, smallerOutline;
  private static final String KITTY_SPEAK = "Meow";
  private int second = 2;
  private Location point;
  private Color color;
  
  /*Name: Kitty
  Purpose: Contains information for the kitty image and its border.
  Parameter: Image, Location, DrawingCanvas*/
  public Kitty(java.awt.Image kitty, Location point, DrawingCanvas canvas) { 
    myKitty = new VisibleImage(kitty, point, canvas);
    outline = new FramedRect(myKitty.getX(), myKitty.getY(), myKitty.getWidth(), myKitty.getHeight(),
                               canvas);
    smallerOutline= new FramedRect(outline.getX() + 1, outline.getY()+1, myKitty.getWidth()-second, myKitty.getHeight()-second, canvas);
    hideHighlight();
  }
  
  public String speak() {
    return KITTY_SPEAK;
  }
  public boolean contains(Location point) {
    if (myKitty.contains(point)){
      return true;
    } 
    else {
      return false;
    }
  }
  public void hide() {
    myKitty.hide();
  }
  public void show() {
    myKitty.show();
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


