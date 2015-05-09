package designpatterns.command;

abstract class Command {

	Point p;
	Point oldP;

	public Command(Point p, Point oldP) {
		super();
		this.p = p;
		this.oldP = oldP;
	}

	public Point getPoint(){return p;}
	public abstract void execute();
	public abstract void undo();
}
