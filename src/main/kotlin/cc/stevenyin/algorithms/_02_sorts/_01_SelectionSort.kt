package cc.stevenyin.algorithms._02_sorts

class _01_SelectionSort {
    fun <T: Comparable<T>> selectionSort(array: Array<T>) {
        for (idx1 in array.indices) {
            var minIndex = idx1
            for (idx2 in idx1 + 1 until array.size) {
                if (array[idx1] > array[idx2]) {
                    minIndex = idx2
                }
            }
            swap(array, idx1, minIndex)
        }
    }
    fun <T> swap(array: Array<T>, index1: Int, index2: Int) {
        val temp = array[index1]
        array[index1] = array[index2]
        array[index2] = temp
    }
}

fun main() {
    val solution = _01_SelectionSort()
    val array = arrayOf(5,1,2,3,5,6,7,1)
    val expectedArray = intArrayOf(1,1,2,3,5,5,6,7)
    solution.selectionSort(array)

    expectedArray.forEachIndexed { index, i ->
        assert(array[index] == i)
    }

}
