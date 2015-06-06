package designpatterns.ood.practices.week10;

import designpatterns.ood.practices.week10.serivce.Caretaker;
import designpatterns.ood.practices.week10.store.Originator;

class Main {

	public static void main(String[] args) {
		Caretaker ct=new Caretaker();
		Originator o=new Originator();
		ct.saveHistory(o.createMemento("state-1", 1));
		System.out.println(ct.readHistory(0));
	}

}
