package test.element;
class A{
    static{
        System.out.print("1");
    }
    public A(){
        System.out.print("2");
    }
}
class B extends A{
    static{
        System.out.print("a");
    }
    public B(){
        System.out.print("b");
    }   
}


class  C {
    int  a=1;
    double  d=2.0;
    public C(){
        System.out.println("Class A: a="+a +"\td="+d);
    }
}
class D extends C{
    float  a=3.0f;               
    String  d="Java program.";  
    public D(){ 
        super( );      
        System.out.println("Class B:  a="+a +"\td="+d);
    }
}

public class Hello{
    private static A ab;
    public static String str= "BEA";
    public static String str1= "abcabca";
    static void modify( String str) {
    	   str.replace( 'A', 'E');
    	   str.toLowerCase();
    	   str+= "B";
    	 }
	public static void main(String[] ars){
        int size=Integer.parseInt("10000");
		ab = new B(); 
		System.out.println("--------------");
		
		System.out.println(size*20);
		ab = new B(); 
		C  a=new C();
		C  b=new D();

		modify( str);
		System.out.println(str);
		System.out.println(str1.lastIndexOf('b'));
		 for(int a1 = 3; a1 < 100; a1 += 3 ){
				for(int a2 = 1; a2 < (100 - a1 / 3) / 5; a2++){
				int a3 = (100 - a1 / 3 - a2 * 5) / 3;
				int temp = (100 - a1 / 3 - a2 * 5) % 3;
				if(temp == 0 && a1 + a2 + a3 == 100){
				System.out.println("\n公鸡：" + a2 + "只，母鸡：" + a3 + "只，小鸡：" + a1 + "只");
				}
				}
				}
		    }
			
			
}
