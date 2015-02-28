package test.element;

import java.util.List;

public class Student extends BaseObject{
	private int age;
	private String studentName;
	private List<?> belongings;
	
	public Student() {
		super();
	}

	public Student(int age, String studentName, List<?> belongings) {
		super();
		this.age = age;
		this.studentName = studentName;
		this.belongings = belongings;
	}

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
