package io.github.klsmith.kotlin.test.units


/**** Nanoseconds ****/

typealias ns = Nanoseconds.Unit

data class Nanoseconds private constructor(override val value: Double) : GenericMeasuredValue<Nanoseconds>(value, Unit) {
	companion object Unit : CachedUnit<Nanoseconds>("nanoseconds", "ns", ::Nanoseconds)

	fun asMilliseconds(): Milliseconds = nanosecondsToMilliseconds(value) of Milliseconds.Unit
	fun asSeconds(): Seconds = asMilliseconds().asSeconds()
}

const val NANOSECONDS_PER_MILLISECOND: Double = 1000000.0

fun nanosecondsToMilliseconds(nanoseconds: Double): Double = nanoseconds * NANOSECONDS_PER_MILLISECOND


/**** Milliseconds ****/

typealias ms = Milliseconds.Unit

data class Milliseconds private constructor(override val value: Double) : GenericMeasuredValue<Milliseconds>(value, Unit) {
	companion object Unit : CachedUnit<Milliseconds>("milliseconds", "ms", ::Milliseconds)

	fun asNanoseconds(): Nanoseconds = millisecondsToNanoseconds(value) of Nanoseconds.Unit
	fun asSeconds(): Seconds = millisecondsToSeconds(value) of Seconds.Unit
}

const val MILLISECONDS_PER_NANOSECOND: Double = 1.0 / NANOSECONDS_PER_MILLISECOND
const val MILLISECONDS_PER_SECOND: Double = 1000.0;

fun millisecondsToNanoseconds(milliseconds: Double): Double = milliseconds * MILLISECONDS_PER_NANOSECOND
fun millisecondsToSeconds(milliseconds: Double): Double = milliseconds * MILLISECONDS_PER_SECOND


/**** Seconds ****/

typealias s = Seconds.Unit

data class Seconds private constructor(override val value: Double) : GenericMeasuredValue<Seconds>(value, Unit) {
	companion object Unit : CachedUnit<Seconds>("seconds", "s", ::Seconds)

	fun asNanoseconds(): Nanoseconds = asMilliseconds().asNanoseconds()
	fun asMilliseconds(): Milliseconds = secondsToMilliseconds(value) of Milliseconds.Unit
}

const val SECONDS_PER_MILLISECOND: Double = 1.0 / MILLISECONDS_PER_SECOND

fun secondsToMilliseconds(seconds: Double): Double = seconds * SECONDS_PER_MILLISECOND