import objectdraw.*;
import java.awt.Color;

/*Name: Puppy
Purpose: Includes all the information for the puppy card and when it is selected.
Parameter: None*/
public class Puppy implements AnimalCard {
  VisibleImage myPuppy;
  FramedRect outline, smallerOutline;
  private static final String PUPPY_SPEAK = "Woof";
  private int second = 2;
  private Location point;
  private Color color;

  /*Name: Puppy
  Purpose: Contains information for the puppy image and its border.
  Parameter: Image, Location, DrawingCanvas*/
  public Puppy(java.awt.Image puppy, Location point, DrawingCanvas canvas) { 
    myPuppy = new VisibleImage(puppy, point, canvas);
    outline = new FramedRect(myPuppy.getX(), myPuppy.getY(), myPuppy.getWidth(), myPuppy.getHeight(),
                               canvas);
    smallerOutline= new FramedRect(outline.getX()+1, outline.getY()+1, myPuppy.getWidth()-second, myPuppy.getHeight()-second, canvas);
    hideHighlight();
  }
  
  public String speak() {
    return PUPPY_SPEAK;
  }
  public boolean contains(Location point) {
    if (myPuppy.contains(point)){
      return true;
    } 
    else {
      return false;
    }
  }
  public void hide() {
    myPuppy.hide();
  }
  public void show() {
    myPuppy.show();
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


