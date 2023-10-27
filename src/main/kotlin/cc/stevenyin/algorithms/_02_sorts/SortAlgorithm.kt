package cc.stevenyin.algorithms._02_sorts

interface SortAlgorithm {
    fun <T: Comparable<T>> sort(array: Array<T>)
}
