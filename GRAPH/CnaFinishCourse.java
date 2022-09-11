package GRAPH;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class CnaFinishCourse {
	public static void main(String[] args) {

		int[][] prerequisites = { { 1, 0 }, { 2, 1 }, {0, 3 } };
		canFinish(5, prerequisites);
	}

	public static boolean canFinish(int numCourses, int[][] a) {

		HashMap<Integer, LinkedList<Integer>> hm = new HashMap<Integer, LinkedList<Integer>>();
		for (int i = 0; i < a.length; i++) {
			int e1 = a[i][1];
			int e2 = a[i][0];
			if (hm.get(e1) == null)
				hm.put(e1, new LinkedList());
			hm.get(e1).add(e2);

		}

		HashSet<Integer> hs = new HashSet<Integer>();

		boolean b = checkTree(hs, hm, 0);
		
			b = b && (hs.size() >= numCourses);
		System.out.println(b);
		return b;

	}

	private static boolean checkTree(HashSet<Integer> hs, HashMap<Integer, LinkedList<Integer>> hm, int key) {

		hs.add(key);
		if (hm.get(key) == null)
			return true;
		for (int vals : hm.get(key)) {

			if (hs.contains(vals))
				return false;

			if(!checkTree(hs, hm, vals))return false;

		}
		return true;

	}
}
