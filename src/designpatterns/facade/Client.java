package designpatterns.facade;

public class Client {

	public static void main(String[] args) {
		SecurityFacade security = new SecurityFacade();
		security.Activate();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		security.Deactivate();

	}

}
