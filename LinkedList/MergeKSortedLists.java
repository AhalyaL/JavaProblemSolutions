package LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class MergeKSortedLists {

	public static void main(String args[]) {

		ListNode ListNode1 = new ListNode(1);
		ListNode ListNode2 = new ListNode(2);
		ListNode1.next = ListNode2;
		ListNode ListNode3 = new ListNode(3);
		// ListNode2.next=ListNode3;
		ListNode ListNode4 = new ListNode(4);
		ListNode3.next = ListNode4;

		ListNode ListNode5 = new ListNode(5);
		// ListNode3.next = ListNode4;

		ListNode[] lists = new ListNode[3];
		lists[0] = ListNode1;
		lists[1] = ListNode3;
		lists[2] = ListNode5;

		ListNode head = mergeKLists(lists);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

	public static ListNode mergeKLists(ListNode[] lists) {
		ListNode resultHead = null;
		ListNode prevNode = null;
		int counter = 0;
		while (counter != lists.length) {
			counter = 0;
			ListNode minNode = null;
			int minIndex = 0;

			for (int i = 0; i < lists.length; i++) {

				ListNode node = lists[i];
				if (node == null) {
					counter++;
					continue;
				}
				if (minNode == null || node.val < minNode.val) {
					minNode = node;
					minIndex = i;
				}

			}
			if (minNode != null) {
				if (resultHead == null) {
					resultHead = minNode;
				} else {
					prevNode.next = minNode;
				}
				prevNode = minNode;
				lists[minIndex] = minNode.next;
			}
		}

		return resultHead;

	}

}
