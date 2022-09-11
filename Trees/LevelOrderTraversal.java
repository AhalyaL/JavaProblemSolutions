package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
public static void main(String[] args) {
	Integer[] root = { 3, 9, 20, null, null, 15, 7 };
	TreeNode node = Helper.formTreeBST(root,0);
    
	Queue<TreeNode> q = new LinkedList<>();
	
	q.add(node);
	
	levelOrderTraversal(q);
	
	
	
}

private static void levelOrderTraversal(Queue<TreeNode> q) {

	
	while(!q.isEmpty()) {
		
		TreeNode node=q.poll();
		System.out.println(node.val);
		if(node.left!=null)q.add(node.left);
		if(node.right!=null)q.add(node.right);
		
		
	}
	
	
}
}
