import objectdraw.*;
import java.awt.Color;

/*Name: Pig
Purpose: Includes all the information for the pig card and when it is selected.
Parameter: None*/
public class Pig implements AnimalCard {
  VisibleImage myPig;
  FramedRect outline, smallerOutline;
  private static final String PIG_SPEAK = "Oink";
  private int second = 2;
  private Location point;
  private Color color;

  /*Name: Pig
  Purpose: Contains information for the pig image and its border.
  Parameter: Image, Location, DrawingCanvas*/
  public Pig(java.awt.Image pig, Location point, DrawingCanvas canvas) { 
    myPig = new VisibleImage(pig, point, canvas);
    outline = new FramedRect(myPig.getX(), myPig.getY(), myPig.getWidth(), myPig.getHeight(),
                               canvas);
    smallerOutline= new FramedRect(outline.getX() + 1, outline.getY()+1, myPig.getWidth() - second, myPig.getHeight() - second, canvas);
    hideHighlight();
  }
  public String speak() {
    return PIG_SPEAK;
  }
  public boolean contains(Location point) {
    if (myPig.contains(point)) {
      return true;
    } 
    else {
      return false;
    }
  }
  public void hide() {
    myPig.hide();
  }
  public void show() {
    myPig.show();
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


}


