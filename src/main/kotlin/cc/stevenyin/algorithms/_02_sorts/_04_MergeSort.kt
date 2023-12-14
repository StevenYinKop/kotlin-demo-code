package cc.stevenyin.algorithms._02_sorts

import cc.stevenyin.algorithms.swap
import cc.stevenyin.algorithms.testSortAlgorithm

class _04_MergeSort: SortAlgorithm {
    override fun <T : Comparable<T>> sort(array: Array<T>) {
        for (i in array.indices) {

        }
    }
}

fun main() {
    testSortAlgorithm("_04_MergeSort", _04_MergeSort(), 500)
}


// 5, 3, 6, 1, 7, 2
// 3, 5, 6, 1, 7, 2
// 3, 5, 6, 1, 7, 2
