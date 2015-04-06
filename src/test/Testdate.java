package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import test.element.Gender;
import test.element.Student;

public class Testdate {

	private static Student temp;

	/**
	 * @param args
	 */public static Calendar stringtoDate(String dateString) throws java.lang.Exception {
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
	 public static void addDatatoList(String name,List<Student> studentlist,int count){
		 		Student temp=new Student();
		 		while(count>0){
		 		int age=((new Random()).nextInt(100));
		 		String tempName=(Integer.toString(age)).concat(name);
		 		temp.setAge(age);
		 		temp.setStudentName(tempName);
		 		studentlist.add(temp);
		 		count--;
		 }
	}
	
	private static void putData(Map invoice){
		if (invoice.get("index")!=null) {
			if (((Integer)invoice.get("index")).intValue() == 0) {
				invoice.put("PLYNO", "1111111111111111111111");
				System.out.println("1111111111111111111111");
			} else {
				invoice.put("PLYNO", "222222222222222222");
				System.out.println("222222222222222222");
			}
		}
		
	}
	private static String timeIncrementor(String time,int increment){
		int minute,hour;
		String result="";
		if (time!=null&&!"".equals(time.trim())){
			if (time.indexOf(":")>0){
			String[] temp=time.split(":");
			if (temp.length>=2){
				minute=Integer.parseInt(temp[1]);
				hour=Integer.parseInt(temp[0]);
			/*if (minute<60){
				minute+=10;
			}
			if (minute==60){
				minute=0;
				hour+=1;
			}
			if (hour<10){
				result="0".concat(String.valueOf(hour)).concat(":");
			}else{
				result=String.valueOf(hour).concat(":");
			}
			if (minute<10){
				result=result.concat("0").concat(String.valueOf(minute));
			}else{
				result=result.concat(String.valueOf(minute));
			}*/ 
				if (((minute+increment)/60)>=1){
					hour+=1;
				}
				minute=(minute+increment)%60;
				if (hour<10){
					result="0".concat(String.valueOf(hour)).concat(":");
				}else{
					result=String.valueOf(hour).concat(":");
				}
				if (minute<10){
					result=result.concat("0").concat(String.valueOf(minute));
				}else{
					result=result.concat(String.valueOf(minute));
				}
			}
			}
		}
		return result;
	}
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception {
/*		Calendar now=Calendar.getInstance();
		System.out.println("现在时间是："+now.getTime());
		Calendar date=stringtoDate("2010-07-30");
		System.out.println(date.getTime());
		Student a =new Student();
		a.setAge(11);
		a.setStudent_name("tom");
		Student b =new Student();
		b.setAge(12);
		b.setStudent_name("jim");
		Student c =new Student();
		c.setAge(13);
		c.setStudent_name("barry");
		List<Student> studentlist;
		studentlist=new LinkedList<Student>();
		studentlist.add(a);
		studentlist.add(b);
		studentlist.add(c);
		//LinkedList studentlist=new LinkedList<Student>();
		//addDatatoList("barry",studentlist,3);
		for (int i=studentlist.size()-1;i>=0;i--){
			System.out.println(studentlist.size());
			System.out.println(studentlist.remove(i).getStudent_name());
		}
		try{
		((LinkedList<Student>) studentlist).element().getStudent_name();
		}catch(java.util.NoSuchElementException nseecep){
			Student  tail=new Student();
			studentlist.add(tail);
			System.out.println("contain null student object, deletion ended");
		}
		ArrayList<Student> newlist=new ArrayList<Student>();
		newlist.add(a);
		newlist.add(b);
		newlist.add(c);
		ListIterator<Student> studentiterator=newlist.listIterator();
		temp = new Student();
		while(studentiterator.hasNext()){
			temp=studentiterator.next();
			studentiterator.remove();
		}
		System.out.println(temp.getStudent_name()+" "+newlist.size());*/
		//new JavaZipBrowser();
		/*ListSystemService sysService=new ListSystemService();
		String strTest[] = sysService.getServiceTypes();
	       for(int i=0; i<strTest.length;i++)
	       {
	           System.out.println(strTest[i]);
	       }
	       System.out.println("------------------------------------------------------");
	       String strTest1[] = sysService.getCryptoImpls("Cipher");

	       for(int i=0; i<strTest1.length;i++)
	       {
	           System.out.println(strTest1[i]);
	       }
	       */
		/*String endStr="";
		String filepath;
		String fileName;
		do{
		filepath = JOptionPane.showInputDialog("Please input a filepath separated by ".concat(File.separator));
		fileName = JOptionPane.showInputDialog("Please input a file name which is under the above inputed path");
		endStr=JOptionPane.showInputDialog("check the correctness of "+filepath.concat(fileName)+"\n and type '#' if yes otherwise type random");
		System.out.println(endStr);
		}while(!"#".equals(endStr)); 
		FileCheckSum test=new FileCheckSum();
		test.calculateFileCheckSum(filepath, fileName);*/
		String time="09:00";
		String temp="";
		Map<String, String> tempMap=new HashMap<String, String>();
		tempMap.put("DPTCDE", "205");
		Map<String, Comparable> anotherMap=null;
		ArrayList<Map> listtemp=new ArrayList<Map>();
		int increment=25;
		for (int i=0;i<((3*60)/increment);i++){
			temp=timeIncrementor(time,increment);
			System.out.println(temp);
			time=temp;
		}
		for (int i=0;i<2;i++){
			anotherMap=new HashMap<String, Comparable>(tempMap);
			anotherMap.put("index", new Integer(i));
			putData(anotherMap);
			listtemp.add(anotherMap);
			anotherMap=null;
			}
		System.out.println(listtemp);
		System.out.println(2&2&2&2);
		System.out.println(1&'D'&'J'&'K');
		Calendar time1 = Calendar.getInstance();
		Calendar time2 = Calendar.getInstance();
		time1.add(Calendar.MONDAY, -11);
		System.out.println("time1 时间是："+time1.getTime());
		time2.add(Calendar.MONDAY, -9);
		System.out.println("time2 时间是："+time2.getTime());
		System.out.println(time1.get(Calendar.YEAR));
		System.out.println(time1.get(Calendar.MONTH));
		System.out.println(time1.get(Calendar.DAY_OF_MONTH));
		System.out.println(Gender.FEMALE.ordinal());
		System.out.println(Gender.MALE.ordinal());
		String[][] tmmmmmmmm= new String[2][3];
		tmmmmmmmm[1][2]="3121321";
		System.out.println(tmmmmmmmm[1][2]);
		System.out.println(tmmmmmmmm.length);
		System.out.println(tmmmmmmmm[0].length);
		Date tempppppppppp=new Date();
		System.out.println(tempppppppppp);
		SimpleDateFormat formator=new SimpleDateFormat("MMMMMMMMM dd,yyyy",Locale.ENGLISH);
		System.out.println(formator.format(tempppppppppp));
	    }
}
