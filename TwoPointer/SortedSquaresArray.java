package TwoPointer;

public class SortedSquaresArray {
	public static void main(String args[]) {
		int[] nums = { -9, -2, 3, 1, 5 };
		int[] index = sortedSquares(nums);

	}
	
	  public static int[] sortedSquares(int[] nums) {
		  
			for (int i=0; i < nums.length; i++) {
				nums[i] = nums[i] * nums[i];
			}
			
		  
		return sort(nums);
	        
	    }

	private static int[] sort(int[] nums) {
		int  temp;
        boolean swapped = false;
		for (int i=0; i < nums.length-1; i++) {
			for (int j=0;j < nums.length-1; j++) {
				 if (nums[j] > nums[j + 1])
	                {
	                    // swap nums[j] and nums[j+1]
	                    temp = nums[j];
	                    nums[j] = nums[j + 1];
	                    nums[j + 1] = temp;
	                    swapped = true;
	                }
			}
			if (swapped == false)
                break;
		}
		
		return nums;
	}
	 static void printArray(int arr[], int size)
	    {
	        int i;
	        for (i = 0; i < size; i++)
	            System.out.print(arr[i] + ' ');
	        System.out.println();
	    }

}
