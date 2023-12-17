package cc.stevenyin.algorithms._02_sorts

import cc.stevenyin.algorithms.RandomType
import cc.stevenyin.algorithms.swap
import cc.stevenyin.algorithms.testSortAlgorithm
import kotlin.random.Random


/**
 * 存在的问题：
 * 1.   对于一个已经有序或近乎有序的数组来说，
 *      每一次从第一个位置选取一个元素，
 *      很可能导致两侧的子数组变得极其不平衡。
 *      所以可以采取随机选择的方法来确定待比较元素。
 * 2.   对于一个存在大量重复数据的数组来说，
 *      例如 [1，2，3，1，2，3，1，2，2，3，1，1，1，3，4，0，2，1，2，5]
 *      这样会导致左侧存在大量与标定点处相同值的数据
 *
 */
class _06_QuickSort_Basic : SortAlgorithm {
    override val name: String = "Quick Sort"

    override fun <T : Comparable<T>> sort(array: Array<T>) {
        quickSort(array, 0, array.size - 1)
    }

    private fun <T : Comparable<T>> quickSort(array: Array<T>, left: Int, right: Int) {
        if (left >= right) {
            return
        }
        // 采取随机选择的方法来确定待比较元素。
        val randomIndex = Random.nextInt(array.size)
        swap(array, randomIndex, left)

        val pivot = partition(array, left, right)
        quickSort(array, left, pivot - 1)
        quickSort(array, pivot + 1, right)
    }

    /***
     *  1. 对数组进行一分为二
     *  2. 基准点左侧的元素全部小于或等于基准点处的值
     *  3. 基准点右侧的元素全部大于基准点处的值
     */
    private fun <T : Comparable<T>> partition(array: Array<T>, left: Int, right: Int): Int {
        val e = left
        var cursor = e + 1
        var i = left
        while (cursor <= right) {
            if (array[cursor] <= array[e]) {
                swap(array, i + 1, cursor)
                i++
            }
            cursor++
        }
        swap(array, e, i)
        return i
    }
}

fun main() {
    testSortAlgorithm(100000, RandomType.NEARLY_ORDERED, _04_MergeSort(), _05_MergeSort_BottomUp(), _06_QuickSort_Basic())
}
