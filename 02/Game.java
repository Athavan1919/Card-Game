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

		Deck cardsAdded = mainDeck.deal(7);
		playerDeck.addAll(cardsAdded);

		int rounds = 0;
		int roll = 0;
		playerDeck.print();
		System.out.println(" ");
		System.out.print("You roll the die and ");
		
		while (playerDeck.hasCards()){
			roll = die.roll();

			if (mainDeck.size() == 0){
				roll = 1;
			}
			
			if (roll == 1){
				System.out.println("you got a 1, please discard a card: ");
				Card discard = Utils.readCard();
				playerDeck.remove(discard);
				System.out.println(" ");

			}else{
				System.out.println("you got a " + roll +" discard a meld:");
				System.out.println(" ");
				
				if (mainDeck.size() > roll){
					Deck delt = mainDeck.deal(roll);
					playerDeck.addAll(delt);
				} else{
					playerDeck.addAll(mainDeck);
				}
				
				//used Utils.readNumber to make sure integer is valid 
				boolean userInput = true;
				playerDeck.print();
				while (userInput){
					System.out.println(" ");
					Deck discardCards = Utils.readCards("Enter your cards:");
					
					if (discardCards.isKind() || discardCards.isSeq()){
						playerDeck.removeAll(discardCards);
						System.out.println("Removed, would you like to discard more?");
						userInput = Utils.readYesOrNo("Yes or No?");
						playerDeck.print();
					} else{
						System.out.println("Not a sequence or meld, would you like to discard more?");
						userInput = Utils.readYesOrNo("Yes or No?");
						playerDeck.print();
					}
				}

			}
			rounds ++; 
		} 
		System.out.println(rounds + " were played.");
		return rounds; 
	}
}