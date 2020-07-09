package com.stevenyin.leetcode._42

class Solution {
    fun trap(height: IntArray): Int {
		var area: Int = 0
		var left: Int = 0
		var right: Int = height.size - 1
		var leftMax: Int = 0
		var rightMax: Int = 0
		while (left < right) {
			if (height[left] > leftMax) {
				leftMax = height[left]
			} else {
				area += leftMax - height[left]
			}
			if (height[right] > rightMax) {
				rightMax = height[right]
			} else {
				area += rightMax - height[right]
			}
			if (leftMax >= rightMax) right--
			else left ++
		}
		return area
    }
}