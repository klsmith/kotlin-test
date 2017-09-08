package io.github.klsmith.kotlin.test

val pps = PixelsPerSecondUnit

object PixelsPerSecondUnit : UnitType<PixelsPerSecond> {
	override val name = "pps"
	override operator fun invoke(value: Number) = PixelsPerSecond(value.toDouble())
}

data class PixelsPerSecond(override val value: Double) : UnitValue<PixelsPerSecond> {
	override final val unit = PixelsPerSecondUnit
	override operator fun unaryPlus() = this
	override operator fun unaryMinus() = copy(value = -value)
	override operator fun inc() = copy(value = value + 1)
	override operator fun dec() = copy(value = value - 1)
	override operator fun plus(other: PixelsPerSecond) = copy(value = value + other.value)
	override operator fun minus(other: PixelsPerSecond) = copy(value = value - other.value)
	override operator fun times(scalar: Double) = copy(value = value * scalar)
	override operator fun div(scalar: Double) = copy(value = value / scalar)
	override fun compareTo(other: PixelsPerSecond) = if (value > other.value) 1 else if (value < other.value) -1 else 0
}