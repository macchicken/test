package designpatterns.ood.practices.week10.serivce;

import java.util.ArrayList;
import java.util.List;

import designpatterns.ood.practices.week10.store.Memento;

public class Caretaker {

	private List<Memento> history=new ArrayList<Memento>();
	
	public void saveHistory(Memento m){
		history.add(m);
	}
	
	public Memento readHistory(int index){
		return history.get(index);
	}

}
