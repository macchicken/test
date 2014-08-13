package test.element;

import java.util.List;

public class Student {
	private int age;
	private String studentName;
	private List<?> belongings;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName=studentName;
	}

	public List<?> getBelongings() {
		return belongings;
	}

	public void setBelongings(List<?> belongings) {
		this.belongings = belongings;
	}
	
}
