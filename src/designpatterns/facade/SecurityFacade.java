package designpatterns.facade;

public class SecurityFacade {

	private Camera camera1,camera2;
	private Light light1,light2,light3;
	private Sensor sensor;
	private Alarm alarm;

	public SecurityFacade() {
		super();
		this.camera1 = new Camera();
		this.camera2 = new Camera();
		light1 = new Light();
		light2 = new Light();
		light3 = new Light();
		this.sensor = new Sensor();
		this.alarm = new Alarm();
	}
	
	public void Activate()
	{
	    camera1.TurnOn("camera1");
	    camera2.TurnOn("camera2");
	    light1.TurnOn("light1");
	    light2.TurnOn("light2");
	    light3.TurnOn("light3");
	    sensor.Activate("sensor");
	    alarm.Activate("alarm");
	}
	public void Deactivate()
	{
		camera1.TurnOff("camera1");
		camera2.TurnOff("camera2");
		light1.TurnOff("light1");
		light2.TurnOff("light2");
		light3.TurnOff("light3");
		sensor.Deactivate("sensor");
		alarm.Deactivate("alarm");
	}
	
}
