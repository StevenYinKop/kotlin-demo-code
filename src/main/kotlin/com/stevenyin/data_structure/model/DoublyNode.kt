package com.stevenyin.data_structure.model

open class DoublyNode<E>(var pre: DoublyNode<E>?, var value: E, var next: DoublyNode<E>?) {
    override fun toString() = if (value == null) "NULL" else value.toString()
    constructor(e: E): this(null, e, null)
}
