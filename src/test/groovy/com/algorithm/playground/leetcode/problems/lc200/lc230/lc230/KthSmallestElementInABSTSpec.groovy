package com.algorithm.playground.leetcode.problems.lc200.lc230.lc230

import com.algorithm.playground.leetcode.problems.lc200.lc230.lc230.KthSmallestElementInABST.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.tree.TreeNode.node

class KthSmallestElementInABSTSpec extends Specification {

	@Unroll
	def "kthSmallest"() {

		expect:

			new S().kthSmallest(node(values), k) == output

		where:

			values                         | k || output
			[3, 1, 4, null, 2]             | 1 || 1
			[5, 3, 6, 2, 4, null, null, 1] | 3 || 3

	}

}
