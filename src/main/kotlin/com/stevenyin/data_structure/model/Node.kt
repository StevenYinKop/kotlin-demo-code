package com.stevenyin.data_structure.model

class Node<E>(var value: E, var next: Node<E>?) {
    constructor(e: E): this(e, null)
}
