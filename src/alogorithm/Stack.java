package alogorithm;

class Stack {

	private int[] data;
	private int top;

	public Stack(int[] data, int top) {
		super();
		this.data = data;
		this.top = top;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public int[] getData() {
		return data;
	}

	
}
