package cc.stevenyin.leetcode

/**
 * https://leetcode.com/problems/valid-mountain-array
 * Given an array of integers arr, return true if and only if it is a valid mountain array.
 *
 * Recall that arr is a mountain array if and only if:
 *
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 *
 * Example 1:
 * Input: arr = [2,1]
 * Output: false
 *
 *  Example 2:
 * Input: arr = [3,5,5]
 * Output: false
 * 
 * Example 3:
 * Input: arr = [0,3,2,1]
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 104
 * 0 <= arr[i] <= 104
 */
class _0941_ValidMountainArray {
    fun validMountainArray(arr: IntArray): Boolean {
        if (arr.size < 3) return false
        var peak = -1
        for (idx in 0 until arr.size - 1) {
            if (arr[idx] == arr[idx + 1]) {
                return false
            } else if (arr[idx] > arr[idx + 1]) {
                peak = idx
                break
            }
        }
        if (peak == arr.size - 1 || peak == -1) return false
        for (idx in peak until arr.size - 1) {
            if (arr[idx] == arr[idx + 1] || arr[idx] < arr[idx + 1]) {
                return false
            }
        }
        return true
    }
}

fun main() {
    val solution = _0941_ValidMountainArray()
    solution.validMountainArray(intArrayOf(0,1,2,3,4,5,6,7,8,9))
    solution.validMountainArray(intArrayOf(9,8,7,6,5,4,3,2,1,0))
}
