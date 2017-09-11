package io.github.klsmith.kotlin.test.units.length

import io.github.klsmith.kotlin.test.units.CachedUnit
import io.github.klsmith.kotlin.test.units.GenericMeasuredValue

data class Pixels private constructor(override val value: Double) : GenericMeasuredValue<Pixels>(value, Unit) {
	companion object Unit : CachedUnit<Pixels>("pixels", "px", ::Pixels)
}