package designpatterns.command;

import java.util.Iterator;
import java.util.Vector;

public class Draw {

	private Vector<Command> history=new Vector<Command>();
	private int current;
	
	public Draw() {
		super();
		System.out.println("start at origin");
		history.add(new MoveCommand(new Point(0,0),new Point(0,0)));
	}

	public void moveTo(int x,int y){
		addHistory(new MoveCommand(new Point(x,y),getCurrentCommand().getPoint()));
	}
	
	public void lineTo(int x,int y){
		addHistory(new LineCommand(new Point(x,y),getCurrentCommand().getPoint()));
	}
	

	public void undo(){
		if (current>0){
			getCurrentCommand().undo();
			current--;
		}
	}

	public void redo(){
		if (redoable()){
			getCurrentCommand().execute();
			current++;
		}
	}

	private void addHistory(Command cmd){
		if (redoable()){
			Iterator<Command> it=history.iterator();
			int count=0;
			while(it.hasNext()){
				if (count<current+1){it.next();count++;}
				else{it.remove();}
			}
		}
		history.add(cmd);
		current++;
		cmd.execute();
	}

	private Command getCurrentCommand(){
		return history.get(current);
	}

	private boolean redoable(){
		return current<history.size();
	}
}
