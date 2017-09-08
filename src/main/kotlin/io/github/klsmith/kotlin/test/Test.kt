package io.github.klsmith.kotlin.test

import java.util.Random

private val random = Random()

fun <T> choose(vararg args: T): T {
	return args[random.nextInt(args.size)]
}

fun main(args: Array<String>) {
	val counter: Counter = WrapCounter(min = 0, max = 2)
	printCount(0, counter.count)
	for (i in 1..10) {
		counter.increment()
		printCount(i, counter.count)
	}
	val nvl: String? = choose("hello", "world", "", null)
	if (nvl.isNullOrEmpty()) {
		println("null or empty '$nvl'")
	} else {
		println("$nvl")
	}
}

fun printCount(index: Int, count: Int) {
	println("%02d : %02d".format(index, count))
}

class SimpleCounter(val initial: Int = 0) : Counter {

	override var count = initial; private set

	override fun reset() {
		count = initial
	}

	override fun increment() {
		count++
	}

}

class WrapCounter(val min: Int = 0, val max: Int = 1) : Counter {

	private val counter: SimpleCounter = SimpleCounter(min)

	override val count; get() = counter.count

	override fun reset() {
		counter.reset()
	}

	override fun increment() {
		counter.increment()
		if (count > max) {
			reset()
		}
	}

}

interface Counter {

	val count: Int

	fun reset()

	fun increment()

}