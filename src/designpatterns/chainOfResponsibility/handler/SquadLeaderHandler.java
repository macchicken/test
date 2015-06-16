package designpatterns.chainOfResponsibility.handler;

class SquadLeaderHandler extends AbstractHandler {

	public SquadLeaderHandler(int state) {
		super(state);
	}

	@Override
	protected void processRequest(Student student) {
		System.out.println("SquadLeader receives the request '" + student.getMessage()+ "', comment: I agree");
	}

}
