package Matrix;

public class SearchWordInMatrix {
	public static void main(String[] args) {

		//char[][] m = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
	//char[][] m = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};

char[][] m = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
		String w = "ABCESEEEFS";
		System.out.println(searchWord(m, w));
	}

	private static boolean searchWord(char[][] m, String w) {

		int[] r = { 1, -1, 0, 0 };
		int[] c = { 0, 0, -1, 1 };
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				int[][] visited = new int[m.length][m[0].length];
				if (searchChar(0, i, j, r, c, w, m, visited))
					return true;
			}
		}
		return false;

	}

	private static boolean searchChar(int pos, int i, int j, int[] r, int[] c, String w, char[][] m, int[][] visited) {

		if (w.charAt(pos) != m[i][j]) {
			visited[i][j] = 0;
			return false;
		}
		visited[i][j] = 1;

		if (++pos == w.length())
			return true;

		for (int dir = 0; dir < r.length; dir++) {
			int i1 = i + r[dir];
			int j1 = j + c[dir];
			if (i1 >= 0 && j1 >= 0 && i1 < m.length && j1 < m[i1].length && visited[i1][j1] != 1) {
				if (searchChar(pos, i1, j1, r, c, w, m, visited))
					return true;
				
			}
		}
	    visited[i][j] = 0;
		return false;
	}
}
