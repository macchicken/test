package test;

public class MainTest {

	public static void main(String[] args) {  
        ConsoleDetectorUtil cdu = new ConsoleDetectorUtil();  
        String command = "yes";  
        cdu.setCommand(command);  
        cdu.setTimeoutMillis(5000);  
        boolean result = cdu.readInputStreamWithTimeout();  
        if(result == true) {  
            System.out.println("接受控制台指令(" + command + "), 开始初始化数据库操作!");  
            //省略业务操作: 初始化数据库.  
        } else {  
            System.out.println("未接受控制台指令(" + command + "), 忽略初始化数据库操作!");  
        }  
    }

}
