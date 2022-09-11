package slidingWindow;

import java.util.HashMap;
import java.util.HashSet;

public class Fruitsbasket {

	public static void main(String[] args) {
		int[] fruits = { 3,3,3,1,2,1,1,2,3,3,4 };
		//int[] fruits = { 1,2,3,2,2 };
		System.out.println(totalFruit(fruits));
	}

	public static int totalFruit(int[] fruits) {
		int i = 0, j = 0, counter = 0,max=0;
		HashMap<Integer, Integer> set = new HashMap<Integer, Integer>();
		while (j < fruits.length) {
			
			set.put(fruits[j], set.getOrDefault(fruits[j],0)+1);
			
			while (set.size() > 2) {
				set.put(fruits[i],set.get(fruits[i])-1);
				if(set.get(fruits[i])==0) {set.remove(fruits[i]);}
				i++;
			}
			max=Math.max(max, j-i+1);
			j++;
		}

		return max;
	}

}
