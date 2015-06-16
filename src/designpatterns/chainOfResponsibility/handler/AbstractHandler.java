package designpatterns.chainOfResponsibility.handler;

abstract class AbstractHandler implements IHandler{

	protected int state;
	protected IHandler nextHanlder;

	protected AbstractHandler(int state) {
		super();
		this.state = state;
	}

	protected abstract void processRequest(Student student);

	@Override
	public void handleRequest(Student student) {
		if (student!=null){
			if (this.state==student.getState()){
				this.processRequest(student);
			}else{
				if (this.nextHanlder!=null){
					System.out.println("the request is not related to my level, submitting to my colleague");
					this.nextHanlder.handleRequest(student);
				}
			}
		}
	}

	@Override
	public void setNextHandler(IHandler nextHanlder) {
		this.nextHanlder=nextHanlder;
	}
	
	
}
