package cc.stevenyin.algorithms

import cc.stevenyin.algorithms._02_sorts.SortAlgorithm
import kotlin.random.Random
import kotlin.system.measureTimeMillis

class SortHelper {
}
enum class RandomType() {
    NEARLY_ORDERED {
        override fun generate(nums: Int): Array<Int> {
            val random = Random(System.currentTimeMillis())
            val result = Array(nums) { it }
            for (i in 0..10) {
                swap(result, random.nextInt(result.size), random.nextInt(result.size))
            }
            return result
        }
    },
    CHAOS {
        override fun generate(nums: Int): Array<Int> {
            val random = Random(System.currentTimeMillis())
            val result =
                Array(nums) { 0 }
            for (i in 0 until nums) {
                result[i] = random.nextInt(0, nums)
            }
            return result
        }
    },
    CLOSE_RANGE {
        override fun generate(nums: Int): Array<Int> {
            val random = Random(System.currentTimeMillis())
            val result =
                Array(nums) { 0 }
            for (i in 0 until nums) {
                result[i] = random.nextInt(0, 5)
            }
            return result
        }
    },
    ORDERED {
        override fun generate(nums: Int): Array<Int> {
            return Array(nums) { it }
        }
    };

    abstract fun generate(nums: Int): Array<Int>
}

fun <T> swap(array: Array<T>, index1: Int, index2: Int) {
    if (index1 == index2) return
    val temp = array[index1]
    array[index1] = array[index2]
    array[index2] = temp
}

fun testSortAlgorithm(nums: Int, type: RandomType, vararg algorithms: SortAlgorithm) {
    val array = generateIntegerTestCases(nums, type)
    val expectedArray = generateIntegerExpectedResult(array)

    algorithms.forEach { algorithm ->
        val arrayIteration = array.copyOf()
        val timeMillis = measureTimeMillis {
            algorithm.sort(arrayIteration)
        }
        if (nums <= 20) {
            println("The final array is ${arrayIteration.contentToString()}")
        }
        println("(The ${algorithm.name} operation took $timeMillis ms)")
        assert(expectedArray.contentEquals(array)) { "The results aren incorrect!" }

        println()
    }

}

fun testSortAlgorithm(nums: Int, type: RandomType, clz: SortAlgorithm) {
    testSortAlgorithm(nums, type, *arrayOf(clz))
}

fun generateIntegerTestCases(nums: Int, type: RandomType) = type.generate(nums)

fun generateIntegerExpectedResult(array: Array<Int>): Array<Int> {
    val result = array.copyOf()
    result.sort()
    return result
}
