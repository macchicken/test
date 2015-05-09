package designpatterns.command;

class Clinet {

	public static void main(String[] args) {
		Draw td=new Draw();
		td.moveTo(1, 1);
		td.lineTo(2, 2);
		td.undo();
		td.undo();
	}

}
