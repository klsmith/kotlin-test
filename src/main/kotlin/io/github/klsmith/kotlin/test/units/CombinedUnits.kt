package io.github.klsmith.kotlin.test.units

/* Pixels per Second */

data class PixelsPerSecond private constructor(override val value: Double) : GenericMeasuredValue<PixelsPerSecond>(value, Unit) {
	companion object Unit : CachedUnit<PixelsPerSecond>("pixels/second", "pps", ::PixelsPerSecond)
}

operator fun Pixels.div(seconds: Seconds): PixelsPerSecond = PixelsPerSecond(value / seconds.value)