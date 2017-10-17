import objectdraw.*;
import java.awt.Color;

/*Name: Lamb
Purpose: Includes all the information for the lamb card and when it is selected.
Parameter: None*/
public class Lamb implements AnimalCard {
  VisibleImage myLamb;
  FramedRect outline, smallerOutline;
  private static final String LAMB_SPEAK = "Baaa";
  private int second = 2;
  private Location point;
  private Color color;

  /*Name: Lamb
  Purpose: Contains information for the lamb image and its border.
  Parameter: Image, Location, DrawingCanvas*/
  public Lamb(java.awt.Image lamb, Location point, DrawingCanvas canvas) { 
    myLamb = new VisibleImage(lamb, point, canvas);
    outline = new FramedRect(myLamb.getX(), myLamb.getY(), myLamb.getWidth(), myLamb.getHeight(),
                               canvas);
    smallerOutline= new FramedRect(outline.getX()+1, outline.getY()+1, myLamb.getWidth()-second, myLamb.getHeight()-second, canvas);
    hideHighlight();
  }
  public String speak() {
    return LAMB_SPEAK;
  }
  public boolean contains(Location point) {
    if (myLamb.contains(point)){
      return true;
    } 
    else {
      return false;
    }
  }
  public void hide() {
    myLamb.hide();
  }
  public void show() {
    myLamb.show();
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

