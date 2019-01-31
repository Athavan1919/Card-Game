// Author: Athavan Jeevakumar
// Student number: 300060442
// Author: Aman Riat
// Student number: 300056269
// Course: ITI 1121-C
// Assignment: 1
// Question: 2
	  

public class Card {
	
	//Declaring instance variables 
	private int suitVal;
	private int rankVal;
	
	//Declaring constants 
	public static final int DIAMOND = 0;
	public static final int CLUB = 1;
	public static final int HEART = 2;
	public static final int SPADE = 3;

	//Constructor for card class taking inital suit and rank values
	Card(int suit, int rank){	
		suitVal = suit;
		rankVal = rank;	
	}
	
	//Returns the suit value of the card
	public int getSuit() {
		return suitVal;
	}
	
	//Returns the rank value of the card
	public int getRank() {
		return rankVal;
	}
	
	//Checks if the Card objects are the same  
	public boolean equals(Object object) {
		
		if (!(object instanceof Card)) {
			return false;
		}
		
		Card other;
		other = (Card) object;
		return other.suitVal == this.suitVal && other.rankVal == this.rankVal;
		
		}
	
	//Returns a string representation of the card 
	public String toString() {
		  return "{" + suitVal + "," + rankVal + "}";
	}

}
