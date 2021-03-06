package com.algorithm.playground.leetcode.problems.lc100.lc140.lc148;

import com.algorithm.playground.leetcode.problems.utils.linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/sort-list/description/
 */
public class SortList {

	class Solution {
		public ListNode sortList(ListNode head) {
			Queue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
			while (head != null) {
				heap.offer(head);
				head = head.next;
			}

			if (heap.isEmpty()) {
				return null;
			}

			head = heap.poll();
			ListNode tmp = head;
			while (!heap.isEmpty()) {
				tmp.next = heap.poll();
				tmp = tmp.next;
			}
			tmp.next = null;
			return head;
		}
	}

}
