package LinkedList;

public class RverselinkedList {

	public static void main(String args[]) {

		ListNode ListNode1=new ListNode(1);
		ListNode ListNode2=new ListNode(2);
		ListNode1.next=ListNode2;
		ListNode ListNode3=new ListNode(3);
		ListNode2.next=ListNode3;
		ListNode ListNode4=new ListNode(4);
		ListNode3.next=ListNode4;
		
		reverseAndPrint(ListNode1);
		
	}

	private static void reverseAndPrint(ListNode head) {
		ListNode temp =null;
		ListNode prev =head;
		ListNode ListNode=head.next;
		head.next=null;
		
		
		while(ListNode!=null) {
		 temp =	ListNode.next;
		ListNode.next=prev;
		prev=ListNode;
		ListNode=temp;
		
		}
		

		while(prev!=null) {
		 
			System.out.println(prev.val);
			prev=prev.next;
		}
		
		
		
	}
}
