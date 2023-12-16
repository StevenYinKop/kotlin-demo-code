package cc.stevenyin.algorithms._02_sorts

import cc.stevenyin.algorithms.RandomType
import cc.stevenyin.algorithms.swap
import cc.stevenyin.algorithms.testSortAlgorithm

class _03_BubbleSort: SortAlgorithm {
    override val name: String = "BubbleSort"

    override fun <T : Comparable<T>> sort(array: Array<T>) {
        val size = array.size
        for (i in 0 until size - 1) {
            for (j in 0 until size - i - 1) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1)
                }
            }
        }
    }
}

fun main() {
    testSortAlgorithm(100000, RandomType.CHAOS, _01_SelectionSort(), _02_InsertionSort(), _03_BubbleSort())
}


// 5, 3, 6, 1, 7, 2
// i, j
// 3, 5, 6, 1, 7, 2
// i,  , j,
//
// 3, 5, 6, 1, 7, 2
// 3, 5, 6, 1, 7, 2
