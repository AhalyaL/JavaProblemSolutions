package Trees;

public class BSTSubTree {
	public static void main(String[] args) {
		Integer[] p = { 1, 2, 5, 3 };
		Integer[] q = { 2, 3 ,6 };

		TreeNode a = Helper.formTreeBST(p, 0);
		TreeNode b = Helper.formTreeBST(q, 0);
		boolean res = checkSubTree(a, b);
		System.out.println(res);
	}

	private static boolean checkSubTree(TreeNode a, TreeNode b) {
        if(a==null)return false;
		if (a.val == b.val) {
			return checkSameTree(a, b);
		} else {
			return checkSubTree(a.left, b) ||
			checkSubTree(a.right, b);
		}

	}

	private static boolean checkSameTree(TreeNode a, TreeNode b) {
		if (a == null && b == null)
			return true;
		if (a != null && b == null)
			return true;

		if (a == null && b != null)
			return false;

		if (a.val == b.val) {
			return checkSameTree(a.left, b.left) && checkSameTree(a.right, b.right);
		}

		return false;
	}
}
