package Trees;

public class MaxDepthOfTree {

	public static void main(String[] args) {

		Integer[] root = { 3, 9, 20, null, null, 15, 7 };
		TreeNode node = Helper.formTreeBST(root,0);
		Helper.printTree(node);
		int depth = findMaxDepth(node);
		System.out.println(depth);
	}

	private static int findMaxDepth(TreeNode node) {
		if (node == null)
			return 0;
		else {
			int left = findMaxDepth(node.left) + 1;
			int right = findMaxDepth(node.right) + 1;
			return Integer.max(left, right);
		}

	}
}
