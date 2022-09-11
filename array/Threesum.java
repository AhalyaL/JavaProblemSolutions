package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Threesum {
	public static void main(String[] args) {
		int[] nums= {0,1,2,-1,-4};int total = 0;
	//	int[] nums= {0,0,0};int total = 0;
		List<List<Integer>> list=	threeSum( nums, total);
		list.stream().forEach(x -> System.out.println(x));
	}
	  public static List<List<Integer>> threeSum(int[] nums,int total) {
		  List<List<Integer>> list = new ArrayList<List<Integer>>();
		  HashSet unique = new HashSet();
		 
		  if(nums ==null || nums.length==0 || nums.length<=2) return list;
		  for(int i=0;i<nums.length-2;i++) {
			  
			  HashSet set = new HashSet();
			  int sum = total - nums[i];
			  for(int j=0;j<nums.length;j++) {
				  if(i==j)continue;
                   int  curr=sum-nums[j]; 
				  if(set.contains(curr)) {
					  ArrayList<Integer> l = new ArrayList<Integer>();
					  l.add(nums[i]);l.add(nums[j]);l.add(curr);
					  list.add(l);
				  }
				  	
				  set.add(nums[j]);
			  }
		  }
		  
		  
		  
		  return list;
	    }

}
