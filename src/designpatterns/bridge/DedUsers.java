package designpatterns.bridge;

public class DedUsers {

	public static void main(String args[]){
		ModernConnectionController connection=ModernTools.getConnectionType(ModernTools.getModern("USRoboticsModern"));
		if (connection!=null) {
			connection.Dial();
			connection.Send();
			connection.Receive();
			connection.Hangup();
		}
	}
}
