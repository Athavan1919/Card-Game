public class Card {
	
	private int suitVal;
	private int rankVal;
	
	public static final int DIAMOND = 0;
	public static final int CLUB = 1;
	public static final int HEART = 2;
	public static final int SPADE = 3;


	Card(int suit, int rank){	
		suitVal = suit;
		rankVal = rank;	
	}
	
	public int getSuit() {
		return suitVal;
	}
	
	public int getRank() {
		return rankVal;
	}
	
	public boolean equals(Object object) {
		
		if (!(object instanceof Card)) {
			return false;
		}
		
		Card other;
		other = (Card) object;
		return other.suitVal == suitVal && other.rankVal == rankVal;
		
		}
	
	
	public String toString() {
		  return "{" + suitVal + "," + rankVal + "}";
	}
	
	public static void main(String[] args) {
		 Card a, b, c;
		 a = new Card (2,7);
		 b = new Card (2,7) ;
		 c = new Card (0,9) ;
		 System.out.println(a) ;
		 System.out.println(a.equals(b));
		 System.out.println(a.equals(c)) ;			
	}

}
