package com.algorithm.playground.leetcode.problems.lc100.lc120.lc128

import com.algorithm.playground.leetcode.problems.lc100.lc120.lc128.LongestConsecutiveSequence.DSUSolution as DSUS
import com.algorithm.playground.leetcode.problems.lc100.lc120.lc128.LongestConsecutiveSequence.NaiveSolution as NS
import com.algorithm.playground.leetcode.problems.lc100.lc120.lc128.LongestConsecutiveSequence.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class LongestConsecutiveSequenceSpec extends Specification {

	@Unroll
	def "longestConsecutive"() {

		expect:

			new S().longestConsecutive(nums as int[]) == output

		where:

			nums                   || output
			[100, 4, 200, 1, 3, 2] || 4
			[1, 2, 0, 1]           || 3

	}

	@Unroll
	def "longestConsecutive_dsu"() {

		expect:

			new DSUS().longestConsecutive(nums as int[]) == output

		where:

			nums                   || output
			[100, 4, 200, 1, 3, 2] || 4
			[1, 2, 0, 1]           || 3

	}

	@Unroll
	def "longestConsecutive_naive"() {

		expect:

			new NS().longestConsecutive(nums as int[]) == output

		where:

			nums                   || output
			[100, 4, 200, 1, 3, 2] || 4
			[1, 2, 0, 1]           || 3

	}

}
