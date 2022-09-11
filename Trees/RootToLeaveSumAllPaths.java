package Trees;

import java.util.ArrayList;

public class RootToLeaveSumAllPaths {
	public static void main(String[] args) {
		Integer[] root = { 1, 2, 3, 4, 5, 6, 7 };
		TreeNode node = Helper.formTreeBST(root, 0);
		ArrayList<Integer> paths = new ArrayList<Integer>();
		findRootToLevSum(node, paths, 0);
		System.out.println(paths);
	}

	private static void findRootToLevSum(TreeNode node, ArrayList<Integer> paths, int sum) {

		sum = sum + node.val;
		if (node.left == null && node.right == null) {
			paths.add(sum);
			return;
		}
		findRootToLevSum(node.left, paths, sum);

		findRootToLevSum(node.right, paths, sum);
	}
}
