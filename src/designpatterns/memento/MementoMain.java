package designpatterns.memento;

import java.util.Random;

class MementoMain {

	public static void main(String[] args) {
		Random ran=new Random();
		OriginalOwner or=new OriginalOwner();
		Caretaker ct=new Caretaker();
		or.setState("state-or-1");
		ct.addMemento(or.saveToMemento());
		for (int i=0;i<10;i++){
			or.setState("state-or-"+ran.nextInt(10));
			System.out.println(or);
		}
		System.out.println(or);
		or.restoreFromMemento(ct.getMemento(0));
		System.out.println(or);
	}

}
