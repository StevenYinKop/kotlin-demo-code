package cc.stevenyin.algorithms._01_binary_search

fun <T: Comparable<T>> binarySearch(array: Array<T>, target: T): Int {
    var left: Int = 0
    var right = array.size - 1
    while (left <= right) {
        val mid = (left + right) / 2
        if (array[mid] == target) {
            return mid
        }
        if (array[mid] > target) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return -1
}
fun main() {
    println(binarySearch(arrayOf(10, 20, 30, 50, 80, 99, 100), 2))
    println(binarySearch(arrayOf(10, 20, 30, 50, 80, 99, 100), 10))
    println(binarySearch(arrayOf(10, 20, 30, 50, 80, 99, 100), 100))
    println(binarySearch(arrayOf(10, 20, 30, 50, 80, 99, 100), 101))
    println(binarySearch(arrayOf(10, 20, 30, 50, 80, 99, 100), 98))
}
