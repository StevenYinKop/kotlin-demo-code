package cc.stevenyin.algorithms._02_sorts

import cc.stevenyin.algorithms.RandomType
import cc.stevenyin.algorithms.testSortAlgorithm

class _04_MergeSort: SortAlgorithm {
    override val name: String
        get() = "MergeSort_Recursive"

    override fun <T : Comparable<T>> sort(array: Array<T>) {
        // 维护变量在算法运行过程中的定义是写好算法的基础
        val left = 0
        val right = array.size - 1
        mergeSort(array, left, right)
    }

    private fun <T : Comparable<T>> mergeSort(array: Array<T>, left: Int, right: Int): Unit {
        if (left >= right) {
            return
        }
        val mid = left + (right - left) / 2
        mergeSort(array, left, mid)
        mergeSort(array, mid + 1, right)
        merge(array, left, mid, right)
    }
    private fun <T: Comparable<T>> merge(array: Array<T>, left: Int, middle: Int, right: Int) {
        val aux = arrayOfNulls<Comparable<T>>(right - left + 1)
        // copy the range of the data to `aux` array
        for (i in left .. right) {
            aux[i - left] = array[i];
        }

        // 8 6 2 3
        // ^
        // cur
        // i   j

        var i = left
        var j = middle + 1
        for (cursor in left .. right) {
            if (i > middle) {
                array[cursor] = aux[j - left] as T
                j ++
                continue
            } else if (j > right) {
                array[cursor] = aux[i - left] as T
                i ++
                continue
            }
            val l = aux[i - left] as T
            val r = aux[j - left] as T
            if (l > r) {
                array[cursor] = l
                i ++
            } else {
                array[cursor] = r
                j ++
            }
        }
    }
}

fun main() {
    testSortAlgorithm(500, RandomType.CHAOS, _04_MergeSort())
}


// 5, 3, 6, 1, 7, 2
// 3, 5, 6, 1, 7, 2
// 3, 5, 6, 1, 7, 2
