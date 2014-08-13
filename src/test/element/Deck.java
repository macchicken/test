package test.element;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	
//	private HashMap<Integer,Card> cards = null;
	private ArrayList<Card> cards = null;
//	private Random deal = null;
	private int pos;
	
	public Deck() {
//		cards = new HashMap<Integer,Card>(52);
		cards = new ArrayList<Card>(52);
//		deal = new Random();
		pos = 0 ;
		genCards();
	}

	public Card dealCard() {
//		int pos = deal.nextInt(51);
//		Card temp=cards.get(pos);
//		while(temp.isDealed()){
//			pos = deal.nextInt(51);
//			temp=cards.get(pos);
//		}
//		temp.setDealed(true);
//		cards.put(pos, temp);
//		return temp;
		Card temp = cards.get(pos);
		pos+=1;
		return temp;
	}

	private void genCards(){
//		int temp=0;
		for (int i=0;i<13;i++){
//			temp=i*4;
//			cards.put(temp,new Card(i+1,"A"));
//			cards.put(temp+1,new Card(i+1,"B"));
//			cards.put(temp+2,new Card(i+1,"C"));
//			cards.put(temp+3,new Card(i+1,"D"));
			cards.add(new Card(i+1,"A"));
			cards.add(new Card(i+1,"B"));
			cards.add(new Card(i+1,"C"));
			cards.add(new Card(i+1,"D"));
		}
		Collections.shuffle(cards);
	}
	

}
