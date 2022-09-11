package Trees;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxLengthRootToLevPath {
	public static void main(String[] args) {
		Integer[] root = { 1, 2, 3, 4, 5, 6, 7 };
		TreeNode node = Helper.formTreeBST(root, 0);
		ArrayList<Integer> paths = new ArrayList<Integer>();
		int[] a = new int[100];
		maxPath(node, a, 0);
	}

	private static void maxPath(TreeNode node, int[] a, int i) {
		
		a[i] = node.val;
		i = i + 1;
		if (node.left == null && node.right==null) {
			printpath(a, i);
			return;
		}
		
		maxPath(node.left, a, i);
		maxPath(node.right, a, i);
	}

	private static void printpath(int[] a, int i) {
		for(int k=0;k<i;k++)
		System.out.print(a[k]);
		
		System.out.println("");
	}
}
