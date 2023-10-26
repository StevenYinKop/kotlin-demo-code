package cc.stevenyin.leetcode

class _0343_IntegerBreak {
    fun integerBreak(n: Int): Int {

        val memo: Map<Int, Int> = mapOf()
        return breakInteger(n, memo)
    }

    fun breakInteger(n: Int, memo: Map<Int, Int>): Int {
        if (n == 2) return 1
        if (memo.containsKey(n)) return memo.get(n)!!
        // 将n进行分割（至少分割为两部分）
        var result = -1
        for (i in 1..n - 1) {
            result = kotlin.math.max(result, i * breakInteger(n - i, memo))
        }
//        memo[n] = result
        return result
    }
}
