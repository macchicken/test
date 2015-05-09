package designpatterns.memento;

import java.util.ArrayList;
import java.util.List;


class Caretaker {

	private List<OriginalOwner.Memento> savedStates = new ArrayList<OriginalOwner.Memento>();
	
	public void addMemento(OriginalOwner.Memento mem){
		System.out.println("save a memento to a storage manipulated by Caretaker "+mem);
		savedStates.add(mem);
	}
	
	public OriginalOwner.Memento getMemento(int index){
		System.out.println("get a state from a storage manipulated by Caretaker index "+index);
		return savedStates.get(index);
	}

}
