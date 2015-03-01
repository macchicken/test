/**
 * 
 */
package designpatterns.factory.simplefactory;

/**
 * @author Barry
 * factory role class
 */
public class Driver {

	public static Car driverCar(String s)throws Exception{
		if(s.equalsIgnoreCase("Benz")) return new Benz(); 
		else if(s.equalsIgnoreCase("Bmw")) return new Bmw();
		throw new Exception(" we don't have this car, sir ");
	}
}
