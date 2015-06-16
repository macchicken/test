package designpatterns.chainOfResponsibility.handler;

public final class Student {

	private int state;
	private String message;

	public Student(int state,String message) {
		super();
		this.state = state;
		this.message=message;
	}

	int getState() {
		return state;
	}

	String getMessage() {
		return message;
	}
	
	
}
