package io.github.klsmith.kotlin.test.units

import io.github.klsmith.kotlin.test.units.length.Pixels
import io.github.klsmith.kotlin.test.units.time.Seconds
import io.github.klsmith.kotlin.test.units.length.Pixels.Unit as px
import io.github.klsmith.kotlin.test.units.time.Seconds.Unit as seconds

data class PixelsPerSecond private constructor(override val value: Double) : GenericMeasuredValue<PixelsPerSecond>(value, Unit) {
	companion object Unit : CachedUnit<PixelsPerSecond>("pixels/second", "pps", ::PixelsPerSecond)
}

operator fun Pixels.div(seconds: Seconds): PixelsPerSecond = PixelsPerSecond(value / seconds.value)