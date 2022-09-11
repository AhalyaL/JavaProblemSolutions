package Trees;

public class SameTree {
	public static void main(String[] args) {
		Integer[] p = { 1, 2, 5, 3 };
		Integer[] q = { 1, 2, 3, 3 };

		TreeNode a = Helper.formTreeBST(p, 0);
		TreeNode b = Helper.formTreeBST(q, 0);
		boolean res = checkSameTree(a, b);
		System.out.println(res);
	}

	private static boolean checkSameTree(TreeNode a, TreeNode b) {
		if (a == null && b == null)
			return true;
		if (a == null || b == null)
			return false;

		if (a.val == b.val) {
			return checkSameTree(a.left, b.left) && checkSameTree(a.right, b.right);
		}

		return false;
	}
}
