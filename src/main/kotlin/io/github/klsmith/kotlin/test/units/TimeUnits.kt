package io.github.klsmith.kotlin.test.units


/**** Nanoseconds ****/

typealias ns = Nanoseconds.UnitType

data class Nanoseconds private constructor(override val value: Double) : MeasuredValue<Nanoseconds> {
	companion object UnitType : CachedUnitType<Nanoseconds>("nanoseconds", "ns", ::Nanoseconds)

	override val unit = UnitType
	fun asMilliseconds(): Milliseconds = nanosecondsToMilliseconds(value) of Milliseconds.UnitType
	fun asSeconds(): Seconds = asMilliseconds().asSeconds()
}

const val NANOSECONDS_PER_MILLISECOND: Double = 1000000.0

fun nanosecondsToMilliseconds(nanoseconds: Double): Double = nanoseconds * NANOSECONDS_PER_MILLISECOND


/**** Milliseconds ****/

typealias ms = Milliseconds.UnitType

data class Milliseconds private constructor(override val value: Double) : MeasuredValue<Milliseconds> {
	companion object UnitType : CachedUnitType<Milliseconds>("milliseconds", "ms", ::Milliseconds)

	override val unit = UnitType
	fun asNanoseconds(): Nanoseconds = millisecondsToNanoseconds(value) of Nanoseconds.UnitType
	fun asSeconds(): Seconds = millisecondsToSeconds(value) of Seconds.UnitType
}

const val MILLISECONDS_PER_NANOSECOND: Double = 1.0 / NANOSECONDS_PER_MILLISECOND
const val MILLISECONDS_PER_SECOND: Double = 1000.0;

fun millisecondsToNanoseconds(milliseconds: Double): Double = milliseconds * MILLISECONDS_PER_NANOSECOND
fun millisecondsToSeconds(milliseconds: Double): Double = milliseconds * MILLISECONDS_PER_SECOND


/**** Seconds ****/

typealias s = Seconds.UnitType

data class Seconds private constructor(override val value: Double) : MeasuredValue<Seconds> {
	companion object UnitType : CachedUnitType<Seconds>("seconds", "s", ::Seconds)

	override val unit = UnitType
	fun asNanoseconds(): Nanoseconds = asMilliseconds().asNanoseconds()
	fun asMilliseconds(): Milliseconds = secondsToMilliseconds(value) of Milliseconds.UnitType
}

const val SECONDS_PER_MILLISECOND: Double = 1.0 / MILLISECONDS_PER_SECOND

fun secondsToMilliseconds(seconds: Double): Double = seconds * SECONDS_PER_MILLISECOND