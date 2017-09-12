package io.github.klsmith.kotlin.test.units

/* Pixels */

data class Pixels private constructor(override val value: Double) : GenericMeasuredValue<Pixels>(value, Unit) {
	companion object Unit : CachedUnit<Pixels>("pixels", "px", ::Pixels)
}

/* Feet */

data class Feet private constructor(override val value: Double) : GenericMeasuredValue<Feet>(value, Unit) {
	companion object Unit : CachedUnit<Feet>("feet", "ft", ::Feet)
}