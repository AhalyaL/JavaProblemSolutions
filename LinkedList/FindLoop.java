package LinkedList;

import java.util.ArrayList;
import java.util.List;

public class FindLoop {
	public static void main(String args[]) {

		ListNode ListNode1=new ListNode(1);
		ListNode ListNode2=new ListNode(2);
		ListNode1.next=ListNode2;
		ListNode ListNode3=new ListNode(3);
		ListNode2.next=ListNode3;
		ListNode ListNode4=new ListNode(4);
		ListNode3.next=ListNode4;
		//ListNode4.next=ListNode2;
	System.out.print(hasCycle(ListNode1));	;
		
	}
	 public static boolean  hasCycle(ListNode head) {
	        ArrayList<ListNode> list = new ArrayList<ListNode>();
	        
	        
	        while(head!=null) {
	        	final ListNode node=head;
	        	if(list.stream().anyMatch(p->p.val==node.val))
	        		return true;
	        	head = head.next;
	        	list.add(node);
	        }
	        
			return false;
	        
	    }

}
