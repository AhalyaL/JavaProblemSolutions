package Heap;

import java.util.PriorityQueue;

import LinkedList.ListNode;

public class MergeKSortedListsUsingHeap {
	public static void main(String[] args) {
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
		lists[0] = ListNode5;
		lists[1] = ListNode3;
		lists[2] = ListNode1;

		ListNode head = mergeKLists(lists);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
		// a mergeKLists();
	}

	public static ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> Integer.compare(a.val, b.val));
		int counter = 0;
		while (counter < lists.length) {
			for (int i = 0; i < lists.length; i++) {

				ListNode l = lists[i];
				if (l == null) {
					counter++;
					continue;
				}

				pq.offer(l);
				lists[i] = l.next;
			}

		}
		ListNode head = pq.peek();
		ListNode l = pq.poll();
		while (pq.peek() != null) {

			l.next = pq.poll();
			;
			l = l.next;
		}
		return head;

	}
}
