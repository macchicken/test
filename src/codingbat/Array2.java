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
	
	private int[] notAlone(int[] nums, int val){
		int len=nums.length;
		if (len<3){return nums;}
		int[] result=new int[len];
		int i=1;
		while(i<len){
			result[i-1]=nums[i-1];
			if (nums[i]==val&&i+1<len&&nums[i-1]!=nums[i]&&nums[i+1]!=nums[i]){
				result[i+1]=nums[i+1];
				result[i]=Math.max(nums[i-1], nums[i+1]);
				i+=2;
			}else{
				result[i]=nums[i];
				i++;
			}
		}
		return result;
	}

	private int[] zeroFront(int[] nums){
		int[] result=new int[nums.length];
		int zeroIndex=0;
		for (int i=0;i<nums.length;i++){
			if (nums[i]==0){
				result[i]=result[zeroIndex];
				result[zeroIndex]=0;
				zeroIndex++;
			}
			else{result[i]=nums[i];}
		}
		return result;
	}

	private int[] withoutTen(int[] nums) {
		int[] result=new int[nums.length];
		int resultIndex=0;
		for (int i=0;i<nums.length;i++){
			if (nums[i] != 10) {
				result[resultIndex] = nums[i];
				resultIndex++;
			}
		}
		return result;
	}

	private int[] evenOdd(int[] nums){
		int[] result=new int[nums.length];
		int evenIndex=0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i]%2==0){
				result[i]=result[evenIndex];
				result[evenIndex]=nums[i];
				evenIndex++;
			}else{result[i]=nums[i];}
		}
		return result;
	}

	private String[] fizzBuzz(int start, int end){
		int len=end-start;
		if (len<0){return new String[0];}
		String[] result=new String[len];
		for (int i=0,increment=start;i<len&&increment<end;increment++,i++){
			if (increment%15==0){result[i]="FizzBuzz";}
			else if (increment%3==0){result[i]="Fizz";
			}else if(increment%5==0){result[i]="Buzz";}
			else{result[i]=String.valueOf(increment);}
		}
		return result;
	}

	private int centeredAverage(int[] nums){
		int len=nums.length;
		if (len<3){return 0;}
		int sum=nums[0],min=nums[0],max=nums[0];
		for (int i=1;i<len;i++){
			sum+=nums[i];
			if (nums[i]<=min){min=nums[i];}
			else if (nums[i]>=max){max=nums[i];}
		}
		return (sum-min-max)/(len-2);
	}

	private int sum13(int[] nums){
		int sum=0,i=0;
		while(i<nums.length){
			if (nums[i]!=13){sum+=nums[i];i++;}
			else{i+=2;}
		}
		return sum;
	}

	private int sum67(int[] nums){
		int sum=0;
		boolean prevSix=false;
		for (int num:nums){
			if (num==6){prevSix=true;}
			else if (prevSix&&num==7){prevSix=false;}
			else if (!prevSix){sum+=num;}
		}
		return sum;
	}

	private boolean has22(int[] nums){
		boolean prevTwo=false;
		for (int num:nums){
			if (num==2&&prevTwo){return true;}
			prevTwo=(num==2);
		}
		return false;
	}

	private boolean lucky13(int[] nums){
		for (int num:nums){
			if (num==1||num==3){return false;}
		}
		return true;
	}

	private  boolean sum28(int[] nums){
		int total=8/2,count=0;
		for (int num:nums){
			if (num==2){count++;}
		}
		return count==total;
	}

	private boolean more14(int[] nums){
		int oneC=0,fourC=0;
		for (int num:nums){
			if (num==1){oneC++;}
			else if (num==4){fourC++;}
		}
		return oneC>fourC;
	}

	private int[] fizzArray(int n){
		int[] result=new int[n];
		for (int i = 0; i < result.length; i++) {
			result[i]=i;
		}
		return result;
	}

	private boolean only14(int[] nums){
		for (int num:nums){
			if (num!=1&&num!=4){return false;}
		}
		return true;
	}

	private String[] fizzArray2(int n){
		String[] result=new String[n];
		for (int i = 0; i < result.length; i++) {
			result[i]=String.valueOf(i);
		}
		return result;
	}

	private boolean no14(int[] nums){
		int oneC=0,fourC=0;
		for (int num:nums) {
			if (num==1){oneC++;}
			else if (num==4){fourC++;}
		}
		return oneC==0||fourC==0;
	}

	private boolean isEverywhere(int[] nums, int val){
		if (nums.length==2){return val==nums[0]||val==nums[1];}
		int i=0;
		boolean hasPrev=false;
		while(i<nums.length){
			if (nums[i]!=val&&hasPrev){return false;}
			else if (nums[i]==val){hasPrev=true;i+=2;}
			else{i++;}
		}
		return true;
	}

	private boolean either24(int[] nums){
		if (nums.length<2){return false;}
		boolean has22=false,has44=false;
		int len=nums.length;
		for (int i = 0; i < len; i++) {
			if (nums[i]==2&&i+1<len&&nums[i+1]==2){has22=true;}
			else if (nums[i]==4&&i+1<len&&nums[i+1]==4){has44=true;}
		}
		return has22||has44?!(has22&&has44):false;
	}

	private int matchUp(int[] nums1, int[] nums2){
		if (nums1.length!=nums2.length){return 0;}
		int diff=0,count=0;
		for (int i = 0; i < nums1.length; i++) {
			diff=Math.abs(nums1[i]-nums2[i]);
			if (diff==2||diff==1){count++;}
		}
		return count;
	}

	private boolean has12(int[] nums){
		boolean hasOne=false;
		for (int num:nums){
			if (hasOne&&num==2){return true;}
			if (num==1){hasOne=true;}
		}
		return false;
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

	public void testnotAlone(){
		int[] nums={1, 2, 3};
		int[] expected={1, 3, 3};
		System.out.println(Arrays.equals(expected,notAlone(nums,2)));
		int[] nums2={1, 2, 3, 2, 5, 2};
		int[] expected2={1, 3, 3, 5, 5, 2};
		System.out.println(Arrays.equals(expected2,notAlone(nums2,2)));
		int[] nums3={3, 4};
		int[] expected3={3, 4};
		System.out.println(Arrays.equals(expected3,notAlone(nums3,3)));
		int[] nums4={1};
		int[] expected4={1};
		System.out.println(Arrays.equals(expected4,notAlone(nums4,2)));
	}

	public void testzeroFront(){
		int[] nums={1, 0, 0, 1};
		int[] expected={0, 0, 1, 1};
		System.out.println(Arrays.equals(expected,zeroFront(nums)));
		int[] nums2={0, 1, 1, 0, 1};
		int[] expected2={0, 0, 1, 1, 1};
		System.out.println(Arrays.equals(expected2,zeroFront(nums2)));
		int[] nums3={1, 0};
		int[] expected3={0, 1};
		System.out.println(Arrays.equals(expected3,zeroFront(nums3)));
		int[] nums4={1};
		int[] expected4={1};
		System.out.println(Arrays.equals(expected4,zeroFront(nums4)));
	}

	public void testwithoutTen(){
		int[] nums={1, 10, 10, 2};
		int[] expected={1, 2, 0, 0};
		System.out.println(Arrays.equals(expected,withoutTen(nums)));
		int[] nums2={10, 2, 10};
		int[] expected2={2, 0, 0};
		System.out.println(Arrays.equals(expected2,withoutTen(nums2)));
		int[] nums3={1, 99, 10};
		int[] expected3={1, 99, 0};
		System.out.println(Arrays.equals(expected3,withoutTen(nums3)));
		int[] nums4={1, 2, 3, 4};
		int[] expected4={1, 2, 3, 4};
		System.out.println(Arrays.equals(expected4,zeroFront(nums4)));
	}

	public void testevenOdd(){
		int[] nums={1, 0, 1, 0, 0, 1, 1};
		int[] expected={0, 0, 0, 1, 1, 1, 1};
		System.out.println(Arrays.equals(expected,evenOdd(nums)));
		int[] nums2={3, 3, 2};
		int[] expected2={2, 3, 3};
		System.out.println(Arrays.equals(expected2,evenOdd(nums2)));
		int[] nums3={2, 2, 2};
		int[] expected3={2, 2, 2};
		System.out.println(Arrays.equals(expected3,evenOdd(nums3)));
		int[] nums4={1, 0, 3};
		int[] expected4={0, 1, 3};
		System.out.println(Arrays.equals(expected4,evenOdd(nums4)));
	}

	public void testfizzBuzz(){
		String[] expected={"1", "2", "Fizz", "4", "Buzz"};
		System.out.println(Arrays.equals(expected,fizzBuzz(1, 6)));
		String[] expected2={"1", "2", "Fizz", "4", "Buzz", "Fizz", "7"};
		System.out.println(Arrays.equals(expected2,fizzBuzz(1, 8)));
		String[] expected3={"1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz"};
		System.out.println(Arrays.equals(expected3,fizzBuzz(1, 11)));
		String[] expected4={"Buzz" ,"Fizz" ,"82", "83", "Fizz"};
		System.out.println(Arrays.equals(expected4,fizzBuzz(80, 85)));
	}

	public void testcenteredAverage(){
		int[] nums={1, 2, 3, 4, 100};
		System.out.println(3==centeredAverage(nums));
		int[] nums2={1, 1, 5, 5, 10, 8, 7};
		System.out.println(5==centeredAverage(nums2));
		int[] nums3={-10, -4, -2, -4, -2, 0};
		System.out.println(-3==centeredAverage(nums3));
	}

	public void testsum13(){
		int[] nums={1, 2, 2, 1};
		System.out.println(6==sum13(nums));
		int[] nums2={1, 1};
		System.out.println(2==sum13(nums2));
		int[] nums3={1, 2, 2, 1, 13};
		System.out.println(6==sum13(nums3));
		int[] nums4={1, 2, 13, 2, 1, 13};
		System.out.println(4==sum13(nums4));
		int[] nums5={13, 1, 2, 13, 2, 1, 13};
		System.out.println(3==sum13(nums5));
	}

	public void testsum67(){
		int[] nums={1, 2, 2};
		System.out.println(5==sum67(nums));
		int[] nums2={1, 2, 2, 6, 99, 99, 7};
		System.out.println(5==sum67(nums2));
		int[] nums3={1, 1, 6, 7, 2};
		System.out.println(4==sum67(nums3));
		int[] nums4={7, 6, 7};
		System.out.println(7==sum67(nums4));
		int[] nums5={6, 6, 7, 1};
		System.out.println(1==sum67(nums5));
	}

	public void testhas22(){
		int[] nums={1, 2, 2};
		System.out.println(true==has22(nums));
		int[] nums2={1, 2, 1, 2};
		System.out.println(false==has22(nums2));
		int[] nums3={2, 1, 2};
		System.out.println(false==has22(nums3));
		int[] nums4={2, 1};
		System.out.println(false==has22(nums4));
	}

	public void testlucky13(){
		int[] nums={0, 2, 4};
		System.out.println(true==lucky13(nums));
		int[] nums2={1, 2, 3};
		System.out.println(false==lucky13(nums2));
		int[] nums3={1, 2, 4};
		System.out.println(false==lucky13(nums3));
		int[] nums4={};
		System.out.println(true==lucky13(nums4));
	}

	public void testsum28(){
		int[] nums={2, 3, 2, 2, 4, 2};
		System.out.println(true==sum28(nums));
		int[] nums2={2, 3, 2, 2, 4, 2, 2};
		System.out.println(false==sum28(nums2));
		int[] nums3={1, 2, 3, 4};
		System.out.println(false==sum28(nums3));
		int[] nums4={};
		System.out.println(false==sum28(nums4));
	}

	public void testmore14(){
		int[] nums={1, 4, 1};
		System.out.println(true==more14(nums));
		int[] nums2={1, 4, 1, 4};
		System.out.println(false==more14(nums2));
		int[] nums3={1, 1};
		System.out.println(true==more14(nums3));
	}

	public void testfizzArray(){
		int[] expected={0,1,2,3};
		System.out.println(Arrays.equals(expected, fizzArray(4)));
		int[] expected2={0};
		System.out.println(Arrays.equals(expected2, fizzArray(1)));
		int[] expected3={0,1,2,3,4,5,6,7,8,9};
		System.out.println(Arrays.equals(expected3, fizzArray(10)));
	}

	public void testonly14(){
		int[] nums={1, 4, 1, 4};
		System.out.println(true==only14(nums));
		int[] nums2={1, 4, 2, 4};
		System.out.println(false==only14(nums2));
		int[] nums3={1, 1};
		System.out.println(true==only14(nums3));
	}

	public void testfizzArray2(){
		String[] expected={"0", "1", "2", "3"};
		System.out.println(Arrays.equals(expected, fizzArray2(4)));
		String[] expected2={"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		System.out.println(Arrays.equals(expected2, fizzArray2(10)));
		String[] expected3= {"0", "1"};
		System.out.println(Arrays.equals(expected3, fizzArray2(2)));
	}

	public void testno14(){
		int[] nums={1, 2, 3};
		System.out.println(true==no14(nums));
		int[] nums2={1, 2, 3, 4};
		System.out.println(false==no14(nums2));
		int[] nums3={2, 3, 4};
		System.out.println(true==no14(nums3));
	}

	public void testisEverywhere(){
		/**
		 * We'll say that a value is "everywhere" in an array
		 * if for every pair of adjacent elements in the array,
		 * at least one of the pair is that value.
		 * Return true if the given value is everywhere in the array. 
		 */
		int[] nums={1, 2, 1, 3};
		System.out.println(true==isEverywhere(nums,1));
		int[] nums2={1, 2, 1, 3};
		System.out.println(false==isEverywhere(nums2,2));
		int[] nums3={1, 2, 1, 3, 4};
		System.out.println(false==isEverywhere(nums3,1));
		int[] nums4={3, 1};
		System.out.println(true==isEverywhere(nums4,3));
		int[] nums5={3, 1};
		System.out.println(false==isEverywhere(nums5,2));
		int[] nums6={3};
		System.out.println(true==isEverywhere(nums6,1));
		int[] nums7={};
		System.out.println(true==isEverywhere(nums7,1));
	}

	public void testeither24(){
		int[] nums={1, 2, 2};
		System.out.println(true==either24(nums));
		int[] nums2={4, 4, 1};
		System.out.println(true==either24(nums2));
		int[] nums3={4, 4, 1, 2, 2};
		System.out.println(false==either24(nums3));
	}

	public void testmatchUp(){
		int[] nums11={1, 2, 3};
		int[] nums12={2, 3, 10};
		System.out.println(2==matchUp(nums11,nums12));
		int[] nums21={1, 2, 3};
		int[] nums22={2, 3, 5};
		System.out.println(3==matchUp(nums21,nums22));
		int[] nums31={1, 2, 3};
		int[] nums32={2, 3, 3};
		System.out.println(2==matchUp(nums31,nums32));
	}

	public void testhas12(){
		int[] nums={1, 3, 2};
		System.out.println(true==has12(nums));
		int[] nums2={3, 1, 2};
		System.out.println(true==has12(nums2));
		int[] nums3={3, 1, 4, 5, 2};
		System.out.println(true==has12(nums3));
		int[] nums4={1, 1, 4, 5, 1};
		System.out.println(false==has12(nums4));
		int[] nums5={2, 1, 4, 5, 1};
		System.out.println(false==has12(nums5));
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
