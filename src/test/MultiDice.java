package test;

import test.element.Dice;

public class MultiDice {

	private Dice [] myDice;
	private int max;

	  public MultiDice() {
		this(1);
	  }

	  public MultiDice(int n) { //Sets up dice by rolling it initially.
		myDice = new Dice[n];
		max = n-1;
		for (int i = 0; i<=max; i++)
			myDice[i] = new Dice();
	  }

	  public void roll() { //Rolls dice by random choice from 1-6
		for (int i = 0; i<=max; i++)
			myDice[i].roll();
	  }
	  public int getTop() { //Returns number on top side of dice
	  	int total = 0;
		for (int i = 0; i<=max; i++)
			total = total + myDice[i].getTop();
		return total;
		}

	  public int getBottom() { //Returns number on bottom of dice
	  	int total = 0;
		for (int i = 0; i<=max; i++)
			total = total + myDice[i].getBottom();
		return total;
		}

	public Dice[] getMyDice() {
		return myDice;
	}

}
