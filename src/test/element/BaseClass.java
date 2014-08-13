package test.element;

public class BaseClass {

	public BaseClass(){
		System.out.println("create base");
		init();
	}
	protected void init() {
       System.out.println("in base init");
		}
	
}
