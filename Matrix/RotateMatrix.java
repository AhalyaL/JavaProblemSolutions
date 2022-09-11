package Matrix;

public class RotateMatrix {
	public static void main(String[] args) {
		//int[][] m = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
	//	int[][] m = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
		int[][] m = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
	//	int[][] m = { { 1 }};
		rotate(m);
		for (int n = 0; n < m.length; n++) {
			for (int j = 0; j <  m.length; j++) {
				System.out.print(m[n][j]+"  ");
		}System.out.print("\n");
		}
		
	}

	private static void rotate(int[][] m) {
		int rows = m.length;
		int cols = rows;
		printSpiral(rows, cols, 0, 0, m ,m.length);

	}

	private static void printSpiral(int r, int c, int sr, int sc, int[][] m , int rotTimes) {

		if (r <= 0 && c <= 0)
			return;
		
		for (int n = 1; n < rotTimes; n++) {
			int i = sr, temp1 = m[sr][sc], temp2 = 0;
			
			while (i < c) {
				temp2 = m[sr][i];
				m[sr][i] = temp1;
				temp1 = temp2;
				i++;
			}
			int j = sc + 1;
			while (j < r) {
				temp2 = m[j][c - 1];
				m[j][c - 1] = temp1;
				temp1 = temp2;
				j++;
			}
			i = c - 2;

			while (i >= sc) {
				temp2 = m[r - 1][i];
				m[r - 1][i] = temp1;
				temp1 = temp2;
				i--;
			}
			j = r - 2;
			while (j > sr) {
				temp2 = m[j][sc];
				m[j][sc] = temp1;
				temp1 = temp2;
				j--;
			}
			m[sr][sc] = temp1;
		}

		printSpiral(r - 1, c - 1, ++sr, ++sc, m, rotTimes-2);

	}

}
