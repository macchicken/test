package designpatterns.visitor;

import java.util.Iterator;

public class ListVisitor extends Visitor {

	private String currentDir="";
	@Override
	public void visit(File file) {// called when you visit a file
		System.out.println(currentDir+"/"+file.getName());
	}

	@Override
	public void visit(Directory directory) {// called when it visit a folder
		System.out.println(currentDir + "/" + directory);
		String savedDir=currentDir;
		currentDir=currentDir+"/"+directory.getName();
		Iterator<Entry> it=null;
		try {
			it = directory.iterator();
		} catch (FileTreatmentException e) {
			e.printStackTrace();
			currentDir=savedDir;
			return;
		}
		while(it.hasNext()){
			Entry entry=it.next();
			entry.accept(this);
		}
		currentDir=savedDir;
	}

}
