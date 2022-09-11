package LinkedList;

public class ReorderLinkedList {

	public static void main(String args[]) {

		ListNode ListNode1 = new ListNode(1);
		ListNode ListNode2 = new ListNode(2);
		ListNode1.next = ListNode2;
		ListNode ListNode3 = new ListNode(3);
		 ListNode2.next = ListNode3;
		ListNode ListNode4 = new ListNode(4);
		ListNode3.next = ListNode4;
		ListNode ListNode5 = new ListNode(5);
		ListNode4.next = ListNode5;
		ListNode head = reorderList(ListNode1);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}

	}

	public static ListNode reorderList(ListNode head) {
		ListNode ptr1 = head;
		ListNode ptr2 = head;
		ListNode oldHead = head;

		while (ptr1 != null && ptr1.next != null) {
			ptr1 = ptr1.next.next;
			ptr2 = ptr2.next;
		}
		ListNode newListNodeHead = ptr2.next;
		if (newListNodeHead == null)
			return head;
		ptr2.next = null;
		ListNode newHead = reverseLinkedList(newListNodeHead);
		ListNode firstNext = oldHead.next;
		ListNode secondNext = newHead.next;
		while (oldHead != null && newHead != null) {
			firstNext = oldHead.next;
			secondNext = newHead.next;

			oldHead.next = newHead;
			newHead.next = firstNext;

			oldHead = firstNext;
			newHead = secondNext;
		}

		return head;

	}

	private static ListNode reverseLinkedList(ListNode head) {

		ListNode temp = null;
		ListNode prev = head;
		ListNode ListNode = head.next;
		head.next = null;

		while (ListNode != null) {
			temp = ListNode.next;
			ListNode.next = prev;
			prev = ListNode;
			ListNode = temp;

		}
		return prev;
	}

}
