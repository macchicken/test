package designpatterns.chainOfResponsibility.handler;


public class ProcessHandlerFacade {

	private IHandler current;
	private IHandler first;
	private String packageName;
	
	private static class ProcessHandlerFacadeHolder {
		private static final ProcessHandlerFacade INSTANCE = new ProcessHandlerFacade();
	}

	private ProcessHandlerFacade() {packageName=this.getClass().getPackage().getName();}

	public static ProcessHandlerFacade getInstance() {
		return ProcessHandlerFacadeHolder.INSTANCE;
	}
	
	public void addHandler(String handler){
		IHandler h=null;
		try {
			HandlerMapping hm=HandlerMapping.valueOf(handler);
			h=(IHandler) (Class.forName(packageName+"."+hm.toString())).getDeclaredConstructor(int.class).newInstance(hm.getLevel());
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			return;
		}
		if (first==null){first=h;}
		if (current==null){current=h;}
		else{
			current.setNextHandler(h);
			current=h;
		}
	}

	public void resetHandler(){
		first=null;
		current=null;
	}
	
	public void sendRequest(Student student){
		if (first!=null){
			first.handleRequest(student);
		}
	}

	@Override
	public String toString() {
		return "ProcessHandlerFacade [current=" + current.getClass().getName() + ", first=" + first.getClass().getName() + "]";
	}


}
