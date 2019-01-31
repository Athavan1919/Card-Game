// Author: Athavan Jeevakumar
// Student number: 300060442
// Author: Aman Riat
// Student number: 300056269
// Course: ITI 1121-C
// Assignment: 1
// Question: 2
	  

public class Card {
	
	//Declaring instance variables to represent suit and rank of a card 
	private int suitVal;
	private int rankVal;
	
	//Declaring constants for each suit of a card 
	public static final int DIAMOND = 0;
	public static final int CLUB = 1;
	public static final int HEART = 2;
	public static final int SPADE = 3;

	/**
    * Constructor for card class taking inital suit and rank values
    * @param suit is the suit of a card
    * @param rank is the rank of a card
    */

	Card(int suit, int rank){	
		suitVal = suit;
		rankVal = rank;	
	}
	
	/**
	* this is a getter method
    * A method to return the suit of a card
    * @return int this returns suit of a card
    */

	public int getSuit() {
		return suitVal;
	}

	/**
	* this is a getter method
    * A method to return the rank of a card
    * @return int this returns rank of a card
    */

	public int getRank() {
		return rankVal;
	}


	/**
    * A method to check if cards are equal to eachother 
    * @param object which is another card 
    * @return boolean this returns true if cards are equivalent to one another and false otherwise 
    */
	
	//Checks if the Card objects are the same  
	public boolean equals(Object object) {
		
		if (!(object instanceof Card)) {
			return false;
		}
		
		Card other;
		other = (Card) object;
		return other.suitVal == this.suitVal && other.rankVal == this.rankVal;
		
		}
	
		
	/**
    * A method to return the string representation of a card
    * @return String this returns a string representation of a card
    */
	public String toString() {
		  return "{" + suitVal + "," + rankVal + "}";
	}

}
