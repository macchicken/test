package designpatterns.command;

class MoveCommand extends Command {

	public MoveCommand(Point p, Point oldP) {
		super(p, oldP);
	}

	@Override
	public void execute() {
		System.out.println("execute move command to move a point from "+oldP+" to "+p);
	}

	@Override
	public void undo() {
		System.out.println("undo a move command to move a point from "+p+" to "+oldP);
	}

}
