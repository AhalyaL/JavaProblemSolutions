package Trees;

public class MaxPathSum {
public static void main(String[] args) {
	Integer[] root = { 1,2,3 };
	TreeNode node = Helper.formTreeBST(root,0);
	findMaxSumPath(node,0);
	
}

private static int findMaxSumPath(TreeNode node, int sum) {

	if(node==null)return 0;
	int l=findMaxSumPath( node.left,sum);
	int r=findMaxSumPath( node.right,sum);
	
	int s1=Math.max(Math.max(l, r)+node.val, node.val);
	int s2=Math.max(r+l+node.val, s1);
	sum = Math.max(sum, s2);
	System.out.println(sum);
	return s1;
}
}
