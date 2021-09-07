package cc.stevenyin.data_structure.api

abstract class AbstractList<E>: List<E> {
    public var size: Int = 0
        protected set
    override fun contains(e: E) = findIndex(e) != -1
    override fun isEmpty() = size == 0
    override fun addFirst(e: E) = add(e, 0)
    override fun addLast(e: E) = add(e, size)
    override fun delFirst() = del(0)
    override fun delLast() = del(this.size - 1)
    override fun delElement(e: E): Boolean {
        val index = findIndex(e)
        if (index != -1) {
            del(index)
            return true
        }
        return false
    }
    protected fun checkIfOutOfBound(index: Int, withBound: Boolean = false) {
        if (index < 0 || index > size || withBound && index == size) throw IllegalArgumentException("Invalid index: $index!")
    }
}