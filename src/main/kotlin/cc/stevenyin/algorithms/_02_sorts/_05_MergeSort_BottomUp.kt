package cc.stevenyin.algorithms._02_sorts

import cc.stevenyin.algorithms.RandomType
import cc.stevenyin.algorithms.testSortAlgorithm
import kotlin.math.min

class _05_MergeSort_BottomUp: SortAlgorithm {
    override val name: String
        get() = "MergeSort_BottomUp"


    // 2,3,1,5,3,6,9,8
    // 
    override fun <T : Comparable<T>> sort(array: Array<T>) {
        var size = 1
        // 对size大小的元素进行归并
        while (size < array.size) {
            // 对[i, i + size - 1]和[i + size, i + 2 * size - 1]的元素进行归并
            var index = 0
            while (index < array.size) {
                if (index + size < array.size) {
                    val middle = index + size - 1
                    val right = min(array.size - 1, index + 2 * size - 1)
                    merge(array, left = index, middle, right)
                }
                index += size * 2
            }
            size *= 2
        }
    }

    fun <T : Comparable<T>> merge(array: Array<T>, left: Int, middle: Int, right: Int) {
        val aux = array.copyOfRange(left, right + 1)
        var p = left
        var p1 = 0
        var p2 = middle - left + 1
        while (p1 <= middle - left && p2 <= right - left) {
            if (aux[p1] < aux[p2]) {
                array[p] = aux[p1]
                p1++
            } else {
                array[p] = aux[p2]
                p2++
            }
            p++
        }
        while (p1 <= middle - left) {
            array[p] = aux[p1]
            p1++
            p++
        }
        while (p2 <= right - left) {
            array[p] = aux[p2]
            p2++
            p++
        }
    }
}

fun main() {
    testSortAlgorithm(10, RandomType.CHAOS, _04_MergeSort(), _05_MergeSort_BottomUp())
}
