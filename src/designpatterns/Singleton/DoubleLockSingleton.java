package designpatterns.Singleton;

/**
 * 
 * @author Barry
 * effect only after 1.5
 */
public class DoubleLockSingleton {

	private volatile static DoubleLockSingleton singleton;

	private DoubleLockSingleton() {}

	public static DoubleLockSingleton getSingleton() {
		if (singleton!=null){return singleton;}
		synchronized (DoubleLockSingleton.class) {
			if (singleton == null) {
				System.out.println("Creating new singleton");
				singleton = new DoubleLockSingleton();
			} else {
				System.out.println("Attempting to create an existing singleton. Existing singleton returned.");
			}
			return singleton;
		}
	}
}
