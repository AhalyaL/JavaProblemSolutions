package GRAPH;

import java.util.ArrayList;
import java.util.List;

public class AtlanticPacificMeet {
	public static void main(String[] args) {
		int[][] a = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 }, { 5, 1, 1, 2, 4 } };
		List l = pacificAtlantic(a);

		System.out.println(l);
	}

	public static List<List<Integer>> pacificAtlantic(int[][] heights) {

		int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		 if (heights == null || heights.length == 0 || heights[0].length == 0) return result;
		boolean[][] atlanticv = new boolean[heights.length][heights[0].length];
		boolean[][] pacificv = new boolean[heights.length][heights[0].length];

		for (int i = 0; i < heights.length; i++) {
			pacificv[0][i] = true;
			atlanticv[heights.length - 1][i] = true;
			// visited[0][i] = true;
			// visited[heights.length - 1][i] = true;
		}
		for (int i = 0; i < heights[0].length; i++) {
			pacificv[i][0] = true;
			atlanticv[i][heights[0].length - 1] = true;
			// visited[i][0] = true;
			// visited[i][heights.length - 1] = true;
		}

		for (int i = 0; i < heights.length; i++) {

			explore(0, i, heights, pacificv, dirs);
			explore(heights.length - 1, i, heights, atlanticv, dirs);
		}
		for (int i = 0; i < heights[0].length; i++) {

			explore(i, 0, heights, pacificv, dirs);
			explore(i, heights[0].length - 1, heights, atlanticv, dirs);
		}

		for (int i = 0; i < heights.length; i++) {

			for (int j = 0; j < heights[0].length; j++) {

				if (pacificv[i][j] == true && atlanticv[i][j] == true) {
					List<Integer> l = new ArrayList<Integer>();
					l.add(i);
					l.add(j);
					result.add(l);
				}

			}
		}

		return result;

	}

	private static void explore(int i, int j, int[][] heights, boolean[][] ocean, int[][] dirs) {
		for (int l = 0; l < dirs.length; l++) {

			int x = i + dirs[l][0], y = j + dirs[l][1];
			if (x < heights.length && y < heights[0].length && x >= 0 && y >= 0) {
				if (ocean[x][y] != true && heights[x][y] >= heights[i][j]) {
					ocean[x][y] = true;
					explore(x, y, heights, ocean, dirs);
				}
			}

		}

	}

}
