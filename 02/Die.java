// Author: Athavan Jeevakumar
// Student number: 300060442
// Author: Aman Riat
// Student number: 300056269
// Course: ITI 1121-C
// Assignment: 1
// Question: 2

import java.util.Random;

public class Die {
	
	private int dieRoll;
	//Declaring constant 
	public static final int MAXVALUE = 6;
	
	
	/**
    * Constructor for die class that generates a random number btween 1 and 6
    */

	Die(){
		Random randNum = new Random();
		dieRoll = randNum.nextInt(6)+1;		
	}
	
	/**
    * this is a getter method
    * A method to return value of die roll
    * @return int this returns the number rolled
    */

	public int getValue() {
		return dieRoll;
	}
	
	/**
    * A method to roll a die between number and 6
    * @return int this returns the number rolled
    */

	public int roll() {
		
		Random randNum = new Random();
		dieRoll = randNum.nextInt(5)+1;	
		return dieRoll;
	}
	
	/**
    * A method to return string representation of a roll
    * @return String this returns string representation of a roll
    */
	public String toString() {
		  return "Die" + " {value:" + dieRoll + "}";
	}

}

