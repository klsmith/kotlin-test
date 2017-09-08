package io.github.klsmith.kotlin.test

val ms = MillisecondsUnit

object MillisecondsUnit : UnitType<Milliseconds> {
	override val name = "ms"
	override operator fun invoke(value: Number) = Milliseconds(value.toDouble())
}

data class Milliseconds(override val value: Double) : UnitValue<Milliseconds> {
	override final val unit = MillisecondsUnit
	override operator fun unaryPlus() = this
	override operator fun unaryMinus() = copy(value = -value)
	override operator fun inc() = copy(value = value + 1)
	override operator fun dec() = copy(value = value - 1)
	override operator fun plus(other: Milliseconds) = copy(value = value + other.value)
	override operator fun minus(other: Milliseconds) = copy(value = value - other.value)
	override operator fun times(scalar: Double) = copy(value = value * scalar)
	override operator fun div(scalar: Double) = copy(value = value / scalar)
	override fun compareTo(other: Milliseconds) = if (value > other.value) 1 else if (value < other.value) -1 else 0
}
