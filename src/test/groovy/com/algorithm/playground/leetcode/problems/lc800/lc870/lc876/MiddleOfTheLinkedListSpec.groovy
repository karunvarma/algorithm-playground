package com.algorithm.playground.leetcode.problems.lc800.lc870.lc876

import com.algorithm.playground.leetcode.problems.lc800.lc870.lc876.MiddleOfTheLinkedList.SizeCountingSolution as SCS
import com.algorithm.playground.leetcode.problems.lc800.lc870.lc876.MiddleOfTheLinkedList.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.linkedlist.ListNode.valueOf as node

class MiddleOfTheLinkedListSpec extends Specification {

	@Unroll
	def "middleNode"() {

		given:

			def head = node(values)
			def mid = head
			while (mid.val != middle) {
				mid = mid.next
			}

		expect:

			new S().middleNode(head) == mid

		where:

			values             || middle
			[1, 2, 3, 4, 5]    || 3
			[1, 2, 3, 4, 5, 6] || 4

	}

	@Unroll
	def "middleNode_size_counting"() {

		given:

			def head = node(values)
			def mid = head
			while (mid.val != middle) {
				mid = mid.next
			}

		expect:

			new SCS().middleNode(head) == mid

		where:

			values             || middle
			[1, 2, 3, 4, 5]    || 3
			[1, 2, 3, 4, 5, 6] || 4

	}

}
