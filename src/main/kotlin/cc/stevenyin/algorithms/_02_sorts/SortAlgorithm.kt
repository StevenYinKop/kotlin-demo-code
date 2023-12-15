package cc.stevenyin.algorithms._02_sorts

interface SortAlgorithm {
    val name: String
    fun <T: Comparable<T>> sort(array: Array<T>)
}
