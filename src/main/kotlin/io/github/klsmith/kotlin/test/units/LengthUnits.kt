package io.github.klsmith.kotlin.test.units

/* Pixels */

typealias px = Pixels.UnitType

data class Pixels private constructor(override val value: Double) : MeasuredValue<Pixels> {
	companion object UnitType : CachedUnitType<Pixels>("pixels", "px", ::Pixels)

	override val unit = UnitType
}

/* Feet */

typealias ft = Feet.UnitType

data class Feet private constructor(override val value: Double) : MeasuredValue<Feet> {
	companion object UnitType : CachedUnitType<Feet>("feet", "ft", ::Feet)

	override val unit = UnitType
}