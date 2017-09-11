package io.github.klsmith.kotlin.test.units.time

import io.github.klsmith.kotlin.test.units.CachedUnit
import io.github.klsmith.kotlin.test.units.GenericMeasuredValue
import io.github.klsmith.kotlin.test.units.of
import io.github.klsmith.kotlin.test.units.time.Seconds.Unit as seconds


data class Milliseconds private constructor(override val value: Double) : GenericMeasuredValue<Milliseconds>(value, Unit) {
	companion object Unit : CachedUnit<Milliseconds>("milliseconds", "ms", ::Milliseconds)

	fun asSeconds(): Seconds = millisecondsToSeconds(value) of seconds
}

const val MILLISECONDS_PER_SECOND: Double = 1000.0;

fun millisecondsToSeconds(milliseconds: Double): Double = milliseconds * MILLISECONDS_PER_SECOND
