package codingbat;

public class Array1 {
	
	private static Array1 my;
	
	public static Array1 getInstance(){
		if (my==null){
			return my=new Array1();
		}
		return my;
	}

	private int[] midThree(int[] nums){
		if (nums != null) {
			int len = nums.length;
			if (len > 3&&len%2!=0) {
				int middlePos = (len / 2) + 1;
				int[] result = new int[3];
				result[0] = nums[middlePos-2];
				result[1] = nums[middlePos-1];
				result[2] = nums[middlePos];
				return result;
			}
		}
		return nums;
	}
	
	//test method
	public void testmidThree(){
		int[] nums={1, 2, 3, 4, 5};
		System.out.println(midThree(nums));
		int[] nums2={8, 6, 7, 5, 3, 0, 9};
		System.out.println(midThree(nums2));
		int[] nums3={1, 2, 3};
		System.out.println(midThree(nums3));
	}

}
