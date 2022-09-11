package Matrix;

import java.util.ArrayList;
import java.util.List;

public class SetZerosRowAndCol {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		setZeroes(matrix);
	}

	public static void setZeroes(int[][] matrix) {
		List rows = new ArrayList();
		List cols = new ArrayList();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][j]=-1;
				}
			}
			}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {

				if (matrix[i][j] == -1) {
					if (!rows.contains(i)) {
						for (int k = 0; k < matrix[i].length; k++) {
							matrix[i][k] = 0;
						}
						rows.add(i);
					}
					if (!cols.contains(j)) {
						for (int l = 0; l < matrix[i].length; l++) {
							matrix[l][j] = 0;
						}
						cols.add(j);
					}
				}

			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.print('\n');
			
		}
		
	}

}
