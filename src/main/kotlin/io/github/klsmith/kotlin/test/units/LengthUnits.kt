package io.github.klsmith.kotlin.test.units

/* Pixels */

typealias px = Pixels.Unit

data class Pixels private constructor(override val value: Double) : GenericMeasuredValue<Pixels>(value, Unit) {
	companion object Unit : CachedUnit<Pixels>("pixels", "px", ::Pixels)
}

/* Feet */

typealias ft = Feet.Unit

data class Feet private constructor(override val value: Double) : GenericMeasuredValue<Feet>(value, Unit) {
	companion object Unit : CachedUnit<Feet>("feet", "ft", ::Feet)
}