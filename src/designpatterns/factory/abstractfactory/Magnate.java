package designpatterns.factory.abstractfactory;

public class Magnate {

	public static void main(String[] args) {
		try {
			Driver driver=new SportsCarDriver();
			Car car=driver.driverCar("benz");
			car.drive();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
