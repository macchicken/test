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
		int count=0;
		boolean prevSeven=nums[0]==7;
		for (int i=1;i<nums.length;i++){
			if (nums[i]==7){
				if (prevSeven){return true;}
				prevSeven=true;
			}else{
				if (count==1){count=0;prevSeven=false;}
				else if (prevSeven){count++;}
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

	private boolean modThree(int[] nums){
		int oddC=0,evenC=0;
		for (int num:nums){
			if (num%2==0){
				oddC=0;evenC++;
				if (evenC==3){return true;}
			}else{
				evenC=0;oddC++;
				if (oddC==3){return true;}
			}
		}
		return false;
	}

	private boolean twoTwo(int[] nums) {
		int count=0;
		int prevI=0;
		for (int i=0;i<nums.length;i++){
			if(nums[i]==2){
				if (i-prevI>1){return false;}
				prevI=i;
				count++;
			}
		}
		return count==0||count>1;
	}

	private boolean tripleUp(int[] nums){
		if (nums.length<2){return false;}
		int count=0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i]-nums[i-1]==1){count++;}
			else if(count>0){count--;}
			if (count==2){return true;}
		}
		return false;
	}

	private int[] fizzArray3(int start, int end){
		if (end<start){return new int[0];}
		int[] result=new int[end-start];
		int increment=start;
		for (int i = 0; i < result.length; i++) {
			result[i]=increment;
			increment+=1;
		}
		return result;
	}

	private int[] pre4(int[] nums){
		int[] result=new int[0];
		for (int i=0;i<nums.length;i++){
			if (nums[i]==4){
				result=new int[i];
				for (int j=0;j<i;j++){result[j]=nums[j];}
				return result;
			}
		}
		return result;
	}

	private boolean haveThree(int[] nums){
		int count=0;
		boolean preThree=false;
		for (int num:nums){
			if (num==3){
				if (!preThree) {preThree=true;count++;}
				else{count=0;}
			}
			else{preThree=false;}
		}
		return count==3;
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
		System.out.println(true==has77(nums));
		int[] nums2={1, 7, 1, 7};
		System.out.println(true==has77(nums2));
		int[] nums3={7, 2, 6, 2, 2, 7};
		System.out.println(false==has77(nums3));
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

	public void testmodThree(){
		int[] nums={2, 1, 3, 5};
		System.out.println(true==modThree(nums));
		int[] nums2={2, 1, 2, 5};
		System.out.println(false==modThree(nums2));
		int[] nums3={2, 4, 2, 5};
		System.out.println(true==modThree(nums3));
	}

	public void testhaveThree(){
		int[] nums={3, 1, 3, 1, 3};
		System.out.println(true==haveThree(nums));
		int[] nums2={3, 1, 3, 3};
		System.out.println(false==haveThree(nums2));
		int[] nums3={3, 4, 3, 3, 4};
		System.out.println(false==haveThree(nums3));
		int[] nums4={1, 3, 1, 3, 1, 3, 4, 3};
		System.out.println(false==haveThree(nums4));
	}

	public void testtwoTwo(){
		int[] nums={4, 2, 2, 3};
		System.out.println(true==twoTwo(nums));
		int[] nums2={2, 2, 4};
		System.out.println(true==twoTwo(nums2));
		int[] nums3={2, 2, 4, 2};
		System.out.println(false==twoTwo(nums3));
	}

	public void testtripleUp(){
		int[] nums={1, 4, 5, 6, 2};
		System.out.println(true==tripleUp(nums));
		int[] nums2={1, 2, 3};
		System.out.println(true==tripleUp(nums2));
		int[] nums3={1, 2, 4};
		System.out.println(false==tripleUp(nums3));
		int[] nums4={1, 2, 4, 5, 7, 6, 5, 7, 7, 6};
		System.out.println(false==tripleUp(nums4));
		int[] nums5={10, 9, 8, -100, -99, 99, 100};
		System.out.println(false==tripleUp(nums5));
		int[] nums6={2, 3, 5, 6, 8, 9, 2, 3};
		System.out.println(false==tripleUp(nums6));
	}

	public void testfizzArray3(){
		int[] expected={5, 6, 7, 8, 9};
		System.out.println(Arrays.equals(expected,fizzArray3(5,10)));
		int[] expected2={11, 12, 13, 14, 15, 16, 17};
		System.out.println(Arrays.equals(expected2,fizzArray3(11,18)));
		int[] expected3={1, 2};
		System.out.println(Arrays.equals(expected3,fizzArray3(1,3)));
	}

	public void testpre4(){
		int[] nums={1, 2, 4, 1};
		int[] expected={1, 2};
		System.out.println(Arrays.equals(expected,pre4(nums)));
		int[] nums2={3, 1, 4};
		int[] expected2={3, 1};
		System.out.println(Arrays.equals(expected2,pre4(nums2)));
		int[] nums3={1, 4, 4};
		int[] expected3={1};
		System.out.println(Arrays.equals(expected3,pre4(nums3)));
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
