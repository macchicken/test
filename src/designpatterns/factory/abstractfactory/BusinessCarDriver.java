package designpatterns.factory.abstractfactory;

public class BusinessCarDriver implements Driver {

	@Override
	public Car driverCar(String carBrandName) throws Exception{
		if ("bmw".equalsIgnoreCase(carBrandName)){return new BmwBusinessCar();}
		else if ("benz".equalsIgnoreCase(carBrandName)){return new BenzBusinessCar();}
		throw new Exception(" we don't have that business car, sir");
	}

}
