package io.github.klsmith.kotlin.test.units.time

import io.github.klsmith.kotlin.test.SimpleCache
import io.github.klsmith.kotlin.test.units.GenericMeasuredValue
import io.github.klsmith.kotlin.test.units.UnitType
import io.github.klsmith.kotlin.test.units.of
import io.github.klsmith.kotlin.test.units.CachedUnit
import io.github.klsmith.kotlin.test.units.time.Milliseconds.Unit as milliseconds

data class Seconds private constructor(override val value: Double) : GenericMeasuredValue<Seconds>(value, Unit) {
	companion object Unit : CachedUnit<Seconds>("seconds", "s", ::Seconds)

	fun asMilliseconds(): Milliseconds = secondsToMilliseconds(value) of milliseconds
}

const val SECONDS_PER_MILLISECOND: Double = 1.0 / 1000.0

fun secondsToMilliseconds(seconds: Double): Double = seconds * SECONDS_PER_MILLISECOND