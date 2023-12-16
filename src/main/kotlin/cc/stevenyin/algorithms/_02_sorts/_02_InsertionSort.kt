package cc.stevenyin.algorithms._02_sorts

import cc.stevenyin.algorithms.RandomType
import cc.stevenyin.algorithms.swap
import cc.stevenyin.algorithms.testSortAlgorithm

class _02_InsertionSort: SortAlgorithm {
    override val name: String = "InsertionSort"
    override fun <T : Comparable<T>> sort(array: Array<T>) {
        for (i in 1 until array.size) {
            val temp = array[i]
            var index = i
            for (j in i downTo 1) {
                if (array[j - 1] > temp) {
                    array[j] = array[j - 1]
                    index = j - 1
                }
            }
            if (index != i) {
                array[index] = temp
            }
        }
    }
}

fun main() {
    testSortAlgorithm(100000, RandomType.NEARLY_ORDERED, _01_SelectionSort(), _02_InsertionSort())
}


// 5, 3, 6, 1, 7, 2
// 3, 5, 6, 1, 7, 2
// 3, 5, 6, 1, 7, 2
