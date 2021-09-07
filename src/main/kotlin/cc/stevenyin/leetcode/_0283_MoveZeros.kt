package cc.stevenyin.leetcode

/**
 * https://leetcode.com/problems/move-zeroes/
 * Given an integer array nums,
 * move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 *
    Note that you must do this in-place without making a copy of the array.

    Example 1:
    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]

    Example 2:
    Input: nums = [0]
    Output: [0]
 */
class _0283_MoveZeros {
    fun moveZeroes(nums: IntArray): Unit {
        var k = 0;
        for (i in nums.indices) {
            if (nums[i] != 0) {
                if (i != k) {
                    swap(nums, k++, i);
                } else {
                    k++;
                }
            }
        }
    }
    private fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// 26, 27, 80, 75, 88, 215, 167,
// 11
// 字符串 125, 344, 345
// 空字符串
// 字符的定义
// 大小写问题

// Slide window  209, 3, 438, 76