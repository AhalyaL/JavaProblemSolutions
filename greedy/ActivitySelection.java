package greedy;

import java.util.ArrayList;
import java.util.List;

public class ActivitySelection {
	public static void main(String[] args) {
		int start[] = { 1, 3, 0, 5, 8, 5 };
		int finish[] = { 2, 4, 6, 7, 9, 9 };

		List<ArrayList<Integer>> l = selection(start, finish, 4);
		l.stream().forEach(x -> System.out.println(x));
	}

	private static List<ArrayList<Integer>> selection(int[] start, int[] finish, int k) {
		List<ArrayList<Integer>> l = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		l1.add(start[0]);
		l1.add(finish[0]);
		l.add(l1);
		int g=0;
		for (int e = 1; e < finish.length; e++) {
			if (l.size() == k)
				break;
			if (start[e] > finish[g]) {
				l1 = new ArrayList<Integer>();
				l1.add(start[e]);
				l1.add(finish[e]);
				l.add(l1);
				g=e;
			}

		}
		return l;
	}
}
