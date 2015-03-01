package designpatterns.Singleton;

/**
 * 
 * @author Barry
 *  avoid multi thread problem by using classloader strategy,
 *  sometimes would initialise the instance by other method
 *  without calling the getInstance, cause the fail to lazy loading
 */
public class HungreySingleton {

	private final static HungreySingleton instance = new HungreySingleton();
    private HungreySingleton (){}

	public static HungreySingleton getInstance() {
		return HungreySingleton.instance;
	}
}
