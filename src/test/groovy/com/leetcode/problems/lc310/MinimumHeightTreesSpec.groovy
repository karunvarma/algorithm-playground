package com.leetcode.problems.lc310

import com.leetcode.problems.lc310.MinimumHeightTrees.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class MinimumHeightTreesSpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyAssignabilityCheck")
	def "findMinHeightTrees"() {

		expect:

			new S().findMinHeightTrees(n, edges as int[][]) == out

		where:

			n | edges                                    || out
			4 | [[1, 0], [1, 2], [1, 3]]                 || [1]
			6 | [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]] || [3, 4]
			1 | []                                       || [0]
			3 | [[0, 1], [0, 2]]                         || [0]
			6 | [[0, 1], [0, 2], [0, 3], [3, 4], [4, 5]] || [3]

	}

}
