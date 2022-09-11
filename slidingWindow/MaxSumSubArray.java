package slidingWindow;

public class MaxSumSubArray {
	public static void main(String[] args) {
		int[] a = { -1};
		System.out.println(maxSubArray(a));
	}
	   public static int maxSubArray(int[] nums) {
		   
		   int max=nums[0],subMax=0;
		   for(int i=0;i<nums.length;i++) {
			   if(subMax<0)
				   subMax=0;
			   subMax = subMax+nums[i];
			  
			  max = Math.max(max, subMax);
			   
		   }
	     
		   return max;
	    }

}
