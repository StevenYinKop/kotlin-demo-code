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

fun testSortAlgorithm(nums: Int, vararg algorithms: SortAlgorithm) {
    val array = generateIntegerTestCases(nums)
    val expectedArray = generateIntegerExpectedResult(array)

    algorithms.forEach { algorithm ->
        val arrayInteration = array.copyOf()
        val timeMillis = measureTimeMillis {
            algorithm.sort(arrayInteration)
        }
        println("(The ${algorithm.name} operation took $timeMillis ms)")
        expectedArray.contentEquals(array)
        println("The results are correct!")

        println()
    }

}

fun testSortAlgorithm(nums: Int, clz: SortAlgorithm) {
    testSortAlgorithm(nums, *arrayOf(clz))
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
