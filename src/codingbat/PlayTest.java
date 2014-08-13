package codingbat;
import java.lang.reflect.Method;


public class PlayTest {
	
	public static void runTest(String className,String methodName) throws Exception{
		Class<?> c=Class.forName(className);
		Method testMethod=c.getMethod("test"+methodName, null);
		testMethod.setAccessible(true);
		System.out.println("test "+methodName);
		testMethod.invoke(c.newInstance(), null);
	}
	
}
