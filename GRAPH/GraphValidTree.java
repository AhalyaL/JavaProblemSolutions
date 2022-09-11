package GRAPH;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class GraphValidTree {

	public static void main(String[] args) {
		//int[][] a = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
		int[][] a= {{0,1},{1,2}, {2,3}, {1,3}, {1,4}};
		checkifGraphIsValidTree(a);
	}

	private static void checkifGraphIsValidTree(int[][] a) {
		HashMap<Integer, LinkedList<Integer>> hm = new HashMap<Integer, LinkedList<Integer>>();
		for (int i = 0; i < a.length; i++) {
			int e1 = a[i][0];
			int e2 = a[i][1];
			if (hm.get(e1) == null)
				hm.put(e1, new LinkedList());
			hm.get(e1).add(e2);
			if (hm.get(e2) == null)
				hm.put(e2, new LinkedList());
			hm.get(e2).add(e1);

		}

		HashSet<Integer> hs = new HashSet<Integer>();

		boolean b = checkTree(hs, hm, hm.keySet().stream().findFirst().get(), 0);
		if (hs.size() != hm.size())
			b = b && false;
		System.out.println(b);

	}

	private static boolean checkTree(HashSet<Integer> hs, HashMap<Integer, LinkedList<Integer>> hm, int key,
			int parent) {

		hs.add(key);

		for (int vals : hm.get(key)) {

			if (parent == vals)
				continue;

			if (hs.contains(vals))
				return false;

			checkTree(hs, hm, vals, key);

		}
		return true;

	}

}
