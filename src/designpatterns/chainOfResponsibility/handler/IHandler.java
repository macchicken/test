package designpatterns.chainOfResponsibility.handler;

interface IHandler {

	public void handleRequest(Student student);
	public void setNextHandler(IHandler nextHanlder);
	
}
