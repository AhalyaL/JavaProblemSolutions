package GRAPH;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class ConnectedComponentsInGraph {

	public static void main(String[] args) {
		// int[][] a = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
		int[][] a = { { 0, 1 }, { 1, 2 }, { 3, 4 } };
		connComponents(a);
	}

	private static void connComponents(int[][] a) {
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
		for (int vals : hm.keySet()) {
			if (!hs.contains(vals))
				checkTree(hs, hm, vals);

			System.out.println("\n");
			;
		}

	}

	private static void checkTree(HashSet<Integer> hs, HashMap<Integer, LinkedList<Integer>> hm, int key) {
		System.out.print(key);
		hs.add(key);

		for (int vals : hm.get(key)) {

			if (hs.contains(vals))
				continue;

			checkTree(hs, hm, vals);

		}

	}
}
