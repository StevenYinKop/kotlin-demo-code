package cc.stevenyin.algorithms._02_sorts

import cc.stevenyin.algorithms.RandomType
import cc.stevenyin.algorithms.swap
import cc.stevenyin.algorithms.testSortAlgorithm


class _07_QuickSort_Partition2 : SortAlgorithm {
    override val name: String = "Quick Sort with Partition 2"
    override fun <T : Comparable<T>> sort(array: Array<T>) {
        quickSort(array, 0, array.size - 1)
    }

    private fun <T : Comparable<T>> quickSort(array: Array<T>, left: Int, right: Int) {
        if (left >= right) return

        val pivot = partition(array, left, right)
        quickSort(array, left, pivot - 1)
        quickSort(array, pivot + 1, right)
    }

    private fun <T: Comparable<T>> partition(array: Array<T>, left: Int, right: Int): Int {
        // arr[l+1, i) <= pivotValue
        var i = left + 1
        // arr(j, r] >= pivotValue
        var j = right
        val pivotValue = array[left]
        while (i <= j) {
            while (i < right && array[i] < pivotValue) i ++
            while (j > left + 1 && array[j] > pivotValue) j --
            swap(array, i, j)
            i ++
            j --
            println(array.contentToString())
        }
        swap(array, left, j)
        return j
    }
}

fun main() {
    testSortAlgorithm(10, RandomType.CHAOS, _07_QuickSort_Partition2())
}
