public class Game{

	//Declaring private instance variables to be used in play method 
	private Deck mainDeck;
	private Die die; 
	private Deck playerDeck; 

	/**
    * Constructor for GAme class that creates new starting deck and creates new die/rolls it
    *@param ranks the number of ranks to be played with from 3-99
    */
	
	public Game (int ranks){
		mainDeck = new Deck(ranks);
		die = new Die();
	}

	/**
    * A method that simulates the game of rummy 
    * Uses objects of classes Deck, Card, and Die 
    * Counts the number of rounds to see how long it takes to finish 
    */


	public void play(){
		playerDeck = new Deck();
		mainDeck.shuffle();

		Deck cardsAdded = mainDeck.deal(7);
		playerDeck.addAll(cardsAdded);

		int rounds = 0;
		int roll = 0;
		playerDeck.print();
		System.out.println(" ");
		System.out.print("You roll the die... ");
		
		while (playerDeck.hasCards()){
			roll = die.roll();

			if (mainDeck.size() == 0){
				roll = 1;
			}
			
			if (roll == 1){
				System.out.println("");
				System.out.println("You got a 1, please discard a card: ");
				
				boolean condition = true; 
				playerDeck.print();
				System.out.println("");

				while (condition){
					Card discard = Utils.readCard();
				
					if (playerDeck.contains(discard)){
						playerDeck.remove(discard);
						System.out.println("Removed");
						System.out.println(" ");
						condition = false;
				
					} else{
						System.out.println("Not a card in your hand. Please enter a valid card.");
						System.out.println(" ");
					}
				}
			

			}else{
				System.out.println("You got a " + roll +", discard a meld:");
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
					
					if (playerDeck.containsAll(discardCards)){
						
						if (discardCards.isKind()){
							playerDeck.removeAll(discardCards);
							System.out.println("Removed, would you like to discard more?");
							userInput = Utils.readYesOrNo("Yes or No?");
							playerDeck.print();

						} else if (discardCards.isSeq()){
							playerDeck.removeAll(discardCards);
							System.out.println("Removed, would you like to discard more?");
							userInput = Utils.readYesOrNo("Yes or No?");
							playerDeck.print();

						} else {
							System.out.println("Not a sequence or meld, would you like to discard more?");
							userInput = Utils.readYesOrNo("Yes or No?");
							playerDeck.print();
							System.out.println("");
						}

					} else{
						System.out.println("The selected card(s) are not in your hand.");
						System.out.println("Would you like to discard more?");
						userInput = Utils.readYesOrNo("Yes or No?");

					}

				}

			}
			rounds ++; 
		} 
		System.out.println(" ");
		System.out.println(rounds + " rounds were played.");
	}
}