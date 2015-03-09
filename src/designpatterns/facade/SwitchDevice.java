package designpatterns.facade;

public class SwitchDevice {

	public void TurnOn(String name){
		System.out.println("Turning on the "+name);
	}
	
	public void TurnOff(String name){
		System.out.println("Turning off the "+name);
	}
}
