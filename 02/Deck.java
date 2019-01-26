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
        cards = new ArrayList<Card>((4*range));

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
        for (int i = 0; i < other.size(); i++){
            this.add(other.removeLast());
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

        

}
