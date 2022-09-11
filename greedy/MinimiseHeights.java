package greedy;

import java.util.Arrays;

public class MinimiseHeights {
public static void main(String[] args) {
	int a[]={1, 5, 8, 10};
	System.out.println(minimiseHeights(a));

}

private static int minimiseHeights(int[] a) {

	Arrays.sort(a);
	int min =a[0];
	int max=a[0];
	for(int i=0;i<a.length;i++) {
		min = Math.min(min, a[i]);
		max=Math.max(max, a[i]);
		
	}
	return max-min;
}
}
