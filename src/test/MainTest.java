package test;

public class MainTest {

	public static void main(String[] args) {  
        ConsoleDetectorUtil cdu = new ConsoleDetectorUtil();  
        String command = "yes";  
        cdu.setCommand(command);  
        cdu.setTimeoutMillis(5000);  
        boolean result = cdu.readInputStreamWithTimeout();  
        if(result == true) {  
            System.out.println("���ܿ���ָ̨��(" + command + "), ��ʼ��ʼ�����ݿ����!");  
            //ʡ��ҵ�����: ��ʼ�����ݿ�.  
        } else {  
            System.out.println("δ���ܿ���ָ̨��(" + command + "), ���Գ�ʼ�����ݿ����!");  
        }  
    }

}
