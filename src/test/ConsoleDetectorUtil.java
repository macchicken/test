package test;

import java.io.InputStream;

public class ConsoleDetectorUtil {

	private int timeoutMillis;  
    
    private String command;  
      
    public void setTimeoutMillis(int timeoutMillis) {  
        this.timeoutMillis = timeoutMillis;  
    }  
      
    public void setCommand(String command) {  
        if(command.length() <= 0) {  
            try {  
                throw new Exception("ָ��Ȳ���Ϊ0");  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        this.command = command;  
    }  
  
    public boolean readInputStreamWithTimeout() {  
        boolean result = true;  
        System.out.println("�ȴ�����̨����ָ��(" + command + "), ��ʼ��ʼ�����ݿ����:");  
        //����ָ���.  
        byte[] consoleCommandByte = new byte[command.length()];  
        //��ȡ�ӿ���̨�����ָ���.  
        int readLength = 0;  
        try {  
            //��ȡ����ƫ����.  
            int bufferOffset = 0;  
            //�������ʱ��.  
             long maxTimeMillis = System.currentTimeMillis() + timeoutMillis;  
             //��ȡ����̨������.  
             InputStream is = System.in;  
             //��ѯ����̨,��ȡ����̨��timeoutMillisʱ���������ָ��.  
              while (System.currentTimeMillis() < maxTimeMillis && bufferOffset < command.length()) {   
                  //�ص�: ������̨�����ָ��д���ֽ�����.  
                  readLength = Math.min(is.available(), command.length() - bufferOffset);   
                  int readResult = is.read(consoleCommandByte, bufferOffset, readLength);  
                  bufferOffset += readResult;  
             }  
            //�ж���timeoutMillisʱ���ڴӿ���̨�����ָ���Ƿ�Ϊcommand.  
            char[] commandByte = command.toCharArray();  
            if(readLength > 0) {  
                for(int i = 0; i < consoleCommandByte.length; i++) {  
                    byte b = consoleCommandByte[i];  
                    char c = (char)b;  
                    if(c != commandByte[i]) {  
                        result = false;  
                        break;  
                    }  
                }  
            } else {  
                result = false;  
            }  
        } catch (Exception e) {  
            System.out.println("ConsoleDetectorUtil����δ֪�쳣" + e.toString());  
        }  
        return result;  
    }  
}
