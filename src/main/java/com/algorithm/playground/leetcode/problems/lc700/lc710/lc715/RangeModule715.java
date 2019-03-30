package com.algorithm.playground.leetcode.problems.lc700.lc710.lc715;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/range-module/description/
 */
public class RangeModule715 {

	/**
	 * Your RangeModule object will be instantiated and called as such:
	 * RangeModule obj = new RangeModule();
	 * obj.addRange(left,right);
	 * boolean param_2 = obj.queryRange(left,right);
	 * obj.removeRange(left,right);
	 */
	class RangeModule {

		private TreeSet<Interval> ranges;

		public RangeModule() {
			ranges = new TreeSet<>();
		}

		public void addRange(int left, int right) {
			Iterator<Interval> itr = ranges.tailSet(new Interval(0, left - 1)).iterator();
			while (itr.hasNext()) {
				Interval iv = itr.next();
				if (right < iv.left) {
					break;
				}
				left = Math.min(left, iv.left);
				right = Math.max(right, iv.right);
				itr.remove();
			}
			ranges.add(new Interval(left, right));
		}

		public boolean queryRange(int left, int right) {
			Interval iv = ranges.higher(new Interval(0, left));
			return (iv != null && iv.left <= left && right <= iv.right);
		}

		public void removeRange(int left, int right) {
			Iterator<Interval> itr = ranges.tailSet(new Interval(0, left)).iterator();
			ArrayList<Interval> todo = new ArrayList<>();
			while (itr.hasNext()) {
				Interval iv = itr.next();
				if (right < iv.left) {
					break;
				}
				if (iv.left < left) {
					todo.add(new Interval(iv.left, left));
				}
				if (right < iv.right) {
					todo.add(new Interval(right, iv.right));
				}
				itr.remove();
			}
			ranges.addAll(todo);
		}
	}

	class Interval implements Comparable<Interval> {
		int left;
		int right;

		public Interval(int left, int right) {
			this.left = left;
			this.right = right;
		}

		public int compareTo(Interval that) {
			if (this.right == that.right) {
				return this.left - that.left;
			}
			return this.right - that.right;
		}
	}

}
