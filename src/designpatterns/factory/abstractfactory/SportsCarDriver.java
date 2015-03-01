package designpatterns.factory.abstractfactory;

public class SportsCarDriver implements Driver {

	@Override
	public Car driverCar(String carBrandName) throws Exception{
		if ("bmw".equalsIgnoreCase(carBrandName)){return new BmwSportsCar();}
		else if ("benz".equalsIgnoreCase(carBrandName)){return new BenzSportsCar();}
		throw new Exception(" we don't have that sports car, sir ");
	}

}
