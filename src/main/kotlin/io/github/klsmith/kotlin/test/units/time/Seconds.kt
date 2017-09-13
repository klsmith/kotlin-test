package io.github.klsmith.kotlin.test.units

const val SECONDS_PER_MILLISECOND: Double = 1.0 / MILLISECONDS_PER_SECOND

fun secondsToMilliseconds(seconds: Double): Double = seconds * SECONDS_PER_MILLISECOND

interface AsSeconds {
	fun asSeconds(): Seconds
}

typealias s = Seconds.UnitType

data class Seconds private constructor(override val value: Double)
	: MeasuredValue<Seconds>, AsSeconds, AsMilliseconds, AsNanoseconds {
	companion object UnitType : CachedUnitType<Seconds>("seconds", "s", ::Seconds)

	override val unit = UnitType
	override fun asSeconds() = this
	override fun asMilliseconds() = secondsToMilliseconds(value) of Milliseconds.UnitType
	override fun asNanoseconds() = asMilliseconds().asNanoseconds()
}
