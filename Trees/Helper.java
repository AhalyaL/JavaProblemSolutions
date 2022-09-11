package Trees;

public class Helper {
	static void printTree(TreeNode root) {
		System.out.println(root.val + "-->" + root.left + "----" + root.right);
		if (root.left != null)
			printTree(root.left);
		if (root.right != null)
			printTree(root.right);
	}

	static void printTreeString(TreeNode root) {

		if (root == null) return ;
			System.out.print(root.val + "," );
		   printTreeString(root.left); 
		   printTreeString(root.right); 
	}

	static TreeNode formTree(Integer[] nodes) {
		if (nodes == null || nodes.length == 0) {
			return null;
		}

		TreeNode root = new TreeNode(nodes[0]);

		for (int i = 1; i < nodes.length; i++) {
			if (nodes[i] == null)
				continue;

			addInTree(nodes[i], root);

		}

		return root;
	}

	private static void addInTree(Integer val, TreeNode root) {
		if (val > root.val) {
			if (root.right == null)
				root.right = new TreeNode(val);
			else
				addInTree(val, root.right);
		} else if (val < root.val) {
			if (root.left == null)
				root.left = new TreeNode(val);
			else
				addInTree(val, root.left);
		}

	}

	public static TreeNode formTreeBST(Integer[] arr, int i) {
		TreeNode root = null;
		if (i < arr.length) {
			if (arr[i] == null)
				return null;
			root = new TreeNode(arr[i]);

			// insert left child
			root.left = formTreeBST(arr, 2 * i + 1);

			// insert right child
			root.right = formTreeBST(arr, 2 * i + 2);
		}
		return root;
	}
}
