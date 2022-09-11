package LinkedList;

public class RemoveNnodeFromEnd {
	public static void main(String args[]) {

		ListNode ListNode1=new ListNode(1);
		ListNode ListNode2=new ListNode(2);
		ListNode1.next=ListNode2;
		ListNode ListNode3=new ListNode(3);
		ListNode2.next=ListNode3;
		ListNode ListNode4=new ListNode(4);
		ListNode3.next=ListNode4;
		
		ListNode head = removeNthFromEnd(ListNode1,2);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
		
	}
	 public static ListNode removeNthFromEnd(ListNode head, int n) {
		 ListNode ptr1=head;
		 ListNode ptr2 = head;
		 ListNode prev = head;
		int i=0;
		if(ptr1==null) {
			return null;
		}
		 while(ptr1!=null&& i<n) {
			 ptr1=ptr1.next;
			 i++;
		 }
		 int count = n-i;
		 if(count!=0) {
			 return head;
		 }else if(count==0 && ptr1==null) {
			 return head.next;
		 }
		 
		 while(ptr1!=null) {
			 prev = ptr2;
			 ptr1=ptr1.next;
			 ptr2=ptr2.next;
		 }
		 prev.next=ptr2.next;
		 ptr2.next=null;
		
		 
		 
		return head;
	        
	    }

}
