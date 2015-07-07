package alogorithm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class StringSections {

	private static StringBuffer readData() throws FileNotFoundException, IOException{
		String dir=System.getProperty("user.dir");
		try(BufferedReader reader=new BufferedReader(new FileReader(dir+"\\src\\alogorithm\\sampleData.txt"))){
			StringBuffer buff=new StringBuffer();
			String str;
			while((str=reader.readLine())!=null){
				buff.append(str);
			}
			return buff;
		}
	}

	/**
	 * remove white space in the characters
	 * @param str
	 * @return StringBuffer
	 */
	private static char[] removeSpace(String str){
		char[] sc=str.toCharArray();
		int j=0;
		for (int i=0;i<sc.length;i++){
			if (sc[i]!=' '){
				sc[j]=sc[i];
				j++;
			}
		}
		char[] dest=new char[j];
		System.arraycopy(sc,0,dest,0,j);
		return dest;
	}

	/**
	 * revert characters
	 * @param str
	 */
	private static void revertStr(String str){
		char[] c=str.toCharArray();
		int start=0,end=c.length-1;int pivot=c.length/2;
		while(start!=pivot){
			char a=c[start];
			char b=c[end];
			a=(char) (a+b);
			b=(char) (a-b);
			a=(char) (a-b);
			c[start]=a;
			c[end]=b;
			start++;
			end--;
		}
		System.out.println(c);
	}
	
	/**
	 * check plalindrome with a string
	 * @param str
	 * @return boolean
	 */
	private static boolean plalindromeCheck(String str){
		char[] c=str.toCharArray();
		int start=0,end=c.length-1;int pivot=c.length/2;
		while(start!=pivot){
			if (c[start]!=c[end]){return false;}
			start++;
			end--;
			continue;
		}
		return true;
	}

	/**
	 * 在字符串中删除特定的字符。 题目：输入两个字符串，从第一字符串中删除第二个字符串中所有的字符
	 * 例如，输入”They are students.”和”aeiou”，则删除之后的第一个字符串变成”Thy r stdnts.”。
	 * @param source - target string to be modified
	 * @param del - contained the characters to be deleted
	 */
	private static void deleteFirst(String source,String del){
		char[] sc=source.toCharArray();
		Map<Character,Integer> table=new HashMap<Character,Integer>();
		for(int i=0;i<del.length();i++){
			table.put(del.charAt(i), i);
		}
		int z=0;
		for (int j=0;j<sc.length;j++){
			char t=sc[j];
			if (t==' '||table.get(t)==null){
				sc[z]=t;
				if (t=='.'){break;}
				z++;
			}
		}
		char[] dest=new char[z+1];
		System.arraycopy(sc,0,dest,0,z+1);
		System.out.println(dest);
	}

	/**
	 * 在一个字符串中找到第一个只出现一次的字符。如输入abaccdeff，则输出b。
	 * @param str
	 */
	private static void firstAppearOnlyOnce(String str){
		int[] table=new int[256];
		char[] sc=str.toCharArray();
		for (int i=0;i<sc.length;i++){
			if (table[(int)sc[i]]==0){
				table[(int)sc[i]]=i+1;
			}else if (table[(int)sc[i]]>0){
				table[(int)sc[i]]=-1;
			}
		}
		int index=Integer.MAX_VALUE;char c = 0;
		for (int i=0;i<256;i++){
			if (table[i]>0&&table[i]<index){
				index=table[i];
				c=(char)i;
			}
		}
		if (index==Integer.MAX_VALUE){System.out.println("");}
		else{System.out.println(c);}
	}

	/**
	 * 匹配兄弟字符串如果两个字符串的字符一样，但是顺序不一样，被认为是兄弟字符串，
	 * 问如何在迅速匹配兄弟字符串（如，bad和adb就是兄弟字符串）。
	 * @param one
	 * @param two
	 * @return boolean
	 */
	private static boolean isBrother(String one,String two){
		int[][] table=new int[2][256];
		int oneL=one.length(), twoL=two.length();
		if (oneL!=twoL){return false;}
		for (int i=0;i<oneL;i++){
			table[0][(int)one.charAt(i)]++;
		}
		for (int i=0;i<twoL;i++){
			table[1][(int)two.charAt(i)]++;
		}
		for (int i=0;i<256;i++){
			if (table[0][i]!=table[1][i]){
				return false;
			}
		}
		return true;
	}


	public static void main(String[] args) {
		System.out.println(removeSpace("sadsa sdda  r$ qwe213231 "));
		revertStr("123 456 789");
		System.out.println(plalindromeCheck("acbca sas sas acbca"));
		deleteFirst("They are students.","aeiou");
		System.out.println(isBrother("bad","adb"));
		try {
			StringBuffer buff=readData();
			firstAppearOnlyOnce("abaccbdeff");
			firstAppearOnlyOnce(buff.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
