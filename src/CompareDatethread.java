import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class CompareDatethread implements Runnable{

	/**
	 * @param args
	 */
	private final static ThreadLocal<Calendar> timeLocal = new ThreadLocal<Calendar>();
	public static Logger logger;
	 private static String file_indexpath="D:\\hc105\\testlog\\";
	 private static String extend;
	 public static Calendar now=null;
	 
	 public CompareDatethread(){
		 now=getInstanceTime();
			//int currday=now.get(Calendar.DAY_OF_MONTH);
			//int currmonth=now.get(Calendar.MONTH);
			//int curryear=now.get(Calendar.YEAR);
			//System.out.println(currday);
	 }
	 
	 public static void createlogfile(String file_name) throws IOException{
			extend=(new SimpleDateFormat("yyyy-MM-dd")).format(Calendar.getInstance().getTime());
			file_name=file_indexpath+file_name+extend+".log";
			File file=new File(file_name);
			if (!file.exists()){
			file.createNewFile();
			}
			logger=Logger.getLogger("Mythreadlocaltimecomparelogger");
			FileHandler fh=new FileHandler(file_name,true);
			logger.addHandler(fh);
			logger.setLevel(Level.ALL);
			SimpleFormatter formatter = new SimpleFormatter();
		    fh.setFormatter(formatter);
	 }
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub	
		createlogfile("threadlocaltimecomparelog");
		CompareDatethread datethread=new CompareDatethread();
		Thread thread_a=new Thread(datethread,"thread_a");
		Thread thread_b=new Thread(datethread,"thread_b");
		thread_a.start();
		thread_b.start();
		
	}


	@Override
	public void run() {
		try {
			if (compareDate(now,"2010-07-30","2010-08-30")){
				System.out.println(" within specified times ");
				logger.log(Level.ALL," within specified times ");
			}else{
				System.out.println(" not within specified times ");
				logger.log(Level.ALL," not within specified times ");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	
	
	public Calendar stringtoDate(String dateString) throws java.lang.Exception {
		DateFormat dateFormat;
		dateFormat = new SimpleDateFormat("yyyy-MM-dd",Locale.CHINESE);
		java.util.Date timeDate = dateFormat.parse(dateString);
		java.sql.Date dateTime = new java.sql.Date(timeDate.getTime());
		Calendar cal=Calendar.getInstance();
		cal.clear();
		cal.setTime(dateTime);
		String temp=dateFormat.format(cal.getTime());
		System.out.println(temp);
		return cal;
	}


	public boolean compareDate(Calendar now,String before,String after) throws Exception{
		long startTime = System.currentTimeMillis();
		String thread_name=Thread.currentThread().getName();
		Calendar beforedate=stringtoDate(before);
		Calendar afterdate=stringtoDate(after);
		logger.log(Level.ALL,thread_name+"  is running");
	
		try {
			
			Thread.sleep(5000);//can do some actual works to communicate with db,which are time consuming
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e=new InterruptedException("unable to sleep current thread....");
			throw e;
		}
		long endTime = System.currentTimeMillis();
	    long spendTime = endTime - startTime;
	    logger.log(Level.ALL,thread_name+"  spent time: "+spendTime);
	    return (now.compareTo(beforedate)>=0&&now.compareTo(afterdate)<=0);
	}
	
	protected static Calendar getInstanceTime(){
		Calendar new_now=(Calendar)timeLocal.get();
		if (new_now==null){
			new_now=Calendar.getInstance(Locale.CHINESE);
			timeLocal.set(new_now);
		}
		return new_now;
	}
	
	protected void setInstanceTime(Calendar time){
		timeLocal.set(time);
	}
}
