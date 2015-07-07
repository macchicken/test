package alogorithm;

class Queue {

	private int head;
	private int tail;
	private int[] data;

	Queue(int head,int tail,int[] data){
		this.head=head;
		this.tail=tail;
		this.data=data;
	}

	int getHead() {
		return head;
	}
	void setHead(int head) {
		this.head = head;
	}
	int getTail() {
		return tail;
	}
	void setTail(int tail) {
		this.tail = tail;
	}
	int[] getData() {
		return data;
	}
	void setData(int[] data) {
		this.data = data;
	}


}
