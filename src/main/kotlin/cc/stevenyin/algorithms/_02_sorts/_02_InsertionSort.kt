package cc.stevenyin.algorithms._02_sorts

import cc.stevenyin.algorithms.swap
import cc.stevenyin.algorithms.testSortAlgorithm

class _02_InsertionSort: SortAlgorithm {
    override val name: String = "InsertionSort"
    override fun <T : Comparable<T>> sort(array: Array<T>) {
        for (i in 1 until array.size) {
            for (j in i downTo 0) {
                if (j > 0 && array[j - 1] > array[j]) {
                    swap(array, j - 1, j)
                } else {
                    break
                }
            }
        }
    }
}

fun main() {
    testSortAlgorithm(100000, _01_SelectionSort(), _02_InsertionSort())
}


// 5, 3, 6, 1, 7, 2
// 3, 5, 6, 1, 7, 2
// 3, 5, 6, 1, 7, 2
