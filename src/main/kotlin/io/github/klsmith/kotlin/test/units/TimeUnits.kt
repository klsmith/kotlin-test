package io.github.klsmith.kotlin.test.units


/**** Nanoseconds ****/

typealias ns = Nanoseconds.UnitType

data class Nanoseconds private constructor(override val value: Double)
	: MeasuredValue<Nanoseconds>, AsSeconds, AsMilliseconds, AsNanoseconds {
	companion object UnitType : CachedUnitType<Nanoseconds>("nanoseconds", "ns", ::Nanoseconds)

	override val unit = UnitType
	override fun asSeconds() = asMilliseconds().asSeconds()
	override fun asMilliseconds() = nanosecondsToMilliseconds(value) of Milliseconds.UnitType
	override fun asNanoseconds() = this
}

const val NANOSECONDS_PER_MILLISECOND: Double = 1000000.0

fun nanosecondsToMilliseconds(nanoseconds: Double): Double = nanoseconds * NANOSECONDS_PER_MILLISECOND

interface AsNanoseconds {
	fun asNanoseconds(): Nanoseconds
}


/**** Milliseconds ****/

typealias ms = Milliseconds.UnitType

data class Milliseconds private constructor(override val value: Double)
	: MeasuredValue<Milliseconds>, AsSeconds, AsMilliseconds, AsNanoseconds {
	companion object UnitType : CachedUnitType<Milliseconds>("milliseconds", "ms", ::Milliseconds)

	override val unit = UnitType
	override fun asSeconds() = millisecondsToSeconds(value) of Seconds.UnitType
	override fun asMilliseconds() = this
	override fun asNanoseconds() = millisecondsToNanoseconds(value) of Nanoseconds.UnitType
}

const val MILLISECONDS_PER_NANOSECOND: Double = 1.0 / NANOSECONDS_PER_MILLISECOND
const val MILLISECONDS_PER_SECOND: Double = 1000.0;

fun millisecondsToNanoseconds(milliseconds: Double): Double = milliseconds * MILLISECONDS_PER_NANOSECOND
fun millisecondsToSeconds(milliseconds: Double): Double = milliseconds * MILLISECONDS_PER_SECOND

interface AsMilliseconds {
	fun asMilliseconds(): Milliseconds
}

/**** Seconds ****/

typealias s = Seconds.UnitType

data class Seconds private constructor(override val value: Double)
	: MeasuredValue<Seconds>, AsSeconds, AsMilliseconds, AsNanoseconds {
	companion object UnitType : CachedUnitType<Seconds>("seconds", "s", ::Seconds)

	override val unit = UnitType
	override fun asSeconds() = this
	override fun asMilliseconds() = secondsToMilliseconds(value) of Milliseconds.UnitType
	override fun asNanoseconds() = asMilliseconds().asNanoseconds()
}

const val SECONDS_PER_MILLISECOND: Double = 1.0 / MILLISECONDS_PER_SECOND

fun secondsToMilliseconds(seconds: Double): Double = seconds * SECONDS_PER_MILLISECOND

interface AsSeconds {
	fun asSeconds(): Seconds
}
