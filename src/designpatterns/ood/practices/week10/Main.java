package designpatterns.ood.practices.week10;

import designpatterns.ood.practices.week10.serivce.Caretaker;
import designpatterns.ood.practices.week10.store.Originator;

class Main {

	public static void main(String[] args) {
		Caretaker ct=new Caretaker();
		Originator o=new Originator();
		ct.saveHistory(o.createMemento("state-1", 1));
		System.out.println(ct.readHistory(0));
		Entry dir=new Directory("usr");
		Entry hc105=new Directory("hc105");
		Entry ood=new Directory("ood");
		Entry week10=new Directory("week10");
		Entry file1=new File("file1.txx",10);
		Entry file2=new File("file2.txx",20);
		System.out.println("size of this entry: " +dir.getSize());
		try {
			dir.add(hc105);
			dir.add(ood);
			ood.add(week10);
			hc105.add(file1);
			week10.add(file2);
		} catch (FileTreatmentException e) {
			e.printStackTrace();
		}
		System.out.println("size of this entry: " +dir.getSize());
		dir.printList();
		ood.printFullPath();
		week10.printFullPath();
		file1.printFullPath();
		file2.printFullPath();
	}

}
