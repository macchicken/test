package test.element;

public class SubClass extends BaseClass {
	int i=1024;
	String s="13 leaf";
	public SubClass() {
		System.out.println("create sub");
			init();
	}
	
	protected void init() {
		assert this!=null;
		System.out.println("now the working class is:"+this.getClass().getSimpleName());
		System.out.println("in SubClass");
		/////////////great line/////////////////
		System.out.println(i);
		System.out.println(s);
	    }


}
