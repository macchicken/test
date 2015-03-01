package designpatterns.Singleton;

/**
 * 
 * @author Barry
 * instance can only be initialise while calling the getIntance of inner holder
 */
public class SingletonInternal {

	private static class SingletonHolder {
		private static final SingletonInternal INSTANCE = new SingletonInternal();
	}

	private SingletonInternal() {}

	public static final SingletonInternal getInstance() {
		return SingletonHolder.INSTANCE;
	}
}
