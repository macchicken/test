package codingbat;

public class String1 {
	
	private static String1 my=new String1();
	
	public static String1 getInstance(){
		return my;
	}

	private String left2(String str){
		if (str!=null&&str.length()>2){
			String result=str.substring(2);
			result+=str.substring(0, 2);
			return result;
		}
		return str;
	}
	
	//test method
	public void testleft2(){
		System.out.println("lloHe".equals(left2("Hello")));
		System.out.println("vaja".equals(left2("java")));
		System.out.println("Hi".equals(left2("Hi")));
	}

}
