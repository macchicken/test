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
	    logger.log(Level.ALL,"花费时间："+spendTime +"毫秒");
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
ThreadLocal是什么呢？其实ThreadLocal并非是一个线程的本地实现版本，它并不是一个Thread，
而是thread local variable（线程局部变量）。也许把它命名为ThreadLocalVar更加合适。
线程局部变量（ThreadLocal）其实的功用非常简单，
就是为每一个使用该变量的线程都提供一个变量值的副本，
是每一个线程都可以独立地改变自己的副本，而不会和其它线程的副本冲突。
从线程的角度看，就好像每一个线程都完全拥有该变量。线程局部变量并不是Java的新发明，
在其它的一些语言编译器实现（如IBM XL FORTRAN）中，它在语言的层次提供了直接的支持。
因为Java中没有提供在语言层次的直接支持，而是提供了一个ThreadLocal的类来提供支持，
所以，在Java中编写线程局部变量的代码相对比较笨拙，这也许是线程局部变量没有在Java中得到很好的普及的一个原因吧。 

ThreadLocal以空间换取时间，提供了一种非常简便的多线程实现方式。因为多个线程并发访问无需进行等待，所以使用ThreadLocal会获得更大的性能。
虽然使用ThreadLocal会带来更多的内存开销，但这点开销是微不足道的。因为保存在ThreadLocal中的对象，通常都是比较小的对象。
另外使用ThreadLocal不能使用原子类型，只能使用Object类型。ThreadLocal的使用比synchronized要简单得多。 
ThreadLocal和Synchonized都用于解决多线程并发访问。但是ThreadLocal与synchronized有本质的区别。synchronized是利用锁的机制，
使变量或代码块在某一时该只能被一个线程访问。而ThreadLocal为每一个线程都提供了变量的副本，使得每个线程在某一时间访问到的并不是同一个对象，
这样就隔离了多个线程对数据的数据共享。而Synchronized却正好相反，它用于在多个线程间通信时能够获得数据共享。 
Synchronized用于线程间的数据共享，而ThreadLocal则用于线程间的数据隔离。 
当然ThreadLocal并不能替代synchronized,它们处理不同的问题域。Synchronized用于实现同步机制，比ThreadLocal更加复杂。 
ThreadLocal和其它同步机制相比有什么优势呢？ThreadLocal和其它所有的同步机制都是为了解决多线程中的对同一变量的访问冲突，
在普通的同步机制中，是通过对象加锁来实现多个线程对同一变量的安全访问的。这时该变量是多个线程共享的，使用这种同步机制需要很细致地分析在什么时候对变量进行读写，
什么时候需要锁定某个对象，什么时候释放该对象的锁等等很多。所有这些都是因为多个线程共享了资源造成的。
ThreadLocal就从另一个角度来解决多线程的并发访问，ThreadLocal会为每一个线程维护一个和该线程绑定的变量的副本，从而隔离了多个线程的数据，
每一个线程都拥有自己的变量副本，从而也就没有必要对该变量进行同步了。ThreadLocal提供了线程安全的共享对象，在编写多线程代码时，
可以把不安全的整个变量封装进ThreadLocal，或者把该对象的特定于线程的状态封装进ThreadLocal。 

当然ThreadLocal并不能替代同步机制，两者面向的问题领域不同。同步机制是为了同步多个线程对相同资源的并发访问，是为了多个线程之间进行通信的有效方式；
而ThreadLocal是隔离多个线程的数据共享，从根本上就不在多个线程之间共享资源（变量），这样当然不需要对多个线程进行同步了。
所以，如果你需要进行多个线程之间进行通信，则使用同步机制；
如果需要隔离多个线程之间的共享冲突，可以使用ThreadLocal，这将极大地简化你的程序，使程序更加易读、简洁。


*/