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

public class ThreadDemo implements Runnable{

	/**
	 * @param args
	 */
	 Student student=new Student();
	 private int count=0;
	 private Object studentLock = new Object();
	 private Object countLock = new Object();
	 public static Logger logger;
	 public static String file_indexpath="D:\\hc105\\testlog\\";
	 public static String extend;
	public static void main(String[] args) throws SecurityException, IOException {
		// TODO Auto-generated method stub
		
		String file_name="threadlog";
		extend=(new SimpleDateFormat("yyyy-MM-dd")).format(Calendar.getInstance().getTime());
		file_name=file_indexpath+file_name+extend+".log";
		File file=new File(file_name);
		if (!file.exists()){
		file.createNewFile();
		}
		logger=Logger.getLogger("Mylogger");
		FileHandler fh=new FileHandler(file_name,true);
		logger.addHandler(fh);
		logger.setLevel(Level.ALL);
		SimpleFormatter formatter = new SimpleFormatter();
	    fh.setFormatter(formatter);
	    ThreadDemo student_threads=new ThreadDemo();
		Thread thread_a=new Thread(student_threads,"thread_a");
		Thread thread_b=new Thread(student_threads,"thread_b");
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
		synchronized(studentLock){
		try {
			this.count++;
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e=new InterruptedException("unable to sleep current thread....");
			throw e;
		}
		}
		logger.log(Level.ALL,thread_name+"read count: "+this.count);
		synchronized(countLock){
		int age=((new Random()).nextInt(100));
		String name=(Integer.toString(age)).concat("john");
		logger.log(Level.ALL, thread_name+" about to set the age is "+age+" abount to set the name is "+name);
		this.student.setAge(age);
		this.student.setStudentName(name);
		logger.log(Level.ALL,thread_name+" first read student age is "+this.student.getAge());
		logger.log(Level.ALL,thread_name+" first read student name is "+this.student.getStudentName());
		try {
			this.count++;
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e=new InterruptedException("unable to sleep current thread....");
			throw e;
		}
		}
		logger.log(Level.ALL,thread_name+" second read student age is "+this.student.getAge());
		logger.log(Level.ALL,thread_name+" second read student name is "+this.student.getStudentName());
		long endTime = System.currentTimeMillis();
	    long spendTime = endTime - startTime;
	    logger.log(Level.ALL,"花费时间："+spendTime +"毫秒");
	}
}
