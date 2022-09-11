package Trees;

public class BinaryTreeTraversal {
	public static void main(String[] args) {
		Integer[] root = { 1, 2, 3, 4, 5 };
		TreeNode node = Helper.formTreeBST(root, 0);
		// Helper.printTree(node);

		inordertravesal(node);
		System.out.println("");
		preordertravesal(node);
		System.out.println("");
		postordertravesal(node);
	}

	private static void inordertravesal(TreeNode node) {

		if (node == null)
			return;

		inordertravesal(node.left);
		System.out.print(node.val);
		inordertravesal(node.right);
	}

	private static void preordertravesal(TreeNode node) {

		if (node == null)
			return;
		System.out.print(node.val);
		preordertravesal(node.left);

		preordertravesal(node.right);
	}

	private static void postordertravesal(TreeNode node) {

		if (node == null)
			return;

		postordertravesal(node.left);

		postordertravesal(node.right);
		System.out.print(node.val);
	}
}
