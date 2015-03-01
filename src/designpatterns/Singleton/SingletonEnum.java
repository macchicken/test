package designpatterns.Singleton;

/**
 * 
 * @author Barry
 * only after 1.5, not only the multi thread safe but also avoid create new obj by anti-serialise
 */
public enum SingletonEnum {

	INSTANCE;
	public void whateverMethod() {}
}
