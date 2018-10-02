package com.leetcode.problems.binarysearchtree.medium;

import java.util.TreeMap;

/**
 * https://leetcode.com/problems/my-calendar-ii/description/
 */
@SuppressWarnings("ConstantConditions")
public class MyCalendarII {

	/**
	 * Your MyCalendarTwo object will be instantiated and called as such:
	 * MyCalendarTwo obj = new MyCalendarTwo();
	 * boolean param_1 = obj.book(start,end);
	 */
	class MyCalendarTwo {

		private TreeMap<Integer, Integer> delta;

		public MyCalendarTwo() {
			delta = new TreeMap<>();
		}

		public boolean book(int start, int end) {
			delta.put(start, delta.getOrDefault(start, 0) + 1);
			delta.put(end, delta.getOrDefault(end, 0) - 1);

			int active = 0;
			for (int d : delta.values()) {
				active += d;
				if (active >= 3) {
					delta.put(start, delta.get(start) - 1);
					delta.put(end, delta.get(end) + 1);
					if (delta.get(start) == 0)
						delta.remove(start);
					return false;
				}
			}
			return true;
		}
	}

}