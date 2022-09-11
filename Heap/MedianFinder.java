package Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		int[] data = { 1, 2, 10, 4, 5, 6, 7, 8 };
		int median = 0;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());

		for (int i : data) {

			if (maxHeap.size() == minHeap.size()) {
				maxHeap.offer(i);
				minHeap.offer(maxHeap.poll());

			} else {
				minHeap.offer(i);
				maxHeap.offer(minHeap.poll());

			}

		}

		if (maxHeap.size() == minHeap.size()) {
			median = (maxHeap.peek() + minHeap.peek()) / 2;

		} else {
			median = minHeap.peek();
		}

		System.out.println(median);

	}

}
