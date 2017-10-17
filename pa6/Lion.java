import objectdraw.*;
import java.awt.Color;

/*Name: Lion
Purpose: Includes all the information for the lion card and when it is selected.
Parameter: None*/
public class Lion implements AnimalCard {
  VisibleImage myLion;
  FramedRect outline, smallerOutline;
  private static final String LION_SPEAK = "Roar";
  private int second = 2;
  private Location point;
  private Color color;

  /*Name: Lion
  Purpose: Contains information for the lion image and its border.
  Parameter: Image, Location, DrawingCanvas*/
  public Lion(java.awt.Image lion, Location point, DrawingCanvas canvas) { 
    myLion = new VisibleImage(lion, point, canvas);
    outline = new FramedRect(myLion.getX(), myLion.getY(), myLion.getWidth(), myLion.getHeight(),
                               canvas);
    smallerOutline= new FramedRect(outline.getX()+1, outline.getY()+1, myLion.getWidth()-second, myLion.getHeight()-second, canvas);
    hideHighlight();
  }
  
  public String speak() {
    return LION_SPEAK;
  }
  public boolean contains(Location point) {
    if (myLion.contains(point)){
      return true;
    } 
    else {
      return false;
    }
  }
  public void hide() {
    myLion.hide();
  }
  public void show() {
    myLion.show();
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
  

