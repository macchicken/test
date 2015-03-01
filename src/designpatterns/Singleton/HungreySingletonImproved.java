package designpatterns.Singleton;

public class HungreySingletonImproved {

	private static HungreySingletonImproved instance = null;
    static {
    	instance = new HungreySingletonImproved();
    }

    private HungreySingletonImproved (){}

	public static HungreySingletonImproved getInstance() {
		return HungreySingletonImproved.instance;
	}
}
