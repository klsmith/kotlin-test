package io.github.klsmith.kotlin.test.units

typealias px = Pixels.UnitType

data class Pixels private constructor(override val value: Double) : MeasuredValue<Pixels> {
	companion object UnitType : CachedUnitType<Pixels>("pixels", "px", ::Pixels)

	override val unit = UnitType
}
