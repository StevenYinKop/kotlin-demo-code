package cc.stevenyin.algorithms._02_sorts

import cc.stevenyin.algorithms.swap
import cc.stevenyin.algorithms.testSortAlgorithm

class _01_SelectionSort: SortAlgorithm {

    fun <T: Comparable<T>> selectionSort(array: Array<T>) {
        for (idx1 in array.indices) {
            for (idx2 in idx1 + 1 until array.size) {
                if (array[idx1] > array[idx2]) {
                    swap(array, idx1, idx2)
                }
            }
        }
    }

    override fun <T : Comparable<T>> sort(array: Array<T>) = selectionSort(array)
}

fun main() {
    testSortAlgorithm("_01_SelectionSort", _01_SelectionSort(), 10000)
}
