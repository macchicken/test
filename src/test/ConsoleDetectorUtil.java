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
                throw new Exception("指令长度不能为0");  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        this.command = command;  
    }  
  
    public boolean readInputStreamWithTimeout() {  
        boolean result = true;  
        System.out.println("等待控制台输入指令(" + command + "), 开始初始化数据库操作:");  
        //定义指令长度.  
        byte[] consoleCommandByte = new byte[command.length()];  
        //获取从控制台输入的指令长度.  
        int readLength = 0;  
        try {  
            //读取数据偏移量.  
            int bufferOffset = 0;  
            //计算过期时间.  
             long maxTimeMillis = System.currentTimeMillis() + timeoutMillis;  
             //获取控制台输入流.  
             InputStream is = System.in;  
             //轮询控制台,获取控制台在timeoutMillis时间内输入的指令.  
              while (System.currentTimeMillis() < maxTimeMillis && bufferOffset < command.length()) {   
                  //重点: 将控制台输入的指令写进字节数组.  
                  readLength = Math.min(is.available(), command.length() - bufferOffset);   
                  int readResult = is.read(consoleCommandByte, bufferOffset, readLength);  
                  bufferOffset += readResult;  
             }  
            //判断在timeoutMillis时间内从控制台输入的指令是否为command.  
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
            System.out.println("ConsoleDetectorUtil出现未知异常" + e.toString());  
        }  
        return result;  
    }  
}
