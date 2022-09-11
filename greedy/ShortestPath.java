package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPath {
	public static void main(String[] args) {
		List<Edge> edges = Arrays.asList(new Edge(0, 1, 10), new Edge(0, 4, 3), new Edge(1, 2, 2), new Edge(2, 3, 9),
				new Edge(4, 1, 1), new Edge(4, 2, 8), new Edge(4, 3, 2) , new Edge(5, 6, 2));

		int n = 7;
		Graph g = new Graph(edges, n,true);
	//	findShortestPath1(g.adjList, n, 1);
		findShortestPath(g.nodes, n, 5);
	}

	private static void findShortestPath(List<List<Node>> list, int n, int i) {
		int[] dist = new int[n];

		Arrays.fill(dist, Integer.MAX_VALUE);

		PriorityQueue<Node> pq = new PriorityQueue<Node>(Comparator.comparingInt(Node::getWeight));

		dist[i] = 0;
		list.get(i).forEach(x -> {
			pq.add(new Node(x.val, x.weight));
		});

		while (!pq.isEmpty()) {
			Node node = pq.poll();

			if (dist[node.val] > node.weight) {
				dist[node.val] = node.weight;

				list.get(node.val).forEach(x -> {
					if (node.val != x.val)
						pq.add(new Node(x.val, x.weight + dist[node.val]));
				});

			}

		}
		System.out.println(Arrays.toString(dist));
		
	}

	private static void findShortestPath1(List<List<Edge>> list, int n, int i) {
		int[] dist = new int[n];

		Arrays.fill(dist, Integer.MAX_VALUE);

		PriorityQueue<Node> pq = new PriorityQueue<Node>(Comparator.comparingInt(Node::getWeight));

		dist[i] = 0;
		list.get(i).forEach(x -> {
			pq.add(new Node(x.dest, x.w));
		});

		while (!pq.isEmpty()) {
			Node node = pq.poll();

			if (dist[node.val] > node.weight) {
				dist[node.val] = node.weight;

				list.get(node.val).forEach(x -> {
					if (node.val != x.dest)
						pq.add(new Node(x.dest, x.w + dist[node.val]));
				});

			}

		}
		System.out.println(Arrays.toString(dist));
	}

}
