package com.leetcode.problems.dynamic.programming.medium;

/**
 * https://leetcode.com/problems/integer-break/description/
 */
public class IntegerBreak {

    class Solution {

        private int[] cache = new int[59];

        public Solution() {
            cache[2] = 1;
            cache[3] = 2;
            cache[4] = 4;
            cache[5] = 6;
            for (int i = 6; i < cache.length; i++) {
                cache[i] = i % 3 == 0 ? (int) Math.pow(3, i / 3) : cache[i - 2] * 2;
            }
        }

        public int integerBreak(int n) {
            return cache[n];
        }

    }

}
