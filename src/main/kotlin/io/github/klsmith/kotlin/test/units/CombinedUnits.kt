package io.github.klsmith.kotlin.test.units

/* Pixels per Second */

typealias pps = PixelsPerSecond.UnitType

data class PixelsPerSecond private constructor(override val value: Double) : MeasuredValue<PixelsPerSecond> {
	companion object UnitType : CachedUnitType<PixelsPerSecond>("pixels/second", "pps", ::PixelsPerSecond)

	override val unit = UnitType
}

operator fun Pixels.div(seconds: Seconds): PixelsPerSecond = PixelsPerSecond(value / seconds.value)