/*
 * Name: Vanessa Chou
 * Login: cs11fbv
 * Date: November 10, 2014
 * File: Memory.java
 * Sources of Help: Kristin Agcaoili, Sherman Lee, Nick Crow
 * 
 * This program will create a memory-card game where you match pairs of 
 * animals. If they match they will have green borders; if they do not 
 * they will have red borders. 
 * 
 */

import objectdraw.*;
import java.awt.Color;

/*Name: Memory
Purpose: Includes all the methods to interact with the cards.
Extends WindowController to open the applet*/
public class Memory extends WindowController {
  RandomIntGenerator randomAnimal;
  private Location point;
  private AnimalCard cow1;
  private AnimalCard cow2;
  private AnimalCard kitty1; 
  private AnimalCard kitty2; 
  private AnimalCard duck1;
  private AnimalCard duck2;
  private AnimalCard puppy1;
  private AnimalCard puppy2;
  private AnimalCard lion1;
  private AnimalCard lion2;
  private AnimalCard lamb1;
  private AnimalCard lamb2;
  private AnimalCard firstCard;//first card in a pair that are flipped up
  private AnimalCard secondCard;//second card in a pair that are flipped up
  private Location textLoc;

  private final int KITTY = 0;
  private final int DUCK = 1;
  private final int PUPPY = 2;
  private final int LION = 3;
  private final int COW = 4;
  private final int LAMB = 5;

  private int x;
  private int y;
  private int soundY= 20;

  //number of each animal card placed
  private int kittyCount = 0;
  private int duckCount = 0;
  private int puppyCount = 0;
  private int lionCount = 0;
  private int cowCount = 0;        
  private int lambCount = 0;
  private int pictureWidth=100;
  private int pictureHeight=100;
  private int border = 5;
  private int second = 2;
  private int third = 3;
  private int fourth= 4;

  private Location POS_1;
  private Location POS_2;
  private Location POS_3;
  private Location POS_4;
  private Location POS_5;
  private Location POS_6;
  private Location POS_7;
  private Location POS_8;
  private Location POS_9;
  private Location POS_10;
  private Location POS_11;
  private Location POS_12;
  private Text sound;

  private boolean animalChosen = false;/*if an position doesn't have an animal 
                                       occupying it*/
  private boolean doneKitty = false;//if the animal pair is matched and done
  private boolean doneDuck = false;
  private boolean donePuppy = false;
  private boolean doneLion = false;
  private boolean doneCow = false;
  private boolean doneLamb = false;
  private boolean clickedBefore = false;/*if another active card has been 
                                        clicked before this*/  
  private boolean clickedItself= false;/*if the card itself has been clicked 
                                       before*/
  private boolean kitty1shown =false;//if the card is face-up and shown
  private boolean kitty2shown =false;
  private boolean duck1shown =false;
  private boolean duck2shown =false;
  private boolean puppy1shown =false;
  private boolean puppy2shown =false;
  private boolean lion1shown =false;
  private boolean lion2shown =false;
  private boolean cow1shown =false;
  private boolean cow2shown =false;
  private boolean lamb1shown =false;
  private boolean lamb2shown =false;


  /*Name: begin
  Purpose: Runs when the program starts. Puts all the images on the screen.
  Parameter: None.
  Return: void */
  public void begin() {
  
    POS_1 = new Location (border,border);
    POS_2 = new Location (pictureWidth + border * second,border);
    POS_3 =new  Location (pictureWidth * second + border * third,border);
    POS_4 = new Location (border,pictureHeight + border * second);
    POS_5 = new Location (pictureWidth + border * second, pictureHeight + border * second);
    POS_6 = new Location (pictureWidth * second + border * third,pictureHeight + border * second);
    POS_7 = new Location (border, pictureHeight * second + border * third);
    POS_8 = new Location (pictureWidth + border * second,pictureHeight * second + border * third);
    POS_9 = new Location (pictureWidth * second + border * third, pictureHeight * second + border * third);
    POS_10 = new Location (border, pictureHeight * third + border * fourth);
    POS_11 = new Location (pictureWidth + border * second, pictureHeight * third + border * fourth);
    POS_12 = new Location (pictureWidth * second + border * third, pictureHeight * third + border * fourth);
    textLoc = new Location (0,0);
    sound = new Text("", textLoc, canvas);
    sound.hide();

    
    placeNextAnimal(POS_1);

    animalChosen = false;
    placeNextAnimal(POS_2);

    animalChosen = false;
    placeNextAnimal(POS_3);

    animalChosen = false;
    placeNextAnimal(POS_4); 

    animalChosen = false;
    placeNextAnimal(POS_5); 

    animalChosen = false;
    placeNextAnimal(POS_6); 

    animalChosen = false;
    placeNextAnimal(POS_7); 

    animalChosen = false;
    placeNextAnimal(POS_8); 

    animalChosen = false;
    placeNextAnimal(POS_9); 

    animalChosen = false;
    placeNextAnimal(POS_10); 

    animalChosen = false;
    placeNextAnimal(POS_11); 

    animalChosen = false;
    placeNextAnimal(POS_12);


    
    kitty1.showHighlight(Color.black);
    kitty2.showHighlight(Color.black);
    duck1.showHighlight(Color.black);
    duck2.showHighlight(Color.black);
    puppy1.showHighlight(Color.black);
    puppy2.showHighlight(Color.black);
    lion1.showHighlight(Color.black);
    lion2.showHighlight(Color.black);
    cow1.showHighlight(Color.black);
    cow2.showHighlight(Color.black);
    lamb1.showHighlight(Color.black);
    lamb2.showHighlight(Color.black);

  }


  public void placeNextAnimal(Location position) {
    randomAnimal = new RandomIntGenerator (0, 5);

    while (!animalChosen) {
    x = randomAnimal.nextValue();

      switch (x) {

        case KITTY://if the card created is kitty
        
          if (kittyCount < 2) {
            if (kittyCount == 0) {//kitty not has been created before
              kitty1 = new Kitty(getImage("kitty.jpg"), position, canvas);
              kitty1.hide();
            }
            else {//1 kitty has been created before
              kitty2 = new Kitty(getImage("kitty.jpg"), position, canvas);
              kitty2.hide();
            }
            kittyCount++;
            animalChosen = true;
          }

          else { //2 kitties already, choose another animal
            animalChosen=false;
          }
        break;
          

      
        case DUCK://if the card created is duck
          if (duckCount < 2){
            if (duckCount == 0) {
              duck1 = new Duck(getImage("duck.jpg"), position, canvas);
              duck1.hide();
            }
            else {        
              duck2 = new Duck(getImage("duck.jpg"), position, canvas);
              duck2.hide();
            }
            duckCount++;
            animalChosen = true;
          }

          else {
            animalChosen=false;//2 ducks already, choose another animal
          } 
        break;
          
      
      
        case PUPPY://if the card created is puppy
          if (puppyCount < 2) {  
            if (puppyCount == 0) {
              puppy1 = new Puppy(getImage("puppy.jpg"), position, canvas);
              puppy1.hide();
            }
            else {
              puppy2 = new Puppy(getImage("puppy.jpg"), position, canvas);
              puppy2.hide();
            }
            puppyCount++;
            animalChosen = true;           
          }
          
          else {
            animalChosen=false;//2 puppies already, choose another animal      
          } 
        break;
          

      
        
        case LION://if the card created is lion
          if (lionCount < 2) { 
            if (lionCount == 0) {
              lion1 = new Lion(getImage("lion.jpg"), position, canvas);
              lion1.hide();
            }
            else {
              lion2 = new Lion(getImage("lion.jpg"), position, canvas);
              lion2.hide();
            }
            lionCount++;
            animalChosen = true;            
          }
          
          else {
            animalChosen=false;//2 lions already, choose another animal           
          }
        break;
          

       
  
        case COW://if the card created is cow
          if (cowCount < 2) {    
            if (cowCount == 0) {
              cow1 = new Cow(getImage("cow.jpg"), position, canvas);
              cow1.hide();
            }
            else {
              cow2 = new Cow(getImage("cow.jpg"), position, canvas);
              cow2.hide();
            }
            cowCount++;
            animalChosen = true;
          }

          else {
            animalChosen=false;//2 cows already, choose another animal
          }
        break;
          

         
  
        case LAMB://if the card created is lamb
          if (lambCount < 2) {     
            if (lambCount == 0) {
              lamb1 = new Lamb(getImage("lamb.jpg"), position, canvas);
              lamb1.hide();
            }
            else {
              lamb2 = new Lamb(getImage("lamb.jpg"), position, canvas);
              lamb2.hide();
            }
            lambCount++;
            animalChosen = true;
          }
          
          else {
            animalChosen=false;//2 lambs already, choose another animal
          } 
        break;
          
      }          
    }
  }

  /*Name: onMouseClick
  Purpose: Runs when the mouse is clicked (press and release).
  Parameter: Mouse Location
  Return: void*/
  public void onMouseClick(Location point) {
    if (clickedBefore == false) {/*if no cards are face up other than 
                                   matched ones*/ 
      kitty1.showHighlight(Color.black);
      kitty2.showHighlight(Color.black);
      duck1.showHighlight(Color.black);
      duck2.showHighlight(Color.black);
      puppy1.showHighlight(Color.black);
      puppy2.showHighlight(Color.black);
      lion1.showHighlight(Color.black);
      lion2.showHighlight(Color.black);
      cow1.showHighlight(Color.black);
      cow2.showHighlight(Color.black);
      lamb1.showHighlight(Color.black);
      lamb2.showHighlight(Color.black);
      kitty1.hide();
      kitty2.hide();
      duck1.hide();
      duck2.hide();
      puppy1.hide();
      puppy2.hide();
      lion1.hide();
      lion2.hide();
      cow1.hide();
      cow2.hide();
      lamb1.hide();
      lamb2.hide();     
    }
    
    if (doneKitty) {
      kitty1.show();
      kitty2.show();
      kitty1.showHighlight(Color.green);
      kitty2.showHighlight(Color.green);
    }

    if (doneDuck){
      duck1.show();
      duck2.show();
      duck1.showHighlight(Color.green);
      duck2.showHighlight(Color.green);
    }

    if (donePuppy){
      puppy1.show();
      puppy2.show();
      puppy1.showHighlight(Color.green);
      puppy2.showHighlight(Color.green);
    }

    if (doneLion){
      lion1.show();
      lion2.show();
      lion1.showHighlight(Color.green);
      lion2.showHighlight(Color.green);
    }

    if (doneCow){
      cow1.show();
      cow2.show();
      cow1.showHighlight(Color.green);
      cow2.showHighlight(Color.green);
    }

    if (doneLamb){
      lamb1.show();
      lamb2.show();
      lamb1.showHighlight(Color.green);
      lamb2.showHighlight(Color.green);
    }


    //if kitty1 is clicked & it doesn't have a green border
    if (kitty1.contains(point) && kitty1.getHighlightColor() != Color.green 
        && kitty1.getHighlightColor() != Color.red && !doneKitty && firstCard != kitty1){
      if(kitty1shown == true){ //if the card is uncovered
      }
      else {//if card is hidden
        kitty1.show();//flips over card
        kitty1shown= true;
        if (clickedBefore== false) {//1st card to be clicked
          firstCard= kitty1;
          clickedBefore = true;
          kitty1shown= false;
        }
        else {
          secondCard= kitty1;
          if(kitty1.equals(firstCard)){
            sound.setText(kitty1.speak());
            sound.moveTo((canvas.getWidth()- sound.getWidth())/second, 
                          canvas.getHeight() - soundY);
            sound.show();
            kitty1.showHighlight(Color.green);
            firstCard.showHighlight(Color.green);
            doneKitty = true;
          }
          else{
            kitty1.showHighlight(Color.red);
            firstCard.showHighlight(Color.red);
            kitty1shown = false;
            firstCard = null;  
          }
          clickedBefore = false;        
        }
      }
    }


    //if kitty2 is clicked & it doesn't have a green border
    if (kitty2.contains(point) && kitty2.getHighlightColor() != Color.green
        && kitty2.getHighlightColor() != Color.red && !doneKitty&& firstCard != kitty2) {
      if(kitty2shown == true){ //if the card is uncovered
      }
      else {//if card is hidden
        kitty2.show();
        kitty2shown= true;
        if (clickedBefore== false) {//1st card to be clicked that isn't matched
          firstCard = kitty2;
          clickedBefore = true;
          kitty2shown= false;

        }
        else {
            secondCard= kitty2;
          if(kitty2.equals(firstCard)){
            sound.setText(kitty2.speak());
            sound.moveTo((canvas.getWidth()- sound.getWidth())/second, 
                          canvas.getHeight() - soundY);
            sound.show();
            kitty2.showHighlight(Color.green);
            firstCard.showHighlight(Color.green);
            doneKitty = true;
          }
          else{
            kitty2.showHighlight(Color.red);
            firstCard.showHighlight(Color.red);
            kitty2shown= false;
            firstCard = null;
          }
          clickedBefore = false;
        }
      }
    }

    //if duck1 is clicked & it doesn't have a green border
    if (duck1.contains(point) && duck1.getHighlightColor() != Color.green &&
        duck1.getHighlightColor() != Color.red && !doneDuck&& firstCard != duck1) {
      if(duck1shown == true){ //if the card is uncovered
      }
      else {//if card is hidden
        duck1.show();
        duck1shown= true;
        if (clickedBefore== false) {//1st card to be clicked that isn't matched
          firstCard = duck1;
          clickedBefore = true;
          duck1shown= false;

        }
        else {
            secondCard= duck1;
          if(duck1.equals(firstCard)){//if it is a match
            sound.setText(duck1.speak());
            sound.moveTo((canvas.getWidth()- sound.getWidth())/second, 
                          canvas.getHeight() - soundY);
            sound.show();
            duck1.showHighlight(Color.green);
            firstCard.showHighlight(Color.green);
            doneDuck = true;
          }
          else{//if it is not a match
            duck1.showHighlight(Color.red);
            firstCard.showHighlight(Color.red);
            duck1shown = false;
            firstCard = null;
          }
          clickedBefore = false;
        }
      }
    }

    //if duck2 is clicked & it doesn't have a green border
    if (duck2.contains(point) && duck2.getHighlightColor() != Color.green &&
        duck2.getHighlightColor() != Color.red && !doneDuck&& firstCard != duck2) {
      if(duck2shown == true){ //if the card is uncovered
      }
      else {//if card is hidden
        duck2.show();
        duck2shown= true;
        if (clickedBefore== false) {//1st card to be clicked that isn't matched
          firstCard = duck2;
          clickedBefore = true;
          duck2shown= false;

        }
        else {
            secondCard= duck2;
          if(duck2.equals(firstCard)){
            sound.setText(duck2.speak());
            sound.moveTo((canvas.getWidth()- sound.getWidth())/second, 
                          canvas.getHeight() - soundY);
            sound.show();
            duck2.showHighlight(Color.green);
            firstCard.showHighlight(Color.green);
            doneDuck = true;
          }
          else{
            duck2.showHighlight(Color.red);
            firstCard.showHighlight(Color.red);
            duck2shown = false;
            firstCard = null;
          }
          clickedBefore = false;
        }
      }
    }

    //if puppy1 is clicked & it doesn't have a green border
    if (puppy1.contains(point) && puppy1.getHighlightColor() != Color.green &&
        puppy1.getHighlightColor() != Color.red && !donePuppy&& firstCard != puppy1) { 
      if(puppy1shown == true){ //if the card is uncovered
      }
      else {//if card is hidden
        puppy1.show();
        puppy1shown= true;
        if (clickedBefore== false) {//1st card to be clicked that isn't matched
          firstCard = puppy1;
          clickedBefore = true;
          puppy1shown= false;


        }
        else {
            secondCard= puppy1;
          if(puppy1.equals(firstCard)){
            sound.setText(puppy1.speak());
            sound.moveTo((canvas.getWidth()- sound.getWidth())/second, 
                          canvas.getHeight() - soundY);
            sound.show();
            puppy1.showHighlight(Color.green);
            firstCard.showHighlight(Color.green);
            donePuppy = true;
          }
          else{
            puppy1.showHighlight(Color.red);
            firstCard.showHighlight(Color.red);
            puppy1shown = false;
            firstCard = null;
          }
          clickedBefore = false;
        }
      }
    }

    //if puppy2 is clicked & it doesn't have a green border
    if (puppy2.contains(point) && puppy2.getHighlightColor() != Color.green && 
        puppy2.getHighlightColor() != Color.red && !donePuppy && firstCard != puppy2) { 
      if(puppy2shown == true){ //if the card is uncovered
      }
      else {//if card is hidden
        puppy2.show();
        puppy2shown= true;
        if (clickedBefore== false) {//1st card to be clicked that isn't matched
          firstCard = puppy2;
          clickedBefore = true;
          puppy2shown= false;

        }
        else {
            secondCard= puppy2;
          if(puppy2.equals(firstCard)){
            sound.setText(puppy2.speak());
            sound.moveTo((canvas.getWidth()- sound.getWidth())/second, 
                          canvas.getHeight() - soundY);
            sound.show();
            puppy2.showHighlight(Color.green);
            firstCard.showHighlight(Color.green);
            donePuppy = true;
          }
          else{
            puppy2.showHighlight(Color.red);
            firstCard.showHighlight(Color.red);
            puppy2shown = false;
            firstCard = null;
          }
          clickedBefore = false;
        }
      }
    }

    //if lion1 is clicked & it doesn't have a green border
    if (lion1.contains(point) && lion1.getHighlightColor() != Color.green &&
        lion1.getHighlightColor() != Color.red && !doneLion && firstCard != lion1) {
      if(lion1shown == true){ //if the card is uncovered
      }
      else {//if card is hidden
        lion1.show();
        lion1shown= true;
        if (clickedBefore== false) {//1st card to be clicked that isn't matched
          firstCard = lion1;
          clickedBefore = true;
          lion1shown= false;

        }
        else {
            secondCard= lion1;
          if(lion1.equals(firstCard)){
            sound.setText(lion1.speak());
            sound.moveTo((canvas.getWidth()- sound.getWidth())/second, 
                          canvas.getHeight() - soundY);
            sound.show();
            lion1.showHighlight(Color.green);
            firstCard.showHighlight(Color.green);
            doneLion = true;
          }
          else{
            lion1.showHighlight(Color.red);
            firstCard.showHighlight(Color.red);
            lion1shown = false;
            firstCard =null;
          }
          clickedBefore = false;
        }
      }
    }

    //if lion2 is clicked & it doesn't have a green border
    if (lion2.contains(point) && lion2.getHighlightColor() != Color.green &&
        lion2.getHighlightColor() != Color.red && !doneLion&& firstCard != lion2) {
      if(lion2shown == true){ //if the card is uncovered
      }
      else {//if card is hidden
        lion2.show();
        lion2shown= true;
        if (clickedBefore== false) {//1st card to be clicked that isn't matched
          firstCard = lion2;
          clickedBefore = true;
          lion2shown= false;


        }
        else {
            secondCard= lion2;
          if(lion2.equals(firstCard)){
            sound.setText(lion2.speak());
            sound.moveTo((canvas.getWidth()- sound.getWidth())/second, 
                          canvas.getHeight() - soundY);
            sound.show();
            lion2.showHighlight(Color.green);
            firstCard.showHighlight(Color.green);
            doneLion = true;
          }
          else{
            lion2.showHighlight(Color.red);
            firstCard.showHighlight(Color.red);
            lion2shown = false;
            firstCard=null;

          }
          clickedBefore = false;
        }
      }
    }

    //if cow1 is clicked & it doesn't have a green border
    if (cow1.contains(point) && cow1.getHighlightColor() != Color.green && 
        cow1.getHighlightColor() != Color.red && !doneCow&& firstCard != cow1) {
      if(cow1shown == true){ //if the card is uncovered
      }
      else {//if card is hidden
        cow1.show();
        cow1shown= true;
        if (clickedBefore== false) {//1st card to be clicked that isn't matched
          firstCard = cow1;
          clickedBefore = true;
          cow1shown= false;

        }
        else {
            secondCard= cow1;
          if(cow1.equals(firstCard)){
            sound.setText(cow1.speak());
            sound.moveTo((canvas.getWidth()- sound.getWidth())/second, 
                          canvas.getHeight() - soundY);
            sound.show();
            cow1.showHighlight(Color.green);
            firstCard.showHighlight(Color.green);
            doneCow = true;
          }
          else{
            cow1.showHighlight(Color.red);
            firstCard.showHighlight(Color.red);
            cow1shown = false;
            firstCard=null;

          }
          clickedBefore = false;
        }
      }
    }

    //if cow2 is clicked & it doesn't have a green border
    if (cow2.contains(point) && cow2.getHighlightColor() != Color.green &&
        cow2.getHighlightColor() != Color.red && !doneCow&& firstCard != cow2) {  
      if(cow2shown == true){ //if the card is uncovered
      }
      else {//if card is hidden
        cow2.show();
        cow2shown= true;
        if (clickedBefore== false) {//1st card to be clicked that isn't matched
          firstCard = cow2;
          clickedBefore = true;
          cow2shown= false;


        }
        else {
            secondCard= cow2;
          if(cow2.equals(firstCard)){
            sound.setText(cow2.speak());
            sound.moveTo((canvas.getWidth()- sound.getWidth())/second, 
                          canvas.getHeight() - soundY);
            sound.show();
            cow2.showHighlight(Color.green);
            firstCard.showHighlight(Color.green);
            doneCow = true;
          }
          else{
            cow2.showHighlight(Color.red);
            firstCard.showHighlight(Color.red);
            cow2shown = false;
            firstCard=null;

          }
          clickedBefore = false;
        }
      }
    }
    
    //if lamb1 is clicked & it doesn't have a green border
    if (lamb1.contains(point) && lamb1.getHighlightColor() != Color.green &&
        lamb1.getHighlightColor() != Color.red && !doneLamb&& firstCard != lamb1) {
      if(lamb1shown == true){ //if the card is uncovered
      }
      else {//if card is hidden
        lamb1.show();
        lamb1shown= true;
        if (clickedBefore== false) {//1st card to be clicked that isn't matched
          firstCard = lamb1;
          clickedBefore = true;          
          lamb1shown= false;
        }
        else {
            secondCard= lamb1;
          if(lamb1.equals(firstCard)){
            sound.setText(lamb1.speak());
            sound.moveTo((canvas.getWidth()- sound.getWidth())/second, 
                          canvas.getHeight() - soundY);
            sound.show();
            lamb1.showHighlight(Color.green);
            firstCard.showHighlight(Color.green);
            doneLamb = true;
          }
          else{
            lamb1.showHighlight(Color.red);
            firstCard.showHighlight(Color.red);
            lamb1shown = false;
            firstCard=null;

          }
          clickedBefore = false;
        }
      }
    }

    //if lamb2 is clicked & it doesn't have a green border
    if (lamb2.contains(point) && lamb2.getHighlightColor() != Color.green &&
        lamb2.getHighlightColor() != Color.red && !doneLamb && firstCard != lamb2) {
      if(lamb2shown == true){ //if the card is uncovered
      }
      else {//if card is hidden
        lamb2.show();
        lamb2shown= true;
        if (clickedBefore== false) {//1st card to be clicked that isn't matched
          firstCard = lamb2;
          clickedBefore = true;
          lamb2shown= false;

        }
        else {
            secondCard= lamb2;
          if(lamb2.equals(firstCard)){
            sound.setText(lamb2.speak());
            sound.moveTo((canvas.getWidth()- sound.getWidth())/second, 
                          canvas.getHeight() - soundY);
            sound.show();
            lamb2.showHighlight(Color.green);
            firstCard.showHighlight(Color.green);
            doneLamb = true;
          }
          else{
            lamb2.showHighlight(Color.red);
            firstCard.showHighlight(Color.red);
            lamb2shown = false;
            firstCard=null;

          }
          clickedBefore = false;
        }
      }
    }    
  }
}
