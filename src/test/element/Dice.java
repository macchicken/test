package test.element;

import java.util.Random;

public class Dice {

	private final static int maxValue=7;
	private int topValue=1;
	private int bottomValue=maxValue-topValue;
	private Random roll = new Random();
	
	public Dice() {
		roll();
	}


	public void roll() {
		topValue=roll.nextInt(maxValue-1);
		if (topValue==0){topValue++;}
		bottomValue=calBottom(topValue);
	}


	public int getTop() {
		return topValue;
	}


	public int getBottom() {
		return bottomValue;
	}
	
	private int calBottom(int top){
		return maxValue-top;
	}
}
