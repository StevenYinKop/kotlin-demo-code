package cc.stevenyin.data_structure.model

open class Node<E> constructor(value: E, next: Node<E>?) : DoublyNode<E>(null, value, next) {
    constructor(value: E): this(value, null)
}