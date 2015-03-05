package designpatterns.bridge;

public class ModernClient {


	public static void main(String[] args) {
		ModernConnectionController connection=ModernTools.getConnectionType(ModernTools.getModern("ErniesModern"));
		if (connection!=null) {
			connection.Dial();
			connection.Send();
			connection.Receive();
			connection.Hangup();
		}
	}

}
