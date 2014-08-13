package codingbat;

public class Array2 {
	
	private static Array2 my=new Array2();
	
	public static Array2 getInstance(){
		return my;
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
