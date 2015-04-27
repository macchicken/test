package designpatterns.Singleton;

/**
 * 
 * @author Barry
 * instance can only be initialise while calling the getIntance of inner holder
 * Initialization on Demand Holder
 * Java Language Specification guarantes the class initialization phase to be serial,
 * so writing the static variable INSTANCE is in a serial operation 
 * if concurrent operations of writing the instance arrive,
 * those operations would return the same reference of the instance
 */
public class SingletonInternal {

	private static class SingletonHolder {
		private static final SingletonInternal INSTANCE = new SingletonInternal();
	}

	private SingletonInternal() {}

	public static SingletonInternal getInstance() {
		return SingletonHolder.INSTANCE;
	}
}
