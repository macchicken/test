package designpatterns.factory.factorymethod;

public class Magnate {

	public static void main(String[] args) {
		Driver driver = new BenzDriver();
		Car car = driver.driverCar(); 
		car.drive();
	}

}
