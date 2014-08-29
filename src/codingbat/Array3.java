package codingbat;

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
	
	public void testmaxSpan(){
		int[] nums={1, 2, 1, 1, 3};
		System.out.println(4==maxSpan(nums));
		int[] nums2={1, 4, 2, 1, 4, 1, 4};
		System.out.println(6==maxSpan(nums2));
		int[] nums3={1, 4, 2, 1, 4, 4, 4};
		System.out.println(6==maxSpan(nums3));
	}

}
