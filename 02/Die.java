// Author: Athavan Jeevakumar
// Student number: 300060442
// Author: Aman Riat
// Student number: 300056269
// Course: ITI 1121-C
// Assignment: 1
// Question: 2

import java.util.Random;

public class Die {
	
	int dieRoll;
	//Declaring constant 
	public static final int MAXVALUE = 6;
	
	//Constructor initalizes the value of the die with a random number within 1 to 6
	Die(){
		Random randNum = new Random();
		dieRoll = randNum.nextInt(6)+1;		
	}
	
	//Returns the value of the dice roll
	public int getValue() {
		return dieRoll;
	}
	
	//Assigns a new value to the dice 
	public int roll() {
		
		Random randNum = new Random();
		dieRoll = randNum.nextInt(5)+1;	
		return dieRoll;
	}
	
	//Returns a string representation of the dice roll
	public String toString() {
		  return "Die" + " {value:" + dieRoll + "}";
	}

}

