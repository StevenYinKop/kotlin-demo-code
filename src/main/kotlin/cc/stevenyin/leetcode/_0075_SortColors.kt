package cc.stevenyin.leetcode

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * You must solve this problem without using the library's sort function.
 *
 *
 * Example 1:
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 * Example 2:
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is either 0, 1, or 2.
 *
 *
 * Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */
class _0075_SortColors {
    fun sortColors(nums: IntArray): Unit {
        var l = -1
        var r = nums.size
        var idx = 0
        while (idx < r) {
            when {
                nums[idx] == 0 -> swap(nums, idx++, ++l)
                nums[idx] == 2 -> swap(nums, idx, --r)
                else -> idx ++
            }
        }
    }

    private fun swap(nums: IntArray, idx1: Int, idx2: Int) {
        val temp = nums[idx1]
        nums[idx1] = nums[idx2]
        nums[idx2] = temp
    }
}

fun main() {
    val solution = _0075_SortColors()
    val case1 = intArrayOf(1,2,0)
    val expectedResult = intArrayOf(0,1,2)
    solution.sortColors(case1)
    expectedResult.forEachIndexed { index, i ->
        assert(case1[index] == i)
    }
}

/**
 * 为什么要学习O(n^2)的排序算法？
 * 1. 基础，易于入门和理解
 * 2. 编码简单，易于实现，是一些简单场景的首选
 * 3. 在一些特殊的情况下，简单的排序算法更有效
 * 4. 简单的排序算法思想衍生出复杂的排序算法
 * 5. 有可能可以作为子过程，改进更复杂的排序算法
 */
