package designpatterns.Singleton;

/**
 * 
 * @author Barry
 * thread safe, but low in performance due to synchronisation on 99% of time when actually not needed 
 */
public class LazySingletonImproved {

	private static LazySingletonImproved instance;
	private LazySingletonImproved (){}

	public static synchronized LazySingletonImproved getInstance() {
		if (instance == null) {
			instance = new LazySingletonImproved();
		}
		return instance;
	}

}
