/* Name: Vanessa Cpou
 * Login: cs11fbv 
 * Date: November 25, 2014
 * File: Rational.java
 * Sources of Help: Kristen Agcaoili
 *
 * This program will allow for numbers to be added, subtracted, multiplied,
 * and divided when in fraction form.
 */
 
  public class Rational{
    private int denominator;
    private int numerator;
    private int absVal;
    private int minus = -1;
   
   /* Name: Rational (ctor)
    * Purpose: Creates a default rational number of 0/1. 
    * Parameter: None*/
    public Rational(){
      this.setNumerator(0);
      this.setDenominator(1);
    }

   /* Name: Rational (ctor)
    * Purpose: Creates a rational number of num/1.
    * Parameter: int num*/
    public Rational( int num ){
      this.setNumerator(num);
      this.setDenominator(1);
    }
   
   /* Name:Rational (ctor)
    * Purpose: Creates a rational number of num/denom stored in reduced form 
    * Parameter: int num, int denom*/
    public Rational( int num, int denom ){
      this.setNumerator(num);
      this.setDenominator(denom);
      this.reduce();

    }
   
   /* Name: Rational (ctor)
    * Purpose: Copy ctor initializing this new Rational object with the 
    * numerator and denominator of parameter r. 
    * Parameter: Rational r*/
    public Rational( Rational r ){
      this.setNumerator(r.numerator);
      this.setDenominator(r.denominator);
    }
   
   /* Name: getNumerator
    * Purpose: Get the value of the numerator
    * Parameter: None
    * Return: int*/
    private int getNumerator(){
      return this.numerator;
    }
   
   /* Name: getDenominator
    * Purpose: Get the value of the denominator
    * Parameter: None
    * Return: int*/ 
    private int getDenominator(){
      return this.denominator;
    }

   /*Name: setNumerator
    *Purpose: Sets num to numerator
    *Parameter: int num
    *Return: void*/
    private void setNumerator( int num ){
      this.numerator= num;//set new numerator
    }
   
   /*Name: setDenominator
    *Purpose: Sets denom to denominator
    *Parameter: int denom
    *Return: void*/
    private void setDenominator( int denom ){
      if (denom==0){//cannot divide by 0
        throw new IllegalArgumentException("ERROR");
      }
      else{
        this.denominator=denom;//set new denominator
      }
    }
    
   /*Name: gcd
    *Purpose: Calculates the greatest common divisor 
    *Parameter: int x, int y
    *Return: int*/   
    private int gcd( int x, int y ){ 
      if (y== 0){
        return x;//base case 
      }
      else{
        return gcd( y, x % y);//recursion with the remainder  
      }
    }
   
  /*Name:reduce
   *Purpose: 
   *Parameter: None
   *Return: void*/
    private void reduce(){ 
      absVal = gcd(Math.abs(this.getNumerator()), 
                   Math.abs(this.getDenominator()));
      this.setNumerator(this.getNumerator()/absVal);
      this.setDenominator(this.getDenominator()/absVal);  
    }
 
  /*Name:add
   *Purpose: adds
   *Parameter: Rational r
   *Return: Rational*/
    public Rational add( Rational r ){
      int cd;
      int num;

      cd = this.denominator * r.denominator; // common denominator 
      num = this.numerator * r.denominator + r.numerator * 
            this.denominator; // cross multiply 
      numerator = num;
      denominator= cd;
      return new Rational(numerator, denominator);
    }
  
   /*Name:subtract  
    *Purpose:
    *Parameter: Rational r
    *Return: Rational*/
    public Rational subtract( Rational r ){
      int cd;
      int num;

      cd = this.denominator * r.denominator; // common denominator 
      num = this.numerator * r.denominator - r.numerator * 
            this.denominator; // cross multiply 
      numerator= num;
      denominator= cd;
      return new Rational(numerator, denominator);
    }
    
   /*Name:multiply  
    *Purpose:
    *Parameter: Rational r
    *Return: Rational*/
    public Rational multiply( Rational r ){ 
      numerator = this.numerator * r.numerator;  
      denominator = this.denominator * r.denominator; //straight multiply 
      return new Rational(numerator, denominator);      
    }

   /*Name: divide
    *Purpose:
    *Parameter: Rational r
    *Return: Rational*/
    public Rational divide( Rational r ){ 
      numerator = this.numerator * r.denominator; 
      denominator = this.denominator * r.numerator;  
      return new Rational(numerator, denominator);
    }

   /*Name: toString
    *Purpose: Returns the String representation of this Rational object
    *Parameter: None
    *Return: String*/
    public String toString(){
      //if denom is negative
      if (denominator < 0){
        this.setNumerator(this.numerator * minus);
        this.setDenominator(this.denominator * minus);
      }          
      if (denominator==1 || numerator==0){
        return Integer.toString(this.numerator);//whole number
      }
      else{ 
        return Integer.toString(this.numerator) + "/" + 
               Integer.toString(this.denominator); 
      }
    }
   
   /*Name: toFloat
    *Purpose: Returns the Float representation of this Rational object
    *Parameter: 
    *Return: Float*/
    public float toFloat(){
      float numerator = this.numerator;
      float denominator = this.denominator;
      return numerator/denominator;
    }
   
   /*Name: equals
    *Purpose: Compares numerators & denominators of this Rational object 
              and that of obj 
    *Parameter: Object obj
    *Return: boolean*/
    public boolean equals(Object obj){
      if (obj==null){
        return false;
      }

      if(this.numerator==((Rational)obj).getNumerator() && 
         this.denominator==((Rational)obj).getDenominator()){
        return true;
      }
      else {
        return false;
      }
    }
   
   /*Name:hashCode
    *Purpose: Computes the hashcode
    *Parameter: 
    *Return: int*/
    public int hashCode(){
      return this.toString().hashCode();
    }
}
