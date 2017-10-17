/*
 * Name: Vanessa Chou
 * Login: cs11fbv
 * Date: November 10, 2014
 * File: AnimalSpeak.java
 * Sources of Help: Kristin Agcaoili 
 * 
 * This program creates a game where you match an animal's sound with the 
 * animal. 
 * 
 */

import objectdraw.*;
import java.awt.Color;

/*Name: AnimalSpeak
Purpose: Includes all the methods to interact with the cards.
Extends WindowController to open the applet*/
public class AnimalSpeak extends WindowController {
  RandomIntGenerator randInt;
  private int half= 2;
  private int promptY = 20;
  private int statusY = 40;
  private int second = 2;
  private int third = 3;
  private int fifth = 5;
  private int pictureHeight= 100;

  private Location pointKitty;  
  private Location pointDuck;
  private Location pointPuppy;
  private Location pointLion;
  private Location pointCow;
  private Location pointLamb;
  private Location pointFish;
  private Location pointBird;
  private Location pointPig;
  
  private AnimalCard cow;
  private AnimalCard kitty; 
  private AnimalCard duck;
  private AnimalCard puppy;
  private AnimalCard lion;
  private AnimalCard lamb;
  private AnimalCard fish;
  private AnimalCard bird;
  private AnimalCard pig;
  private AnimalCard animal;
  
  private Text prompt;
  private Text status;
  private Location textLoc;

  private final int CARD0 = 0;
  private final int CARD1 = 1;
  private final int CARD2 = 2;
  private final int CARD3 = 3;
  private final int CARD4 = 4;
  private final int CARD5 = 5;
  private final int CARD6 = 6;
  private final int CARD7 = 7;
  private final int CARD8 = 8;

  
  /*Name: begin
  Purpose: Runs when the program starts. Puts all the images on the screen.
  Parameter: None.
  Return: void */
  public void begin() {
    randInt = new RandomIntGenerator (0, 8);
    
    //location of each animal
    pointKitty= new Location (1, 1);
    pointDuck= new Location (canvas.getWidth()/third + 1, 1);
    pointPuppy= new Location (canvas.getWidth()/third * second + 1, 1);
    pointLion= new Location (1, pictureHeight + third);
    pointCow= new Location (canvas.getWidth()/third + 1, pictureHeight+third);
    pointLamb= new Location (canvas.getWidth()/third * second + 1, pictureHeight + third);
    pointFish= new Location (1, pictureHeight * second + fifth);
    pointBird= new Location (canvas.getWidth()/third + 1, pictureHeight * second + fifth);
    pointPig= new Location (canvas.getWidth()/third * second + 1, pictureHeight * second + fifth);

    
    //creates the animal images
    kitty = new Kitty(getImage("kitty.jpg"), pointKitty, canvas);
    duck = new Duck(getImage("duck.jpg"), pointDuck, canvas);
    puppy= new Puppy(getImage("puppy.jpg"), pointPuppy, canvas);
    lion= new Lion(getImage("lion.jpg"), pointLion, canvas);
    cow= new Cow(getImage("cow.jpg"), pointCow, canvas);
    lamb= new Lamb(getImage("lamb.jpg"), pointLamb, canvas);
    fish= new Fish(getImage("fish.jpg"), pointFish, canvas);
    bird= new Bird(getImage("bird.jpg"), pointBird, canvas);
    pig= new Pig(getImage("pig.jpg"), pointPig, canvas);

    pickAnAnimal();

  }

  /*Name: onMouseClick
  Purpose: Runs when the mouse is clicked (press and release).
  Parameter: Mouse Location
  Return: void*/
  public void onMouseClick(Location point) {

    if (animal != null) {//if an animal is picked by pickAnAnimal  
      
      //if kitty is clicked
      if (kitty.contains(point)) {      
        kitty.showHighlight(Color.red);
        status.setColor(Color.red);
        status.setText("WRONG! - Try Again!");
        status.moveTo((canvas.getWidth()- status.getWidth())/half, 
                       canvas.getHeight() - statusY);
        status.show();
        duck.hideHighlight();
        puppy.hideHighlight();
        lion.hideHighlight();
        cow.hideHighlight();
        lamb.hideHighlight();
        fish.hideHighlight();
        bird.hideHighlight();
        pig.hideHighlight();
      }
        
      //if duck is clicked
      else if (duck.contains(point)){
        duck.showHighlight(Color.red);
        status.setColor(Color.red);
        status.setText("WRONG! - Try Again!");
        status.moveTo((canvas.getWidth()- status.getWidth())/half, 
                       canvas.getHeight() - statusY);
        status.show();
        kitty.hideHighlight();
        puppy.hideHighlight();
        lion.hideHighlight();
        cow.hideHighlight();
        lamb.hideHighlight();
        fish.hideHighlight();
        bird.hideHighlight();
        pig.hideHighlight();
      }
    

      //if puppy is clicked
      else if (puppy.contains(point)){
        puppy.showHighlight(Color.red);
        status.setColor(Color.red);
        status.setText("WRONG! - Try Again!");
        status.moveTo((canvas.getWidth()- status.getWidth())/half,
                       canvas.getHeight() - statusY);
        status.show();
        duck.hideHighlight();
        kitty.hideHighlight();
        lion.hideHighlight();
        cow.hideHighlight();
        lamb.hideHighlight();
        fish.hideHighlight();
        bird.hideHighlight();
        pig.hideHighlight();
      } 
    

      //if lion is clicked
      else if (lion.contains(point)){
        lion.showHighlight(Color.red);
        status.setColor(Color.red);
        status.setText("WRONG! - Try Again!");
        status.moveTo((canvas.getWidth()- status.getWidth())/half,
                       canvas.getHeight() - statusY);
        status.show();
        duck.hideHighlight();
        puppy.hideHighlight();
        kitty.hideHighlight();
        cow.hideHighlight();
        lamb.hideHighlight();
        fish.hideHighlight();
        bird.hideHighlight();
        pig.hideHighlight();
      }
    
      //if cow is clicked
      else if (cow.contains(point)){
        cow.showHighlight(Color.red);
        status.setColor(Color.red);
        status.setText("WRONG! - Try Again!");
        status.moveTo((canvas.getWidth()- status.getWidth())/half, 
                       canvas.getHeight() - statusY);
        status.show();
        duck.hideHighlight();
        puppy.hideHighlight();
        lion.hideHighlight();
        kitty.hideHighlight();
        lamb.hideHighlight();
        fish.hideHighlight();
        bird.hideHighlight();
        pig.hideHighlight();
      } 
    
      //if lamb is clicked
      else if (lamb.contains(point)){    
        lamb.showHighlight(Color.red);
        status.setColor(Color.red);
        status.setText("WRONG! - Try Again!");
        status.moveTo((canvas.getWidth()- status.getWidth())/half, 
                       canvas.getHeight() - statusY);
        status.show();
        duck.hideHighlight();
        puppy.hideHighlight();
        lion.hideHighlight();
        cow.hideHighlight();
        kitty.hideHighlight();
        fish.hideHighlight();
        bird.hideHighlight();
        pig.hideHighlight();
      }

      //if fish is clicked
      else if (fish.contains(point)) {      
        fish.showHighlight(Color.red);
        status.setColor(Color.red);
        status.setText("WRONG! - Try Again!");
        status.moveTo((canvas.getWidth()- status.getWidth())/half, 
                       canvas.getHeight() - statusY);
        status.show();
        duck.hideHighlight();
        puppy.hideHighlight();
        lion.hideHighlight();
        cow.hideHighlight();
        lamb.hideHighlight();
        bird.hideHighlight();
        pig.hideHighlight();
      }
      
      //if bird is clicked
      else if (bird.contains(point)) {      
        bird.showHighlight(Color.red);
        status.setColor(Color.red);
        status.setText("WRONG! - Try Again!");
        status.moveTo((canvas.getWidth()- status.getWidth())/half, 
                       canvas.getHeight() - statusY);
        status.show();
        duck.hideHighlight();
        puppy.hideHighlight();
        lion.hideHighlight();
        cow.hideHighlight();
        lamb.hideHighlight();
        fish.hideHighlight();
        pig.hideHighlight();
      }

      //if pig is clicked
      else if (pig.contains(point)) {      
        pig.showHighlight(Color.red);
        status.setColor(Color.red);
        status.setText("WRONG! - Try Again!");
        status.moveTo((canvas.getWidth()- status.getWidth())/half, 
                       canvas.getHeight() - statusY);
        status.show();
        duck.hideHighlight();
        puppy.hideHighlight();
        lion.hideHighlight();
        cow.hideHighlight();
        lamb.hideHighlight();
        fish.hideHighlight();
        bird.hideHighlight();
      }
     
      //the click is not on any card. Hides highlight and correct/wrong 
      //message.
      else {      
        status.hide();
        lamb.hideHighlight();
        duck.hideHighlight();
        puppy.hideHighlight();
        lion.hideHighlight();
        cow.hideHighlight();
        kitty.hideHighlight();
        fish.hideHighlight();
        bird.hideHighlight();
        pig.hideHighlight();
      }
    }

    //Occurs after the correct animal has been clicked on and the mouse is 
    //clicked again. The old messages/highlights of the previous game is 
    //hidden and a new game starts.
    if (animal == null) { 
      status.hide();
      prompt.hide();
      lamb.hideHighlight();
      duck.hideHighlight();
      puppy.hideHighlight();
      lion.hideHighlight();
      cow.hideHighlight();
      kitty.hideHighlight();
      fish.hideHighlight();
      bird.hideHighlight();
      pig.hideHighlight();
      pickAnAnimal();
      
    }


    //if the click is within the correct card
    if (animal != null) {
      if (animal.contains(point)) {      
      status.setColor(Color.green);
      status.setText("CORRECT!- click mouse to restart");
      status.moveTo((canvas.getWidth()- status.getWidth())/half, 
                     canvas.getHeight() - statusY);
      animal.showHighlight(Color.green);
      animal = null;
      }
    }
    
    

    
  }

  /*Name: pickAnAnimal
  Purpose: To randomly choose the next card that the program will 
           ask the user to identify.
  Parameter: None.
  Return: void*/
  private void pickAnAnimal(){//chooses the next card to ask
    int x = randInt.nextValue();
    switch(x) {
      case CARD0: animal = kitty;
      break;
      case CARD1: animal = duck;
      break;
      case CARD2: animal = puppy;
      break;
      case CARD3: animal = lion;
      break;
      case CARD4: animal = cow;
      break;
      case CARD5: animal = lamb;
      break;
      case CARD6: animal = fish;
      break;
      case CARD7: animal = bird;
      break;
      case CARD8: animal = pig;
      break;

    }
    textLoc = new Location (0, 0);
    prompt = new Text("", textLoc, canvas);
    status = new Text("", textLoc, canvas);
    prompt.setText("Which animal says " + animal.speak() + "?");
    prompt.moveTo((canvas.getWidth()- prompt.getWidth())/half, 
                   canvas.getHeight() - promptY);
  //}
  }
}




  




