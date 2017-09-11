package io.github.klsmith.kotlin.test.units

import io.github.klsmith.kotlin.test.Cache
import io.github.klsmith.kotlin.test.SimpleCache

infix fun <V : Number, U : MeasuredValue<U>> V.of(unit: UnitType<U>) = this.toDouble() of unit
infix fun <U : MeasuredValue<U>> Double.of(unit: UnitType<U>) = unit(this)

interface UnitType<U : MeasuredValue<U>> {
	val name: String
	val abbreviation: String
	operator fun invoke(value: Double): U
}

open class CachedUnit<U : MeasuredValue<U>>(
		override val name: String,
		override val abbreviation: String,
		private val cache: Cache<Double, U>
) : UnitType<U> {
	constructor(name: String, abbreviation: String, constructor: (Double) -> U)
			: this(name, abbreviation, SimpleCache(constructor))

	override operator fun invoke(value: Double) = cache.get(value)
}

interface MeasuredValue<U : MeasuredValue<U>> : Comparable<U> {
	val value: Double
	val unit: UnitType<U>
	val displayString: String
	val abbreviatedDisplayString: String
	operator fun unaryPlus(): U
	operator fun unaryMinus(): U
	operator fun inc(): U
	operator fun dec(): U
	operator fun plus(other: U): U
	operator fun minus(other: U): U
	operator fun times(scalar: Double): U
	operator fun div(scalar: Double): U
}

abstract class GenericMeasuredValue<U : GenericMeasuredValue<U>>(
		override val value: Double,
		override val unit: UnitType<U>
) : MeasuredValue<U> {
	override val displayString; get() = "$value ${unit.name}"
	override val abbreviatedDisplayString; get() = "$value ${unit.abbreviation}"
	override operator fun unaryPlus() = unit(value)
	override operator fun unaryMinus() = unit(-value)
	override operator fun inc() = unit(value + 1)
	override operator fun dec() = unit(value - 1)
	override operator fun plus(other: U) = unit(value + other.value)
	override operator fun minus(other: U) = unit(value - other.value)
	override operator fun times(scalar: Double) = unit(value * scalar)
	override operator fun div(scalar: Double) = unit(value / scalar)
	override fun compareTo(other: U) = if (value > other.value) 1 else if (value < other.value) -1 else 0
}