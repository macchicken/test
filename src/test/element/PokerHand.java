package test.element;

import java.util.LinkedList;

public class PokerHand {

	private LinkedList<Card> hands = new LinkedList<Card>();
	
	public void replace(int currentCard, Card dealCard) {
		hands.set(currentCard-1, dealCard);
	}

	public Card getCard(int card) {
		return hands.get(card-1);
	}

	public void print() {
		for (Card onehand : hands){
			onehand.print();
		}
		System.out.println();
	}

	public boolean beats(PokerHand player2) {
		int totalRank_1=0;
		int totalRank_2=0;
		LinkedList<Card> hands_2=player2.getHands();
		for (Card oneCard:hands){
			totalRank_1+=oneCard.getRank();
		}
		for (Card oneCard:hands_2){
			totalRank_2+=oneCard.getRank();
		}
		return totalRank_1>totalRank_2;
	}

	public void add(Card dealCard) {
		hands.add(dealCard);
	}

	public LinkedList<Card> getHands() {
		return hands;
	}

}
