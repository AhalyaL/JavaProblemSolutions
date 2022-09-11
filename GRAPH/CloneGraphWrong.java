package GRAPH;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraphWrong {
	public static void main(String[] args) {
		int[][] g = { { 2, 4 }, { 1, 3 }, { 2, 4 }, { 1, 3 } };

		Node node = cloneGraph(g);
		System.out.println(node.val);
		
	}

	private static Node cloneGraph(int[][] g) {
		HashMap<Integer, Node> hm = new HashMap<Integer, Node>();
		for (int i = 0; i < g.length; i++) {
			Node n1 = hm.getOrDefault(g[i][0], new Node(g[i][0]));
			Node n2 = hm.getOrDefault(g[i][1], new Node(g[i][1]));
			Node keyNode = hm.getOrDefault(i+1, new Node(i+1));
			keyNode.neighbors.add(n1);
			keyNode.neighbors.add(n2);
			hm.put(i+1, keyNode);
		}
		HashMap<Integer, Node> res = new HashMap<Integer, Node>();

		hm.entrySet().forEach((set) -> {
			Node keyNode = res.getOrDefault(set.getKey(), new Node(set.getKey()));
			set.getValue().neighbors.forEach(node -> {
				keyNode.neighbors.add(res.getOrDefault(node.val, new Node(node.val)));
			});
			res.put(set.getKey(), keyNode);
		});
		return res.get(1);

	}

}
