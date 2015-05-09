package designpatterns.memento;

class Client {

	public static void main(String[] args) {
		Caretaker caretaker = new Caretaker();
		OriginalOwner originator = new OriginalOwner();
		originator.setState("State1");
		originator.setState("State2");
		caretaker.addMemento(originator.saveToMemento());
		originator.setState("State3");
		caretaker.addMemento(originator.saveToMemento());
		originator.setState("State4");
		originator.restoreFromMemento(caretaker.getMemento(1) );
	}

}
