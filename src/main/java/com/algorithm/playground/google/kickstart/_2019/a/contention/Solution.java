package com.algorithm.playground.google.kickstart._2019.a.contention;

import java.util.*;
import java.util.Map.Entry;

/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000050e01/0000000000069881
 */
@SuppressWarnings("Duplicates")
public class Solution {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				//number of seats
				int n = console.nextInt();
				//number of intervals
				int q = console.nextInt();
				int[][] intervals = readIntervals(console, new int[q][2]);
				int ans = solve(intervals, n);
				System.out.println(String.format("Case #%s: %s", test, ans));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	static int solve(int[][] intervals, int n) {
		TreeMap<Integer, Integer> points = new TreeMap<>();
		for (int[] interval : intervals) {
			points.put(interval[0], points.getOrDefault(interval[0], 0) + 1);
			points.put(interval[1] + 1, points.getOrDefault(interval[1] + 1, 0) - 1);
		}

		int[] seats = new int[n + 2];
		Arrays.fill(seats, -1);
		int val = 0;
		for (Entry<Integer, Integer> entry : points.entrySet()) {
			val += entry.getValue();
			seats[entry.getKey()] = val;
		}

		val = 0;
		for (int i = 0; i < seats.length; i++) {
			if (seats[i] != -1) {
				val = seats[i];
			} else {
				seats[i] = val;
			}
		}

		SegmentTree tree = new SegmentTree(seats);
		Set<int[]> rest = new HashSet<>();
		Collections.addAll(rest, intervals);
		int min = Integer.MAX_VALUE;
		while (!rest.isEmpty()) {
			int[] curr = next(tree, rest);
			rest.remove(curr);
			min = Math.min(min, tree.query(curr[0], curr[1]));
			if (min == 0) {
				break;
			}
			for (int i = curr[0]; i <= curr[1]; i++) {
				tree.decrease(i);
			}
		}
		return min;
	}

	private static int[] next(SegmentTree tree, Set<int[]> intervals) {
		int[] curr = null;
		int max = Integer.MIN_VALUE;
		for (int[] interval : intervals) {
			int sum = tree.query(interval[0], interval[1]);
			if (sum > max) {
				curr = interval;
				max = sum;
			}
		}
		return curr;
	}

	private static int[][] readIntervals(Scanner console, int[][] rows) {
		for (int i = 0; i < rows.length; i++) {
			rows[i][0] = console.nextInt();
			rows[i][1] = console.nextInt();
		}
		return rows;
	}

	private static class SegmentTree {

		private final int[] tree;
		private final int[] values;
		private final int n;

		SegmentTree(int[] values) {
			int size = 1;
			while (size < values.length) {
				size = size << 1;
			}
			this.values = values;
			this.n = values.length - 1;
			this.tree = new int[size << 1];
			buildTree(values, 1, 0, n);
		}

		int query(int li, int ri) {
			return query(0, n, li, ri, 1);
		}

		void decrease(int idx) {
			values[idx]--;
			if (values[idx] < 2) {
				update(0, n, 1, idx, values[idx]);
			}
		}

		private int query(int li, int ri, int from, int to, int idx) {
			if (li > to || ri < from) {
				return 0;
			} else if (li >= from && ri <= to) {
				return tree[idx - 1];
			} else {
				int mid = (ri - li) / 2 + li;
				int left = query(li, mid, from, to, idx * 2);
				int right = query(mid + 1, ri, from, to, idx * 2 + 1);
				return left + right;
			}
		}

		private int update(int li, int ri, int idx, int origin, int val) {
			if (li > origin || ri < origin) {
				return tree[idx - 1];
			} else if (li == origin && ri == origin) {
				tree[idx - 1] = val;
				return 1;
			} else {
				int mid = (ri - li) / 2 + li;
				int left = update(li, mid, idx * 2, origin, val);
				int right = update(mid + 1, ri, idx * 2 + 1, origin, val);
				tree[idx - 1] = left + right;
				return tree[idx - 1];
			}
		}

		private int buildTree(int[] values, int idx, int from, int to) {
			if (from == to) {
				int val = values[from] == 1 ? 1 : 0;
				tree[idx - 1] = val;
				return val;
			}
			int mid = (to - from) / 2 + from;
			int left = buildTree(values, idx * 2, from, mid);
			int right = buildTree(values, idx * 2 + 1, mid + 1, to);
			tree[idx - 1] = left + right;
			return tree[idx - 1];
		}

	}

}