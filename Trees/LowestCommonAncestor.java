package Trees;

public class LowestCommonAncestor {
	public static void main(String[] args) {
		// Integer[] nodes = { 6, 2, 8, 0, 4, 7, 9, null, null, 3, 5 };
		Integer[] nodes = { 2, 1 };

		int p = 2, q = 1;

		TreeNode root = Helper.formTree(nodes);
		Helper.printTree(root);
		int k = findLCA(root, p, q);
		System.out.println(k);
	}

	private static int findLCA(TreeNode root, int p, int q) {

		if (p < root.val && q < root.val)
			return findLCA(root.left, p, q);
		if (p > root.val && q > root.val)
			return findLCA(root.right, p, q);

		return root.val;
	}

}
