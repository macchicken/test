package designpatterns.factory.simplefactory;

public class Magnate {

	public static void main(String args[]){
		try {
			Car car = Driver.driverCar("bmw");
			car.drive();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
