package io.github.klsmith.kotlin.test.units

typealias ft = Feet.UnitType

data class Feet private constructor(override val value: Double) : MeasuredValue<Feet> {
	companion object UnitType : CachedUnitType<Feet>("feet", "ft", ::Feet)

	override val unit = UnitType
}