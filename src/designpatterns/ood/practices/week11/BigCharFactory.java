package designpatterns.ood.practices.week11;

import java.util.HashMap;

public class BigCharFactory {

	// manage already made BigChar instance.
	private HashMap<String, BigChar> pool = new HashMap<String, BigChar>();

	// Singleton design pattern.
	private static BigCharFactory singleton = new BigCharFactory();

	private BigCharFactory() {}

	// create the only instance.
	public static BigCharFactory getInstance() {
		return singleton;

	}

	// generate BigChar instances (these are shared).

	public synchronized BigChar getBigChar(char charname,boolean shared) {
		BigChar bc = (BigChar) pool.get("" + charname);
		if (shared){
			if (bc == null) {
				bc = new BigChar(charname); // generate the actual BigChar instance.
				pool.put("" + charname, bc);
			}
		}else{
			bc = new BigChar(charname); // generate the actual BigChar instance.
			pool.put("" + charname, bc);
		}
		return bc;
	}

}
