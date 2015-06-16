package designpatterns.chainOfResponsibility.handler;

class SchoolMasterHandler extends AbstractHandler {

	public SchoolMasterHandler(int state) {
		super(state);
	}

	@Override
	protected void processRequest(Student student) {
		System.out.println("School Master receives the request '" + student.getMessage()+ "', comment: I agree");
	}

}
