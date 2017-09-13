package io.github.klsmith.kotlin.test.units

const val MILLISECONDS_PER_NANOSECOND: Double = 1.0 / NANOSECONDS_PER_MILLISECOND
const val MILLISECONDS_PER_SECOND: Double = 1000.0;

fun millisecondsToNanoseconds(milliseconds: Double): Double = milliseconds * MILLISECONDS_PER_NANOSECOND
fun millisecondsToSeconds(milliseconds: Double): Double = milliseconds * MILLISECONDS_PER_SECOND

interface AsMilliseconds {
	fun asMilliseconds(): Milliseconds
}

typealias ms = Milliseconds.UnitType

data class Milliseconds private constructor(override val value: Double)
	: MeasuredValue<Milliseconds>, AsSeconds, AsMilliseconds, AsNanoseconds {
	companion object UnitType : CachedUnitType<Milliseconds>("milliseconds", "ms", ::Milliseconds)

	override val unit = UnitType
	override fun asSeconds() = millisecondsToSeconds(value) of Seconds.UnitType
	override fun asMilliseconds() = this
	override fun asNanoseconds() = millisecondsToNanoseconds(value) of Nanoseconds.UnitType
}
