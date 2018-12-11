package com.leetcode.problems.string.medium

import com.leetcode.problems.string.medium.BasicCalculatorII.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class BasicCalculatorIISpec extends Specification {

	@Unroll
	def "calculate"() {

		expect:

			new S().calculate(s) == out

		where:

			s              || out
			"3+2*2"        || 7
			" 3/2 "        || 1
			" 3+5 / 2 "    || 5
			"1-1+1"        || 1
			"0-2147483647" || -2147483647

	}

}
