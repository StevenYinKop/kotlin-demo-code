package cc.stevenyin.algorithms._02_sorts

import cc.stevenyin.algorithms.swap
import cc.stevenyin.algorithms.testSortAlgorithm

class _01_SelectionSort : SortAlgorithm {
    override val name: String = "SelectionSort"
    fun <T: Comparable<T>> selectionSort(array: Array<T>) {
        for (idx1 in array.indices) {
            var minIndex = idx1
            for (idx2 in idx1 + 1 until array.size) {
                if (array[minIndex] > array[idx2]) {
                    minIndex = idx2
                }
            }
            swap(array, idx1, minIndex)
        }
    }

    override fun <T : Comparable<T>> sort(array: Array<T>) = selectionSort(array)
}

fun main() {
    testSortAlgorithm(10000, _01_SelectionSort())
}
