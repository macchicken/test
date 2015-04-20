package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;


public class TestDataObeject {
	
	
	public void testParseArrayList(ArrayList dataList){
		HashMap temp = null;
		HashMap result =null;
		if (dataList!=null&&!dataList.isEmpty()){
			java.util.Iterator dataIt = dataList.listIterator();
			result= new HashMap(20);
			String key = null;
			ArrayList tempList = null;
			while(dataIt.hasNext()){
				temp = (HashMap) dataIt.next();
				key = (String) temp.get("policyNo");
				tempList = (ArrayList) result.get(key);
				if (tempList==null||tempList.isEmpty()){
					tempList = new ArrayList();
				}
				tempList.add(temp);
				result.put(key, tempList);
			}
		}
		System.out.println("result SIZE--------"+result.size());
		System.out.println("result--------"+result);
	}
	
	private static int convert(boolean value){ if(value) return 1; else return 0;}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList dataList2 = new ArrayList();
		HashMap temp2 = new HashMap(10);
		temp2.put("policyNo", "111");
		temp2.put("licenseNo", "55555");
		temp2.put("carMark", "‘¡B-77777");
		dataList2.add(temp2);
		temp2 = new HashMap(10);
		temp2.put("policyNo", "111");
		temp2.put("licenseNo", "88888");
		temp2.put("carMark", "‘¡B-77777");
		dataList2.add(temp2);
		temp2 = new HashMap(10);
		temp2.put("policyNo", "111");
		temp2.put("licenseNo", "99999");
		temp2.put("carMark", "‘¡B-77777");
		dataList2.add(temp2);
		temp2 = new HashMap(10);
		temp2.put("policyNo", "333");
		temp2.put("licenseNo", "00000");
		temp2.put("carMark", "‘¡B-77777");
		dataList2.add(temp2);
		temp2 = new HashMap(10);
		System.out.println("dataList2 SIZE--------"+dataList2.size());
		System.out.println("dataList2--------"+dataList2);
		TestDataObeject test =new TestDataObeject();
		test.testParseArrayList(dataList2);
		int totalrating=1;
		float testfff=Float.valueOf(Integer.toString(totalrating))/5;
		System.out.println(testfff);
		boolean testiiii=true;
		for (int i = 0; i < 2; i++) {
			System.out.println(convert(testiiii));
			testiiii=!testiiii;
		}
		char[][] matrix=new char[3][2];
		if (3>matrix.length||2>matrix[2].length){
			System.out.println("332132321");
		}
		char a='b';
		char b='b';
		HashMap<String,Object> checkObjs=new HashMap<String,Object>();
		checkObjs.put("currentPlayer", a);
		checkObjs.put("matrix", matrix);
		char c=(Character) checkObjs.get("currentPlayer");
		char[][] matrix2=(char[][]) checkObjs.get("matrix");
		System.out.println(c);
		System.out.println(matrix2);
		System.out.println(a==b);
		Pattern numP = Pattern.compile("[1-9][0-9]*[\\s\t\n]*,[\\s\t\n]*[1-9][0-9]*");
		String str=" 1,   ".trim();
		System.out.println(numP.matcher(str).matches());
		char winner=0;
		int maxDisks=64;
		int count=63;
		boolean draw=winner==0&&count==maxDisks;
		System.out.println("draw");
		System.out.println(draw);
	}

}