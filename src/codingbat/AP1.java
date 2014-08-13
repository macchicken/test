package codingbat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AP1 {
	
	private static AP1 my=new AP1();
	
	public static AP1 getInstance(){
		return my;
	}

	private List<String> wordsWithoutList(String[] words,int len){
		if (words!=null&&len!=0){
			LinkedList<String> temp=new LinkedList<String>();
			for (String oneword:words){
				if (oneword.length()!=len){temp.add(oneword);}
			}
			return  temp.size()!=0?temp:Arrays.asList(words);
		}
		return null;
	}

	private boolean dividesSelf(int n){
		if (n%10==0){return false;}
		int factor=n;
		while(factor!=0){
			if (n%(factor%10)!=0){return false;}
			factor=factor/10;
		}
		return true;
	}
	
	private boolean scoresIncreasing(int[] scores){
		int prev=scores[0];
		for (int i=1;i<scores.length;i++){
			if (scores[i]<prev){return false;}
			prev=scores[i];
		}
		return true;
	}
	
	private boolean scores100(int[] scores){
		for (int i=0;i<scores.length-1;i++){
			if (scores[i]==100&&scores[i+1]==100){
				return true;
			}
		}
		return false;
	}
	
	private boolean scoresClump(int[] scores){
		for (int i=0;i<scores.length;i++){
			if (i+2<scores.length){
				if (Math.abs(scores[i]-scores[i+1])<=2&&
					Math.abs(scores[i]-scores[i+2])<=2&&
					Math.abs(scores[i+1]-scores[i+2])<=2){
					return true;
				}
			}
		}
		return false;
	}
	
	private int scoresAverage(int[] scores){
		int len=scores.length;
		int firstHalf=average(scores,0,(len/2)-1);
		int secHalf=0;
		if (len%2==0){
			secHalf=average(scores,len/2,len-1);
		}else{
			secHalf=average(scores,(len/2)+1,len-1);
		}
		return firstHalf>=secHalf?firstHalf:secHalf;
	}
	
	private int average(int[] scores,int start,int end){
		int count=0;
		int result=0;
		while(start<=end){
			result+=scores[start];
			start++;
			count++;
		}
		return result/count;
	}


	//test method
	public void testwordsWithoutList(){
		String[] words={"a", "bb", "b", "ccc"};
		System.out.println(wordsWithoutList(words,1));
		System.out.println(wordsWithoutList(words,3));
		System.out.println(wordsWithoutList(words,4));
	}

	public void testdividesSelf(){
		System.out.println(dividesSelf(128));
		System.out.println(dividesSelf(12));
		System.out.println(dividesSelf(120));
	}
	
	public void testscoresIncreasing(){
		int[] nums={1, 3, 4};
		System.out.println(scoresIncreasing(nums));
		int[] nums1={1, 3, 2};
		System.out.println(scoresIncreasing(nums1));
		int[] nums2={1, 1, 4};
		System.out.println(scoresIncreasing(nums2));
	}
	
	public void testscores100(){
		int[] nums={1, 100, 100};
		System.out.println(scores100(nums));
		int[] nums1={1, 100, 99, 100};
		System.out.println(scores100(nums1));
		int[] nums2={100, 1, 100, 100};
		System.out.println(scores100(nums2));
	}

	public void testscoresClump(){
		int[] nums={3, 4, 5};
		System.out.println(scoresClump(nums));
		int[] nums1={3, 4, 6};
		System.out.println(scoresClump(nums1));
		int[] nums2={1, 3, 5, 5};
		System.out.println(scoresClump(nums2));
	}
	
	public void testscoresAverage(){
		int[] nums={2, 2, 4, 4};
		System.out.println(scoresAverage(nums));
		int[] nums1={4, 4, 4, 2, 2, 2};
		System.out.println(scoresAverage(nums1));
		int[] nums2={3, 4, 5, 1, 2, 3};
		System.out.println(scoresAverage(nums2));
	}

}
