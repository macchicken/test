package designpatterns.ood.practices.week10.store;

public class Originator{
	
	public Memento createMemento(String state,int number){
		return new Memento(state,number);
	}

	public void readMemento(Memento m){
		System.out.println(m.getState());
		System.out.println(m.getNumber());
	}
	

}

