package designpatterns.chainOfResponsibility.handler;

class TeacherHandler extends AbstractHandler {

	protected TeacherHandler(int state) {
		super(state);
	}

	@Override
	protected void processRequest(Student student) {
		System.out.println("Teacher receives the request '" + student.getMessage()+ "', comment: I agree");
	}

}
