package designpatterns.bridge;

public class ModernTools {

	public static ModernImplementation getModern(String modernName){
		if ("ErniesModern".equals(modernName)){
			return new ErniesModern();
		}else if ("HayesModern".equals(modernName)){
			return new HayesModern();
		}else if ("USRoboticsModern".equals(modernName)){
			return new USRoboticsModern();
		}
		return null;
	}
	
	public static ModernConnectionController getConnectionType(ModernImplementation modern){
		if (modern!=null){
		if (modern instanceof ErniesModern){
			return new DialModernController(modern,modern,modern,modern);
		}else if (modern instanceof HayesModern){
			return new DialModernController(modern,modern,modern,modern);
		}else if (modern instanceof USRoboticsModern){
			return new DedModernController(modern,modern,modern,modern);
		}}
		return null;
	}
}
