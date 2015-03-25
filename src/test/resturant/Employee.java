package test.resturant;

public class Employee {

	public String name;
	protected double salary;
	private String ssnum;
	String dphone;
	
	public double work(double hours){
		return salary*hours;
	}

	public Employee() {
		super();
	}

	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public String getSsnum() {
		return ssnum;
	}

	public void setSsnum(String ssnum) {
		this.ssnum = ssnum;
	}

	public String getDphone() {
		return dphone;
	}

	public void setDphone(String dphone) {
		this.dphone = dphone;
	}
}
