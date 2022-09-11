package Trees;

public class ReverseTree {
	public static void main(String[] args) {
		Integer[] root = { 4, 2, 7, 1, 3, 6, 9 };

		TreeNode node = Helper.formTreeBST(root, 0);
		Helper.printTreeString(node);
		reverseTree(node);
		System.out.println("/n");
		Helper.printTreeString(node);
	}

	private static void reverseTree(TreeNode node) {
		if (node == null)
			return;

		TreeNode t = node.left;
		node.left = node.right;
		node.right = t;

		reverseTree(node.left);
		reverseTree(node.right);

	}

}
