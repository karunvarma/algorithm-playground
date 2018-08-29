package com.leetcode.problems.string.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-pairs/description/
 */
public class PalindromePairs {

	class Solution {

		public List<List<Integer>> palindromePairs(String[] words) {
			List<List<Integer>> result = new ArrayList<>();

			Node root = new Node();

			for (int i = 0; i < words.length; i++) {
				add(root, words[i], i);
			}

			for (int i = 0; i < words.length; i++) {
				search(words[i], i, root, result);
			}

			return result;
		}

		private void search(String w, int i, Node root, List<List<Integer>> list) {
			for (int j = 0; j < w.length(); j++) {
				if (root.idx >= 0 && root.idx != i && isPalindrome(w, j, w.length() - 1)) {
					list.add(Arrays.asList(i, root.idx));
				}

				root = root.children[w.charAt(j) - 'a'];
				if (root == null) {
					return;
				}
			}

			for (int j : root.list) {
				if (i != j) {
					list.add(Arrays.asList(i, j));
				}
			}
		}

		private void add(Node root, String w, int idx) {
			for (int i = w.length() - 1; i >= 0; i--) {
				int j = w.charAt(i) - 'a';
				if (root.children[j] == null) {
					root.children[j] = new Node();
				}
				if (isPalindrome(w, 0, i)) {
					root.list.add(idx);
				}
				root = root.children[j];
			}

			root.list.add(idx);
			root.idx = idx;
		}

		private boolean isPalindrome(String w, int i, int j) {
			while (i < j) {
				if (w.charAt(i++) != w.charAt(j--)) {
					return false;
				}
			}
			return true;
		}

		private class Node {
			Node[] children;

			int idx;

			List<Integer> list;

			private Node() {
				children = new Node[26];
				idx = -1;
				list = new ArrayList<>();
			}
		}

	}

}
