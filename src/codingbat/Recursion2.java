package codingbat;

public class Recursion2 {

	/*groupSum(0, {2, 4, 8}, 10) ¡ú true
	groupSum(0, {2, 4, 8}, 14) ¡ú true
	groupSum(0, {2, 4, 8}, 9) ¡ú false*/
	private boolean groupSum(int start,int[] nums,int target) {
		  if (start>=nums.length&&target==0){return true;}
		  if (start<nums.length){
			  if (groupSum(start+1,nums,target-nums[start])
				||groupSum(start+1,nums,target)){
				  return true;
			  }
		  }
		  return false;
	}
	
	private boolean groupSum6(int start,int[] nums,int target){
		if (start>=nums.length&&target==0){return true;}
		if (start<nums.length){
			if (nums[start]!=6&&groupSum6(start+1,nums,target)){
				return true;
			}
			if (groupSum6(start+1,nums,target-nums[start])){
				return true;
			}
		}
		return false;
	}
	
	private boolean groupNoAdj(int start,int[] nums,int target){
		if (start>=nums.length&&target==0){return true;}
		if (start<nums.length){
			if (groupNoAdj(start+2,nums,target-nums[start])||
				groupNoAdj(start+1,nums,target)){
				return true;
			}
		}
		return false;
	}
	
	private boolean groupSum5(int start,int[] nums,int target){
		if (start>=nums.length&&target==0){return true;}
		if (start<nums.length){
			if (nums[start]%5!=0&&groupSum5(start+1,nums,target)){
				return true;
			}
			if (groupSum5(start+1,nums,target-nums[start])&&
				!(start>0&&nums[start-1]%5==0&&nums[start]==1)){
				return true;
			}
		}
		return false;
	}
	
	
	//test method
	public void testgroupSum(){
		int[] nums={2, 4, 8};
		System.out.println(groupSum(0, nums, 10));
		System.out.println(groupSum(0, nums, 14));
		System.out.println(groupSum(0, nums, 9));
	}
	
	public void testgroupSum6(){
		int[] nums={5, 6, 2};
		System.out.println(groupSum6(0, nums, 8));
		System.out.println(groupSum6(0, nums, 9));
		System.out.println(groupSum6(0, nums, 7));
	}

	public void testgroupNoAdj(){
		int[] nums={2, 5, 10, 4};
		System.out.println(groupNoAdj(0, nums, 12));
		System.out.println(groupNoAdj(0, nums, 14));
		System.out.println(groupNoAdj(0, nums, 7));
		int[] nums1={2, 5, 10, 4, 2};
		System.out.println(groupNoAdj(0, nums1, 7));
		System.out.println(groupNoAdj(0, nums1, 9));
		int[] nums2={5, 10, 4, 1};
		System.out.println(groupNoAdj(0, nums2, 11));
	}
	
	public void testgroupSum5(){
		int[] nums={2, 5, 10, 4};
		System.out.println(groupSum5(0, nums, 19));
		System.out.println(groupSum5(0, nums, 17));
		System.out.println(groupSum5(0, nums, 12));
		int[] nums1={3,5,1};
		System.out.println(groupSum5(0, nums1, 9));
	}
}