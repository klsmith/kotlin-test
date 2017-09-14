package io.github.klsmith.kotlin.test

interface Cache<V, out R> {
	operator fun invoke(value: V): R
}

typealias Constructor<V, R> = (V) -> R

class SimpleInMemoryCache<V, out R>(private val constructor: Constructor<V, R>)
	: Cache<V, R> {

	private val map = mutableMapOf<V, R>()

	override operator fun invoke(value: V): R {
		return map.getOrPut(value) { constructor(value) }
	}

}