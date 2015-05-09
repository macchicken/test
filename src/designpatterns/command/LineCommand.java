package designpatterns.command;

class LineCommand extends Command {

	public LineCommand(Point p, Point oldP) {
		super(p, oldP);
	}

	@Override
	public void execute() {
		System.out.println("execute a line command to draw a line from "+oldP+" to "+p);
	}

	@Override
	public void undo() {
		System.out.println("undo a line command to remove a line from "+p+" to "+oldP);
	}

}
