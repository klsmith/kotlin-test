package io.github.klsmith.kotlin.test

interface Cache<V, out R> {
	fun get(value: V): R
}

class SimpleCache<V, out R>(private val constructor: (V) -> R) : Cache<V, R> {
	private val cache = mutableMapOf<V, R>()

	override fun get(value: V): R {
		if (!cache.contains(value)) {
			cache[value] = constructor(value)
		}
		return cache[value]!!
	}
}