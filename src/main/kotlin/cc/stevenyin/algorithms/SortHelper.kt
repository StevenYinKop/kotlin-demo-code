package cc.stevenyin.algorithms

import cc.stevenyin.algorithms._02_sorts.SortAlgorithm
import kotlin.random.Random
import kotlin.system.measureTimeMillis

class SortHelper {
}

fun <T> swap(array: Array<T>, index1: Int, index2: Int) {
    if (index1 == index2) return
    val temp = array[index1]
    array[index1] = array[index2]
    array[index2] = temp
}

fun testSortAlgorithm(sortType: String, clz: SortAlgorithm, nums: Int) {
    val array = generateIntegerTestCases(nums)
    val expectedArray = generateIntegerExpectedResult(array)
    println("Before: ")
    array.forEach {
        print("$it ")
    }
    println()
    val timeMillis = measureTimeMillis {
        clz.sort(array)
    }
    println()
    println("After: ")
    array.forEach {
        print("$it ")
    }
    println()
    println("(The $sortType operation took $timeMillis ms)")

    expectedArray.forEachIndexed { index, i ->
        assert(array[index] == i)
    }
}

fun generateIntegerTestCases(nums: Int): Array<Int> {
    val random = Random(System.currentTimeMillis())
    val result =
        Array(nums) { 0 }
    for (i in 0 until nums) {
        result[i] = random.nextInt(0, nums)
    }
    return result
}

fun generateIntegerExpectedResult(array: Array<Int>): Array<Int> {
    val result = array.copyOf()
    result.sort()
    return result
}
