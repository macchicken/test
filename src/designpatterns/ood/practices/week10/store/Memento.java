package designpatterns.ood.practices.week10.store;

public class Memento {

	private String state;
	private int number;

	Memento(String state, int number) {
		this.state = state;
		this.number = number;
	}

	String getState() {
		return state;
	}

	int getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return "Memento [state=" + state + ", number=" + number + "]";
	}

	
}
