package io.github.klsmith.kotlin.test.units

const val NANOSECONDS_PER_MILLISECOND: Double = 1000000.0

fun nanosecondsToMilliseconds(nanoseconds: Double): Double = nanoseconds * NANOSECONDS_PER_MILLISECOND

interface AsNanoseconds {
	fun asNanoseconds(): Nanoseconds
}

typealias ns = Nanoseconds.UnitType

data class Nanoseconds private constructor(override val value: Double)
	: MeasuredValue<Nanoseconds>, AsSeconds, AsMilliseconds, AsNanoseconds {
	companion object UnitType : CachedUnitType<Nanoseconds>("nanoseconds", "ns", ::Nanoseconds)

	override val unit = UnitType
	override fun asSeconds() = asMilliseconds().asSeconds()
	override fun asMilliseconds() = nanosecondsToMilliseconds(value) of Milliseconds.UnitType
	override fun asNanoseconds() = this
}
