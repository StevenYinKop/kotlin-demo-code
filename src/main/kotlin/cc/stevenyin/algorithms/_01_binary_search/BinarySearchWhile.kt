package cc.stevenyin.algorithms._01_binary_search

/**
 * Binary search to find the index of target in a sorted array.
 *
 * @param array The sorted array to search.
 * @param target The value to search for.
 * @return The index of target if found, or the negation of the insertion point otherwise.
 */
fun <T: Comparable<T>> binarySearch(array: Array<T>, target: T): Int {

    var low = 0
    var high = array.size - 1

    while (low < high) {
        val midIndex = (low + high) / 2
        val mid = array[midIndex]
        when {
            mid < target -> low = midIndex + 1
            mid > target -> high = midIndex - 1
            else -> return midIndex
        }
    }
    return -low - 1  // Not found, would insert at -low-1
}
fun main() {
    val testData = arrayOf(10, 20, 30, 50, 80, 99, 100)
    assert(binarySearch(testData, 2) == -1)
    assert(binarySearch(testData, 10) == 0)
    assert(binarySearch(testData, 100) == 6)
    assert(binarySearch(testData, 101) == -1)
    assert(binarySearch(testData, 98) == -1)
}
