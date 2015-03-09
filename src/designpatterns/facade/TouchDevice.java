package designpatterns.facade;

public class TouchDevice {

	public void Activate(String name)
	  {
	    System.out.println("Activating the "+ name+".");
	  }

	  public void Deactivate(String name)
	  {
	    System.out.println("Deactivating the "+ name+".");
	  }
}
