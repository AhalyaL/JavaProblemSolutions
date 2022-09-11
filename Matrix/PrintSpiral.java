package Matrix;

import java.util.ArrayList;
import java.util.List;

public class PrintSpiral {
	public static void main(String[] args) {
	//	int[][] matrix = { { 1, 2, 3 ,4 }, {  5, 6,7,8 }, {  9, 10,11,12 },{13,14,15,16}};
	//	int[][] matrix = { { 1, 2, 3 ,4 }, {  5, 6,7,8 }, {  9, 10,11,12 }, { 13,14,15,16 }, { 17,18,19,20 }, {21,22,23,24 }};
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 } ,{7,8,9}};
		System.out.println(spiralOrder(matrix));

	}

	public static List<Integer> spiralOrder(int[][] m) {
		List<Integer> l = new ArrayList<Integer>();
		int rows = m.length;
		int cols = m[0].length;
		printSpiral(l, rows, cols, 0, 0, m);

		return l;

	}

	private static void printSpiral(List<Integer> l, int r, int c, int sr, int sc, int[][] m) {
		if (r <= 0 && c <= 0)
			return;
		int i = sr;
		while (i < c ) {
			l.add(m[sr][i]);
			i++;
		}
		int j = sc+1;
		while (j < r ) {
			l.add(m[j][c-1]);
			j++;
		}
		i = c - 2;
		
		
		while (i >= sc ) {
			l.add(m[r-1][i]);
			i--;
		}
		j = r-2;
		while (j > sr) {
			l.add(m[j][sc]);
			j--;
		}
		

		printSpiral(l, r - 1, c - 1, ++sr, ++sc, m);
	}
	

  
}
