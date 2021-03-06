package com.algorithm.playground.google.codejam._2019.round1.a.task1

import com.algorithm.playground.google.utils.GoogleUtils
import spock.lang.Specification
import spock.lang.Unroll

class PylonsSpec extends Specification {

	@Unroll
	def "solve"() {

		expect:

			output == expected

		where:

			[output, expected] << GoogleUtils.exec(
					{ -> Solution.main() },
					["2 2", "IMPOSSIBLE"],
					["2 5", "POSSIBLE"],
					["3 3", "IMPOSSIBLE"],
					["2 3", "IMPOSSIBLE"]
			)

	}

}
