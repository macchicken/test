package designpatterns.facade;

public class Camera extends SwitchDevice{

	public void Rotate(int degrees){
		System.out.println("Rotating the camera by "+degrees+" degrees");
	}
}
