package test.app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import com.thoughtworks.xstream.*;

import test.element.Student;

public class testXmljavaBean {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Student st=new Student();
		Student stNew=new Student(); 
		st.setAge(26);
		st.setStudentName("barry");
		ArrayList belongings=new ArrayList();
		belongings.add("car");
		belongings.add(1);
		st.setBelongings(belongings);
		XStream xs = new XStream();
		String filename="D:/hc105/Student.xml";
		try {
			 FileOutputStream fs = new FileOutputStream(filename);
			 xs.toXML(st, fs);
			 } catch (FileNotFoundException e1) {
			 e1.printStackTrace();
		 }
			 /*try {
				FileInputStream fis = new FileInputStream(filename);
				 xs.fromXML(fis, stNew);
				 System.out.println(stNew.getAge());
				 System.out.println(stNew.getStudentName());
				 System.out.println(stNew.getBelongings());
			 } catch (FileNotFoundException e) {
				e.printStackTrace();
			}*/
	}
}
