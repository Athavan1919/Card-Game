public class Game{

	private Deck mainDeck;
	private Die die; 
	private Deck playerDeck; 
	
	public Game (int ranks){
		mainDeck = new Deck(ranks);
		die = new Die();
	}

	//Make sure to improve later for user  input
	public int play(){
		playerDeck = new Deck();
		mainDeck.shuffle();

		for (int i = 0; i <7; i++){
			playerDeck.add(mainDeck.removeLast());
		}

		int rounds = 0;
		int roll = 0;
		while (playerDeck.hasCards()){
			roll = die.roll();
			if (roll == 1){
				Card discard = Utils.readCard();
				playerDeck.remove(discard);

			}else{
				//For other situation of die roll (2-6)
			}
		} 
		
		return rounds; 
	}
}