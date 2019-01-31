// Author: Athavan Jeevakumar
// Student number: 300060442
// Author: Aman Riat
// Student number: 300056269
// Course: ITI 1121-C
// Assignment: 1
// Question: 2

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    /**
    * A constructor for the class <code>Deck</code>. It creates the initial
    * <code>ArrayList</code> that will be used to store the cards of Otherwise
    * deck.
    */

    public Deck() {
        cards = new ArrayList<Card>();
    }

    /**
    * A constructor for the class <code>Deck</code>. It creates the initial
    * <code>ArrayList</code> that will be used to store the cards of Otherwise
    * deck. The parameter specifies the number of ranks for the cards. Finally,
    * it also initializes this deck to contain 4 x n cards, where n is the value
    * of the parameter.
    *
    * @param range the number of ranks for the cards
    */


    public Deck(int range) {
        cards = new ArrayList<Card>();
        Card newCard; 

        for (int i = 0; i < 4; i++){
            for (int x = 0; x < range; x ++){
                newCard = new Card(i,x);
                cards.add(newCard);
            }
        }
    }
    
    /**
    * A method to check the number of cards in a deck
    * @return int this returns the number of cards in a deck
    */

    public int size(){
        return cards.size();
    }

    /**
    * A method to check if there are cards in a deck
    * @return boolean this returns true if there are cards and false otherwise
    */
   
    public boolean hasCards(){        
        if (cards.size() >= 1){
            return true;
        }
        return false;
    }

    /**
    * this is a getter method
    * A method to get a card at specific position in a deck
    * @param pos position of card in deck 
    * @return Card this returns the desired card at the position 
    */

    public Card get(int pos){
        return cards.get(pos);
    }

    /**
    * A method to add a card to the end of a deck
    * @param card the card to be added 
    */

    public void add(Card card){
        cards.add(card);
    }

    /**
    * A method to add all the cards from 
    * @param other the other deck of cards 
    */

    public void addAll(Deck other){
        int length = other.size();
        for (int i = 0; i < length; i++){
            this.add(other.removeFirst());
        } 
    }

    /**
    * A method to remove a card at the top of the deck 
    * @return Card this returns the card at the top of the deck 
    */

    public Card removeLast(){
        int length = cards.size();
        Card lastCard = cards.get(length-1);
        cards.remove(length-1);
        return (lastCard);
    }

    /**
    * A method to remove a card at the bottom of the deck 
    * @return Card this returns the card at the bottom of a deck 
    */

    public Card removeFirst(){
        Card firstCard = cards.get(0);
        cards.remove(0);
        return (firstCard);
    }

    /**
    * A method to remove a specific card from a deck 
    * @param card the card to be removed
    * @return boolean returns true if card was found and removed, false if not found/not removed
    */

    public boolean remove(Card card){
        int position = cards.indexOf(card);
        //-1 because if card is not found, indexOf returns -1
        if (position > -1){
            cards.remove(position);
            return true ;
        } 
        return false; 
    }

    /**
    * A method to remove similar card from the deck being called on from the deck other 
    * @param other the other deck of cards
    */

    public void removeAll(Deck other){
        int lengthOther = other.size();
        Card inCard; 
        for (int i = 0; i < lengthOther; i++){
            inCard = other.get(i);
            if (this.contains(inCard)){
                this.remove(inCard);
            }
        }
    }

    /**
    * A method to shuffles cards in the deck n
    */

     public void shuffle() {
            Collections.shuffle(cards);
    }

    /**
    * A method that removes cards from old deck and inserts into new deck
    * @param n the number of cards to be added 
    * @return Deck returns new deck with cards to be inserted into new deck
    */

    public Deck deal(int n) {
            Deck newDeck = new Deck();
            for (int i= 0; i < n; i++) {
                newDeck.add(this.removeLast());
            }
            return newDeck;
            
    }
    
    /**
    * A method that returns true if specified card is in the hand
    * @param card is the card to be checked 
    * @return boolean this returns true if the deck contains the card or false otherwise 
    */

    public boolean contains(Card card) {
        
            if (cards.contains(card)){
                return true;
            }
            return false;
            
    }
    
    /**
    * A method that returns true if the deck contains the same hand as the specified deck
    * @param other is the specified deck 
    * @return boolean this returns true if the deck contains all the same cards as the specificed deck or false otherwise
    */

    public boolean containsAll(Deck other) {
        for (int i = 0; i < other.size(); i++){
            //only used semi colon because condition stops when false, otherwise it keeps going and function will return true 
            if (this.contains(other.get(i))){
                ;
            }else{
                return false; 
            }
        }
        
        return true;
    }
    
    /**
    * A method that checks if the cards in the hand is a discardable kind
    * @return boolean that returns if hand is of discardable kind or false otherwise 
    */

    public boolean isKind() {
            int length = this.size();
        //Loop exits right away because if first 2 are good then it just exits, make sure it iterates over every single element
            if(length>=2) {
                for(int x=0; x<length-1; x++) {
                        Card cardOne = this.get(x);
                        Card cardTwo = this.get(x+1);
                        
                        if(cardOne.getRank() != cardTwo.getRank()) {
                            return false;
                        }
                }
                return true;
  
            }
            return false;
        
    }
    
    /**
    * A method that checks if the cards in the hand is a sequential kind  
    * @return boolean that returns if hand is of discardable sequential kind or false otherwise
    */

    public boolean isSeq() {

      int length = this.size();

    
      if (length >= 3){
          //Loop exits if the cards are not of the same suit and the rank is not sequential
          for(int i =1; i<cards.size();i++){
              Card cardOne = this.get(i);
              Card cardTwo = this.get(i-1);
            
              if (cardOne.getSuit()!= cardTwo.getSuit()){
                  return false;
              }
              if(cardOne.getRank() <= cardTwo.getRank()){
                  return false;
              }
          }
          return true;
      }
      return false;
    }

    /**
    * A method that sorts by the suits of the cards in a deck
    * First sorts by rank to properly organize suit sequence
    * Uses a modified bubble sort 
    */
  
    public void sortBySuit(){
        this.sortByRank();
        int length = this.size();
        //Bubble sort adapted from lab 1(300056269)
        for (int i = 0; i < length - 1; i++){
            for (int x = 0; x < length - i -1; x++){
                Card cardOne = this.get(x);
                Card cardTwo = this.get(x+1);
                if (cardOne.getSuit() > cardTwo.getSuit()){
                    this.cards.set(x,cardTwo);
                    this.cards.set(x+1,cardOne);
                }
            }
        }
    }

    /**
    * A method that sorts by ranks of the cards in a deck
    * Uses a modified bubble sort 
    */

    public void sortByRank(){
      int length = this.size();
        //Bubble sort adapted from lab 1(300056269)
        for (int i = 0; i < length - 1; i++){
            for (int x = 0; x < length - i -1; x++){
                Card cardOne = this.get(x);
                Card cardTwo = this.get(x+1);
                if (cardOne.getRank() > cardTwo.getRank()){
                    this.cards.set(x,cardTwo);
                    this.cards.set(x+1,cardOne);
                }
            }
        }   
    }

    /**
    * A method that displays the deck in two ways
    */

    public void print(){
        System.out.print("Sorted by Suit: ");
        this.sortBySuit();
        for (int i = 0; i < this.size(); i++){
            System.out.print(this.get(i) + " ");
        }
        System.out.println(" ");
        System.out.print("Sorted by Rank: ");
        this.sortByRank();
        for (int x = 0; x < this.size(); x++){
            System.out.print(this.get(x)+ " ");
        }

    }

     /**
    * A method that makes a string representation of a deck 
    * @return String this returns a string representation of the deck
    */

    public String toString(){
        String allCards = (cards.get(0)).toString(); 
        for (int i = 1; i < cards.size(); i ++){
           allCards = allCards + " " + (cards.get(i)).toString();

        }
        return allCards; 
    }
        

}
