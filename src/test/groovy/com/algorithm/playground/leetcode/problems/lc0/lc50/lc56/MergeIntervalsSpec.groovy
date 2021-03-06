package com.algorithm.playground.leetcode.problems.lc0.lc50.lc56

import com.algorithm.playground.leetcode.problems.lc0.lc50.lc56.MergeIntervals.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.Interval.valueOf as intervals

class MergeIntervalsSpec extends Specification {

	@Unroll
	def "merge"() {

		expect:

			new S().merge(intervals(input)) == intervals(output)

		where:

			input                               || output
			[[1, 3], [2, 6], [8, 10], [15, 18]] || [[1, 6], [8, 10], [15, 18]]
			[[1, 4], [4, 5]]                    || [[1, 5]]
			[[1, 4], [0, 4]]                    || [[0, 4]]

	}

}
