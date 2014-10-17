package test;

public class Example {
	
	private static String output="";
	void Example(int i){
		System.out.println("Int");
	}
	void Example(String s){
		System.out.println("String");
	}
	
	public static void foo(int i){
		try {
			if (i==1){throw new Exception();}
			output+="1";
		} catch (Exception e) {
			output+="2";
			return;
		}finally{
			output+="4";
		}
	}
	public static void main(String[] args) {
		foo(0);
		foo(0);
		System.out.println(output);
		int j=2;
		switch(j){
		case 2:System.out.println("two");
		case 2+1: System.out.println("three");break;
		default:System.out.println("va");break;
		}
		System.out.println(5.4+"3.2");
		int h=0xFFFFFFF1;
		int z=~h;
		System.out.println(z);
		System.out.println(h);
		Example t=new Example();
		char ch='y';
		t.Example(ch);
		Integer a=new Integer(100/10);
		Integer b=new Integer(100*10);
		System.out.println(a instanceof Integer);
		System.out.println(b instanceof Integer);
		Float f=new Float(100/10);
		Double d=new Double(100/10);
		System.out.println(f instanceof Float);
		System.out.println(d instanceof Double);
	}

}
