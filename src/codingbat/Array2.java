package codingbat;

import java.util.Arrays;

public class Array2 {
	
	private static Array2 my;
	
	public static Array2 getInstance(){
		if (my==null){
			return my=new Array2();
		}
		return my;
	}
	
	private int countEvens(int[] nums){
		int count=0;
		for (int num:nums){
			count=num%2==0?count+1:count;
		}
		return count;
	}
	
	private int[] tenRun(int[] nums){
		int[] result=new int[nums.length];
		int replaceV=-1;
		for (int i=0;i<result.length;i++){
			if (nums[i]%10==0){
				replaceV=nums[i];
				result[i]=replaceV;
			}else{
				if(replaceV!=-1){result[i]=replaceV;}
				else{result[i]=nums[i];}
			}
		}
		return result;
	}
	
	private int[] shiftLeft(int[] nums){
		if (nums.length==0){return new int[0];}
		int[] result=new int[nums.length];
		for (int i=0;i<result.length-1;i++){result[i]=nums[i+1];}
		result[result.length-1]=nums[0];
		return result;
	}
	
	private boolean sameEnds(int[] nums, int len){
		boolean result=true;
		int count=len;
		for (int i = 0; i < nums.length&&count!=0; i++) {
			result&=nums[i]==nums[nums.length-count];
			count--;
		}
		return result;
	}
	
	private boolean has77(int[] nums){
		if (nums.length<2){return false;}
		for (int i=0;i<nums.length;i++){
			if (nums[i]==7&&i+1<nums.length&&nums[i+1]==7){return true;}
			if (i+2<nums.length){
				if (nums[i]==7&&nums[i+2]==7){return true;}
			}
		}
		return false;
	}
	
	private int[] post4(int[] nums){
		int[] result=new int[0];
		int start=-1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i]==4){start=i+1;}
		}
		if (start!=-1){
			int len=nums.length-start;
			result=new int[len];
			for (int i=0;i<len;i++){
				result[i]=nums[start+i];
			}
		}
		return result;
	}

	private int bigDiff(int[] nums){
		if (nums!=null){
			int len=nums.length;
			if (len>=2){
				int max=Math.max(nums[0],nums[1]);
				int min=Math.min(nums[0],nums[1]);
				for (int i=2;i<len;i++){
					if (nums[i]>=max){ max=nums[i];}
					if (nums[i]<=min){ min=nums[i];}
				}
				return max-min;
			}
			return 0;
		}
		return 0;
	}
	
	private int[] zeroMax(int[] nums){
		if (nums!=null&&nums.length!=0){
			int oddMax=0;
			int[] result=nums.clone();
			for (int i=0;i<nums.length;i++){
				if (nums[i]==0){
					for (int j=i;j<nums.length;j++){
						if (nums[j]%2!=0&&nums[j]>=oddMax){
							oddMax=nums[j];
						}
					}
					result[i]=oddMax;
					oddMax=0;
				}
			}
			return result;
		}
		return nums;
	}
	
	public void testcountEvens(){
		int[] nums={2, 1, 2, 3, 4};
		System.out.println(3==countEvens(nums));
		int[] nums2={2, 2, 0};
		System.out.println(3==countEvens(nums2));
		int[] nums3={1, 3, 5};
		System.out.println(0==countEvens(nums3));
	}
	
	public void testtenRun(){
		int[] nums={2, 1, 3, 4, 1, 5};
		System.out.println(tenRun(nums));
		int[] nums2={10, 1, 20, 2};
		System.out.println(tenRun(nums2));
		int[] nums3={10, 1, 9, 20};
		System.out.println(tenRun(nums3));
		int[] nums4={0, 2};
		System.out.println(tenRun(nums4));
	}
	
	public void testshiftLeft(){
		int[] nums={6, 2, 5, 3};
		System.out.println(shiftLeft(nums));
		int[] nums2={1, 2};
		System.out.println(shiftLeft(nums2));
		int[] nums3={1};
		System.out.println(shiftLeft(nums3));
	}
	

	public void testsameEnds(){
		int[] nums={5, 6, 45, 99, 13, 5, 6};
		System.out.println(false==sameEnds(nums,1));
		int[] nums2={5, 6, 45, 99, 13, 5, 6};
		System.out.println(true==sameEnds(nums2,2));
		int[] nums3={5, 6, 45, 99, 13, 5, 6};
		System.out.println(false==sameEnds(nums3,3));
	}
	
	public void testhas77(){
		int[] nums={1, 7, 7};
		System.out.println(has77(nums));
		int[] nums2={1, 7, 1, 7};
		System.out.println(has77(nums2));
		int[] nums3={1, 7, 1, 1, 7};
		System.out.println(has77(nums3));
	}

	public void testpost4(){
		int[] nums={2, 4, 1, 2};
		int[] result={1, 2};
		System.out.println(Arrays.equals(result,post4(nums)));
		int[] nums2={4, 1, 4, 2};
		int[] result2={2};
		System.out.println(Arrays.equals(result2,post4(nums2)));
		int[] nums3={4, 4, 1, 2, 3};
		int[] result3={1, 2, 3};
		System.out.println(Arrays.equals(result3,post4(nums3)));
	}

	public void testbigDiff(){
		int[] nums={10, 3, 5, 6};
		System.out.println(7==bigDiff(nums));
		int[] nums2={7, 2, 10, 9};
		System.out.println(8==bigDiff(nums2));
		int[] nums3={2, 10, 7, 2};
		System.out.println(8==bigDiff(nums3));
	}

	public void testzeroMax(){
		int[] nums={10, 3, 5, 6};
		System.out.println(zeroMax(nums));
		int[] nums2={7, 2, 10, 9};
		System.out.println(zeroMax(nums2));
		int[] nums3={2, 10, 7, 2};
		System.out.println(zeroMax(nums3));
	}

}
