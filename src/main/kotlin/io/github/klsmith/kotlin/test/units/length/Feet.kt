package io.github.klsmith.kotlin.test.units.length

import io.github.klsmith.kotlin.test.units.CachedUnit
import io.github.klsmith.kotlin.test.units.GenericMeasuredValue

data class Feet private constructor(override val value: Double) : GenericMeasuredValue<Feet>(value, Unit) {
	companion object Unit : CachedUnit<Feet>("feet", "ft", ::Feet)
}