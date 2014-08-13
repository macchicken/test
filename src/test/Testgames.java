package test;



import java.io.IOException;

import test.element.Card;
import test.element.Deck;
import test.element.Dice;
import test.element.PokerHand;

public class Testgames {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		diceGame();
		pokerGame();
	}
	
	
	private static void diceGame(){
		MultiDice mDice = new MultiDice(5);
		mDice.roll();
		Dice[] myDice = mDice.getMyDice();
		int size = myDice.length;
		for (int i=0;i<size;i++){
			System.out.print(myDice[i].getTop());
			System.out.print(" ");
			System.out.print(myDice[i].getBottom());
			System.out.print(" ");
		}
	}
	
	private static void pokerGame(){
		Deck myDeck = new Deck();

		// Create players
		PokerHand player1 = new PokerHand();
		PokerHand player2 = new PokerHand();

		//Loop for allowing each player to view and then change cards.
		for (int player = 1; player <= 2; player++) {
			PokerHand currentHand;

			// Select correct hand according to players turn.
			if (player == 1)
				currentHand = player1;
			else
				currentHand = player2;

			deal(myDeck, currentHand);

			System.out.println("Player " + player + " has the following hand");
			currentHand.print();

			changeCards(myDeck, currentHand);

			System.out.println("Player " + player + " now has the following hand");
			currentHand.print();
		}

		if (player1.beats(player2))
			System.out.println("Player 1 wins!");
		else
			System.out.println("Player 2 wins");
	}


	// Allows player to change cards by displaying and asking for each one
	static void changeCards(Deck myDeck, PokerHand currentHand) {
			for (int card = 1; card <= 5; card++) {
				Card currentCard = currentHand.getCard(card);

				System.out.println("Change the following card (y/n)?");
				currentCard.print();
				
				String input="";
				int c=0;
				try {
					while ((c=System.in.read())!='\n') {
						input+=(char)c;
						System.out.println(input);
						if ("y".equals(input)) {
							System.out.println("Dealing new card");
							currentHand.replace(card, myDeck.dealCard());
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}


	static void deal(Deck d, PokerHand h) {
		for (int i = 1;i<=5;i++)
			h.add(d.dealCard());
	}
	
}
