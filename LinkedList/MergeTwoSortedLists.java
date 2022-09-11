package LinkedList;

public class MergeTwoSortedLists {
	public static void main(String args[]) {

		ListNode ListNode1 = new ListNode(1);
		ListNode ListNode2 = new ListNode(2);
		ListNode1.next = ListNode2;
		ListNode ListNode3 = new ListNode(3);
		// ListNode2.next=ListNode3;
		ListNode ListNode4 = new ListNode(4);
		ListNode3.next = ListNode4;
		ListNode head = mergeTwoLists(ListNode1, ListNode3);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}

	}

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode result = null;
		ListNode head = null;
		// if(list1!=null && list2!=null)return result;
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;

		while (list1 != null || list2 != null) {
			if (list1 == null) {
				result.next = list2;

				list2 = list2.next;
				break;
			}
			if (list2 == null) {
				result.next = list1;

				list1 = list1.next;
				break;
			}
			if (list1.val < list2.val) {
				if (result == null) {
					result = list1;
					head = list1;
				} else {
					result.next = list1;
					result = result.next;
				}

				list1 = list1.next;
			} else {
				if (result == null) {
					result = list2;
					head = list2;
				} else {
					result.next = list2;
					result = result.next;
				}

				list2 = list2.next;
			}
			// result=result.next;
		}

		return head;

	}

}
