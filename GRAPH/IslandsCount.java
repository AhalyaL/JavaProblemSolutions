package GRAPH;

public class IslandsCount {
	public static void main(String[] args) {
		char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '1' } };

		System.out.println(numIslands(grid));
	}

	public static int numIslands(char[][] grid) {
		int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (!visited[i][j] && grid[i][j] == '1') {
					countIslands(grid, i, j, visited, dirs);
					count++;
				}
			}
		}

		return count;

	}

	private static void countIslands(char[][] grid, int i, int j, boolean[][] visited, int[][] dirs) {
		visited[i][j] = true;
		for (int l = 0; l < dirs.length; l++) {

			int x = i + dirs[l][0], y = j + dirs[l][1];
			if (x < grid.length && y < grid[0].length && x >= 0 && y >= 0 && !visited[x][y] && grid[x][y] == '1') {
				countIslands(grid, x, y, visited, dirs);
			}

		}

	}
}
