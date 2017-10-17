import objectdraw.*;
import java.awt.Color;

/*Name: Bird
Purpose: Includes all the information for the bird card and when it is selected.
Parameter: None*/
public class Bird implements AnimalCard {
  VisibleImage myBird;
  FramedRect outline, smallerOutline;
  private static final String BIRD_SPEAK = "Tweet";
  private int second = 2;
  private Location point;
  private Color color;

  /*Name: Bird
  Purpose: Contains information for the bird image and its border.
  Parameter: Image, Location, DrawingCanvas*/
  public Bird(java.awt.Image bird, Location point, DrawingCanvas canvas) { 
    myBird = new VisibleImage(bird, point, canvas);
    outline = new FramedRect(myBird.getX(), myBird.getY(), myBird.getWidth(), myBird.getHeight(),
                               canvas);
    smallerOutline= new FramedRect(outline.getX() + 1, outline.getY()+1, myBird.getWidth() - second, myBird.getHeight() - second, canvas);
    hideHighlight();
  }
  public String speak() {
    return BIRD_SPEAK;
  }
  public boolean contains(Location point) {
    if (myBird.contains(point)) {
      return true;
    } 
    else {
      return false;
    }
  }
  public void hide() {
    myBird.hide();
  }
  public void show() {
    myBird.show();
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


