package cc.stevenyin.leetcode

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *  Given a string s, find the length of the longest substring without repeating characters.
 *
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 * /
 *
 */
class _0003_LengthOfLongestSubstring {
//    fun lengthOfLongestSubstring(str: String): Int {
//        val charSet = HashSet<String>()
//        var left = 0
//        var right = 0
//        var max = 0
//        while (right < str.length) {
//            if (!charSet.contains(str[right].toString())) {
//                charSet.add(str[right].toString())
//                right ++
//            } else {
//                charSet.remove(str[left].toString())
//                left ++
//            }
//            max = maxOf(max, right - left)
//        }
//        return max
//    }

    fun lengthOfLongestSubstring(str: String): Int {

        val charCounts = IntArray(256)

        var left = 0
        var right = 0

        var maxLen = 0
        var curLen: Int

        while (right < str.length) {
            val rightChar = str[right]
            charCounts[rightChar.toInt()]++

            while (charCounts[rightChar.toInt()] > 1) {
                val leftChar = str[left]
                charCounts[leftChar.toInt()]--
                left++
            }

            curLen = right - left + 1
            maxLen = maxOf(maxLen, curLen)
            right++
        }
        return maxLen
    }
}

fun main() {
    val solution = _0003_LengthOfLongestSubstring()
    assert(solution.lengthOfLongestSubstring("abcabcbb") == 3)
    assert(solution.lengthOfLongestSubstring("bbbbb") == 1)
    assert(solution.lengthOfLongestSubstring("pwwkew") == 3)
    assert(solution.lengthOfLongestSubstring("aab") == 2)
    assert(solution.lengthOfLongestSubstring("aba") == 2)

}
