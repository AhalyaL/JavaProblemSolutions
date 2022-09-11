package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {
	List<List<Edge>> adjList = null;
	List<List<Node>> nodes = null;
	Graph(List<Edge> edges, int n ) {
		adjList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}

		for (Edge edge : edges) {
			adjList.get(edge.source).add(edge);
		}
	}

	Graph(List<Edge> edges, int n, boolean bidirectional) {
		nodes = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			nodes.add(new ArrayList<>());
		}

		for (Edge edge : edges) {
			nodes.get(edge.source).add(new Node(edge.dest,edge.w));
			nodes.get(edge.dest).add(new Node(edge.source,edge.w));
		}
	}
}
