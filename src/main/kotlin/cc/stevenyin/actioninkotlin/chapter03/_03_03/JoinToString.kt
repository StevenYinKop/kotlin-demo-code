package cc.stevenyin.actioninkotlin.chapter03._03_03

import cc.stevenyin.actioninkotlin.chapter03._03_01.joinToString as jts

fun <T> joinToString(
		collection: Collection<T>,
		separator: String = ", ",
		prefix: String = "",
		postfix: String = ""
) = jts(collection, separator, prefix, postfix)
