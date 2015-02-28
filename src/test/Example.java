package test;

import java.lang.reflect.Field;

import test.element.Constants;
import test.element.Student;

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
		String newId= java.util.UUID.randomUUID().toString();
		System.out.println(newId=newId.replaceAll("-", ""));
		System.out.println(newId.length());
		Student stemp=new Student(3,"Barry",new java.util.ArrayList<String>());
		Student stempto=new Student();
		Field[] fields=stemp.getClass().getDeclaredFields();
		try {
			Field[] fields2=stemp.getClass().getSuperclass().getDeclaredFields();
			System.out.println(fields2[0]);
			fields2[0].setAccessible(true);
			System.out.println(fields2[0].get(stemp));
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (fields!=null&&fields.length>0){
			System.out.println("fields stemp");
	    	for(Field fie : fields){
	    		fie.setAccessible(true);
	    		Object value = null;
				try {
					value = fie.get(stemp);
					if (value instanceof String){
						value=((String) value).replaceAll("\"", "");
					}
					Field tof=stempto.getClass().getDeclaredField(fie.getName());
					tof.setAccessible(true);
					tof.set(stempto, value);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (NoSuchFieldException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}
	    	}
	    }
		System.out.println(stempto.getAge());
		System.out.println(stempto.getStudentName());
		System.out.println(stempto.getBelongings());
		StringBuilder json = new StringBuilder();
		json.append("dsada},");
		json.delete(json.length()-1, json.length());
		System.out.println(json);
		Constants.YesNo[] testtemm=Constants.YesNo.values();
		for (Constants.YesNo i:testtemm){
			System.out.println(i.name().toLowerCase());
		}
	}

}
