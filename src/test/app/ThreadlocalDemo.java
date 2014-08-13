package test.app;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import test.element.Student;

public class ThreadlocalDemo implements Runnable{

	/**
	 * @param args
	 */
	private final static ThreadLocal studentLocal = new ThreadLocal();
	 public static Logger logger;
	 private static String file_indexpath="D:\\hc105\\testlog\\";
	 private static String extend;
	public static void main(String[] args) throws SecurityException, IOException {
		// TODO Auto-generated method stub
		ThreadlocalDemo students_local=new ThreadlocalDemo();
		String file_name="threadlocallog";
		extend=(new SimpleDateFormat("yyyy-MM-dd")).format(Calendar.getInstance().getTime());
		file_name=file_indexpath+file_name+extend+".log";
		File file=new File(file_name);
		if (!file.exists()){
		file.createNewFile();
		}
		logger=Logger.getLogger("Mythreadlocallogger");
		FileHandler fh=new FileHandler(file_name,true);
		logger.addHandler(fh);
		logger.setLevel(Level.ALL);
		SimpleFormatter formatter = new SimpleFormatter();
	    fh.setFormatter(formatter);
		Thread thread_a=new Thread(students_local,"thread_a");
		Thread thread_b=new Thread(students_local,"thread_b");
		thread_a.start();
		thread_b.start();
	}
	public void run(){
		try {
			accessStudent();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void accessStudent() throws InterruptedException{
		long startTime = System.currentTimeMillis();
		String thread_name=Thread.currentThread().getName();
		logger.log(Level.ALL, thread_name+" is running");
		
		
		int age=((new Random()).nextInt(100));
		String name=(Integer.toString(age)).concat("john");
		logger.log(Level.ALL, thread_name+" about to set the age is "+age+" abount to set the name is "+name);
		Student student = getStudent();
		student.setAge(age);
		student.setStudentName(name);
		logger.log(Level.ALL,thread_name+" first read student age is "+student.getAge());
		logger.log(Level.ALL,thread_name+" first read student name is "+student.getStudentName());
		try {		
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e=new InterruptedException("unable to sleep current thread....");
			throw e;
		}
		
		logger.log(Level.ALL,thread_name+" second read student age is "+student.getAge());
		logger.log(Level.ALL,thread_name+" second read student name is "+student.getStudentName());
		long endTime = System.currentTimeMillis();
	    long spendTime = endTime - startTime;
	    logger.log(Level.ALL,"����ʱ�䣺"+spendTime +"����");
	}
	
	protected Student getStudent() {
		Student student = (Student)studentLocal.get();
		if(student == null) {
			student = new Student();
			studentLocal.set(student);
		}
		return student;
	}
	protected void setStudent(Student student) {
		studentLocal.set(student);
	}

}
/**
ThreadLocal��ʲô�أ���ʵThreadLocal������һ���̵߳ı���ʵ�ְ汾����������һ��Thread��
����thread local variable���ֲ߳̾���������Ҳ���������ΪThreadLocalVar���Ӻ��ʡ�
�ֲ߳̾�������ThreadLocal����ʵ�Ĺ��÷ǳ��򵥣�
����Ϊÿһ��ʹ�øñ������̶߳��ṩһ������ֵ�ĸ�����
��ÿһ���̶߳����Զ����ظı��Լ��ĸ�����������������̵߳ĸ�����ͻ��
���̵߳ĽǶȿ����ͺ���ÿһ���̶߳���ȫӵ�иñ������ֲ߳̾�����������Java���·�����
��������һЩ���Ա�����ʵ�֣���IBM XL FORTRAN���У��������ԵĲ���ṩ��ֱ�ӵ�֧�֡�
��ΪJava��û���ṩ�����Բ�ε�ֱ��֧�֣������ṩ��һ��ThreadLocal�������ṩ֧�֣�
���ԣ���Java�б�д�ֲ߳̾������Ĵ�����ԱȽϱ�׾����Ҳ�����ֲ߳̾�����û����Java�еõ��ܺõ��ռ���һ��ԭ��ɡ� 

ThreadLocal�Կռ任ȡʱ�䣬�ṩ��һ�ַǳ����Ķ��߳�ʵ�ַ�ʽ����Ϊ����̲߳�������������еȴ�������ʹ��ThreadLocal���ø�������ܡ�
��Ȼʹ��ThreadLocal�����������ڴ濪��������㿪����΢������ġ���Ϊ������ThreadLocal�еĶ���ͨ�����ǱȽ�С�Ķ���
����ʹ��ThreadLocal����ʹ��ԭ�����ͣ�ֻ��ʹ��Object���͡�ThreadLocal��ʹ�ñ�synchronizedҪ�򵥵öࡣ 
ThreadLocal��Synchonized�����ڽ�����̲߳������ʡ�����ThreadLocal��synchronized�б��ʵ�����synchronized���������Ļ��ƣ�
ʹ������������ĳһʱ��ֻ�ܱ�һ���̷߳��ʡ���ThreadLocalΪÿһ���̶߳��ṩ�˱����ĸ�����ʹ��ÿ���߳���ĳһʱ����ʵ��Ĳ�����ͬһ������
�����͸����˶���̶߳����ݵ����ݹ�����Synchronizedȴ�����෴���������ڶ���̼߳�ͨ��ʱ�ܹ�������ݹ��� 
Synchronized�����̼߳�����ݹ�����ThreadLocal�������̼߳�����ݸ��롣 
��ȻThreadLocal���������synchronized,���Ǵ���ͬ��������Synchronized����ʵ��ͬ�����ƣ���ThreadLocal���Ӹ��ӡ� 
ThreadLocal������ͬ�����������ʲô�����أ�ThreadLocal���������е�ͬ�����ƶ���Ϊ�˽�����߳��еĶ�ͬһ�����ķ��ʳ�ͻ��
����ͨ��ͬ�������У���ͨ�����������ʵ�ֶ���̶߳�ͬһ�����İ�ȫ���ʵġ���ʱ�ñ����Ƕ���̹߳���ģ�ʹ������ͬ��������Ҫ��ϸ�µط�����ʲôʱ��Ա������ж�д��
ʲôʱ����Ҫ����ĳ������ʲôʱ���ͷŸö�������ȵȺܶࡣ������Щ������Ϊ����̹߳�������Դ��ɵġ�
ThreadLocal�ʹ���һ���Ƕ���������̵߳Ĳ������ʣ�ThreadLocal��Ϊÿһ���߳�ά��һ���͸��̰߳󶨵ı����ĸ������Ӷ������˶���̵߳����ݣ�
ÿһ���̶߳�ӵ���Լ��ı����������Ӷ�Ҳ��û�б�Ҫ�Ըñ�������ͬ���ˡ�ThreadLocal�ṩ���̰߳�ȫ�Ĺ�������ڱ�д���̴߳���ʱ��
���԰Ѳ���ȫ������������װ��ThreadLocal�����߰Ѹö�����ض����̵߳�״̬��װ��ThreadLocal�� 

��ȻThreadLocal���������ͬ�����ƣ������������������ͬ��ͬ��������Ϊ��ͬ������̶߳���ͬ��Դ�Ĳ������ʣ���Ϊ�˶���߳�֮�����ͨ�ŵ���Ч��ʽ��
��ThreadLocal�Ǹ������̵߳����ݹ����Ӹ����ϾͲ��ڶ���߳�֮�乲����Դ����������������Ȼ����Ҫ�Զ���߳̽���ͬ���ˡ�
���ԣ��������Ҫ���ж���߳�֮�����ͨ�ţ���ʹ��ͬ�����ƣ�
�����Ҫ�������߳�֮��Ĺ����ͻ������ʹ��ThreadLocal���⽫����ؼ���ĳ���ʹ��������׶�����ࡣ


*/