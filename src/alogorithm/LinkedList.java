package alogorithm;

import java.util.Arrays;

class LinkedList {

	private int[] data;
	private int[] right;
	private int tail;
	
	public LinkedList(int[] data, int[] right, int tail) {
		super();
		this.data = data;
		this.right = right;
		this.tail=tail;
	}

	public int[] getData() {
		return data;
	}

	public int[] getRight() {
		return right;
	}

	public int getTail() {
		return tail;
	}

	public void setTail(int tail) {
		this.tail = tail;
	}

	@Override
	public String toString() {
		return "LinkedList [data=" + Arrays.toString(data) + ", right="
				+ Arrays.toString(right) + ", tail=" + tail + "]";
	}

	
}
