/**
* Starting point for your implementation of the class Deck.
*
* @author Marcel Turcotte (marcel.turcotte@uottawa.ca)
*/

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

        // Complete the implementation of this constructor

    }
    public int size(){
        return cards.size();
    }
   
    public boolean hasCards(){        
        if (cards.size() >= 1){
            return true;
        }
        return false;

    }

    public Card get(int pos){
        return cards.get(pos);
    }

    public void add(Card card){
        cards.add(card);
    }

    public void addAll(Deck other){
        int length = other.size();
        for (int i = 0; i < length; i++){
            this.add(other.removeFirst());
        } 

    }
    public Card removeLast(){
        int length = cards.size();
        Card lastCard = cards.get(length-1);
        cards.remove(length-1);
        return (lastCard);
    }

    public Card removeFirst(){
        Card firstCard = cards.get(0);
        cards.remove(0);
        return (firstCard);
    }

    public boolean remove(Card card){
        int position = cards.indexOf(card);
        //-1 because if card is not found, indexOf returns -1
        if (position > -1){
            cards.remove(position);
            return true ;
        } 
        return false; 
    }

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

     //Shuffles the cards in the deck
     public void shuffle() {
            Collections.shuffle(cards);
    }
    
    //Removes cards from old deck and inserts into new deck
    public Deck deal(int n) {
            Deck newDeck = new Deck();
            for (int i= 0; i < n; i++) {
                newDeck.add(this.removeLast());
            }
            return newDeck;
            
    }
    
    //Returns true if specified card is in the hand
    public boolean contains(Card card) {
        
            if (cards.contains(card)){
                return true;
            }
            return false;
            
    }
    
    //Returns true if the deck contains the same hand as the specified deck
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
    
    //Check if the cards in the hand is a discardable kind
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
  
  //Checks if the cards in the hand is a sequential kind  
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
    public String toString(){
        String allCards = (cards.get(0)).toString(); 
        for (int i = 1; i < cards.size(); i ++){
           allCards = allCards + " " + (cards.get(i)).toString();

        }
        return allCards; 
    }
        

}
