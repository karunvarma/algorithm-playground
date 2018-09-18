package com.leetcode.problems.stack.easy

import com.leetcode.problems.stack.easy.MinStack155.MinStack as MS
import spock.lang.Specification

class MinStack155Spec extends Specification {

	def "minStack"() {

		given:

			def minStack = new MS()

		when:

			minStack.push(-2)
			minStack.push(0)
			minStack.push(-3)

		then:

			minStack.getMin() == -3

		when:

			minStack.pop()

		then:

			minStack.top() == 0
			minStack.getMin() == -2
	}

}
