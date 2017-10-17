import objectdraw.*;
import java.awt.Color;

/*Name: Fish
Purpose: Includes all the information for the fish card and when it is selected.
Parameter: None*/
public class Fish implements AnimalCard {
  VisibleImage myFish;
  FramedRect outline, smallerOutline;
  private static final String FISH_SPEAK = "Blub";
  private int second = 2;
  private Location point;
  private Color color;

  /*Name: Fish
  Purpose: Contains information for the fish image and its border.
  Parameter: Image, Location, DrawingCanvas*/
  public Fish(java.awt.Image fish, Location point, DrawingCanvas canvas) { 
    myFish = new VisibleImage(fish, point, canvas);
    outline = new FramedRect(myFish.getX(), myFish.getY(), myFish.getWidth(), myFish.getHeight(),
                               canvas);
    smallerOutline= new FramedRect(outline.getX() + 1, outline.getY()+1, myFish.getWidth() - second, myFish.getHeight() - second, canvas);
    hideHighlight();
  }
  public String speak() {
    return FISH_SPEAK;
  }
  public boolean contains(Location point) {
    if (myFish.contains(point)) {
      return true;
    } 
    else {
      return false;
    }
  }
  public void hide() {
    myFish.hide();
  }
  public void show() {
    myFish.show();
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


