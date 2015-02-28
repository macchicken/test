package codingbat;

import java.util.Arrays;
import java.util.HashMap;

public class Array3 {
	
	private static Array3 my;
	
	public static Array3 getInstance(){
		if (my==null) {
			return my=new Array3();
		}
		return my;
	}

	//calculate the maximum of length of each array element
	//between it and its rightmost inclusive
	private int maxSpan(int[] nums){
		if (nums!=null){
			if (nums.length==0){ return 0;}
			int maxSpan=1;
			HashMap<Integer,Integer> temp=new HashMap<Integer,Integer>();
			for (int i=0;i<nums.length;i++){
				if (!temp.containsKey(nums[i])){
					temp.put(nums[i], i);
				}else{
					int pos=temp.get(nums[i]);
					pos=i-pos+1;
					if (pos>=maxSpan){ maxSpan=pos;}
				}
			}
			return maxSpan;
		}
		return 0;
	}
	
	private int[] fix34(int[] nums) {
		  boolean three=false;
		  int fourI=-1;
		  for (int i=0;i<nums.length;i++){
			  if (nums[i]==3){three=true;
			  }else if (nums[i]==4){if (!three) {fourI = i;}
			  }else if (three){
				if (nums[i] != 4) {
					if (fourI!=-1){
						int swap=nums[i];
						nums[i]=nums[fourI];
						nums[fourI]=swap;
						fourI=-1;
						three=false;
					}else{
					for (int j = i + 1; j < nums.length; j++) {
						if (nums[j] == 4) {
							int swap = nums[i];
							nums[i] = nums[j];
							nums[j] = swap;
							three=false;
							break;
						}
					}
					}
				}else{three=false;}
			  }
		  }
		  return nums;
	}

	private int[] fix45(int[] nums) {
		  boolean four=false;
		  int fiveI=-1;
		  for (int i=0;i<nums.length;i++){
			  if (nums[i]==4){four=true;
			  }else if (nums[i]==5){if (!four) {fiveI = i;}
			  }else if (four){
				if (nums[i] != 5) {
					if (fiveI!=-1){
						int swap=nums[i];
						nums[i]=nums[fiveI];
						nums[fiveI]=swap;
						fiveI=-1;
						four=false;
					}else{
					for (int j = i + 1; j < nums.length; j++) {
						if (nums[j] == 5) {
							int swap = nums[i];
							nums[i] = nums[j];
							nums[j] = swap;
							four=false;
							break;
						}
					}
					}
				}else{four=false;}
			  }
		  }
		  return nums;
	}

	public void testmaxSpan(){
		int[] nums={1, 2, 1, 1, 3};
		System.out.println(4==maxSpan(nums));
		int[] nums2={1, 4, 2, 1, 4, 1, 4};
		System.out.println(6==maxSpan(nums2));
		int[] nums3={1, 4, 2, 1, 4, 4, 4};
		System.out.println(6==maxSpan(nums3));
	}

	public void testfix34(){
		int[] nums={1, 3, 1, 4};
		System.out.println(Arrays.toString(fix34(nums)));
		int[] nums2={1, 3, 1, 4, 4, 3, 1};
		System.out.println(Arrays.toString(fix34(nums2)));
		int[] nums3={3, 2, 2, 4};
		System.out.println(Arrays.toString(fix34(nums3)));
		int[] nums4={3, 2, 3, 2, 4, 4};
		System.out.println(Arrays.toString(fix34(nums4)));
		int[] nums5={3, 4, 1};
		System.out.println(Arrays.toString(fix34(nums5)));
	}

	public void testfix45(){
		int[] nums={5, 4, 9, 4, 9, 5};
		System.out.println(Arrays.toString(fix45(nums)));
		int[] nums2={1, 4, 1, 5};
		System.out.println(Arrays.toString(fix45(nums2)));
		int[] nums3={1, 4, 1, 5, 5, 4, 1};
		System.out.println(Arrays.toString(fix45(nums3)));
		int[] nums4={4, 5, 9};
		System.out.println(Arrays.toString(fix45(nums4)));
		int[] nums5={4, 1, 5};
		System.out.println(Arrays.toString(fix45(nums5)));
	}
}
