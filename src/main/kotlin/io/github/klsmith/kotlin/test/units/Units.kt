package io.github.klsmith.kotlin.test.units

import io.github.klsmith.kotlin.test.Cache
import io.github.klsmith.kotlin.test.Constructor
import io.github.klsmith.kotlin.test.SimpleInMemoryCache

infix fun <V : Number, U : MeasuredValue<U>> V.of(unit: UnitType<U>) = this.toDouble() of unit
infix fun <U : MeasuredValue<U>> Double.of(unit: UnitType<U>) = unit(this)

interface UnitType<U : MeasuredValue<U>> {
	val name: String
	val abbreviation: String
	operator fun invoke(value: Double): U
}

abstract class CachedUnitType<U : MeasuredValue<U>>(
		override val name: String,
		override val abbreviation: String,
		private val cache: Cache<Double, U>
) : UnitType<U>, Cache<Double, U> by cache {
	constructor(name: String, abbreviation: String, constructor: Constructor<Double, U>)
			: this(name, abbreviation, SimpleInMemoryCache(constructor))
}

interface MeasuredValue<U : MeasuredValue<U>> : Comparable<U> {
	val value: Double
	val unit: UnitType<U>
	val displayString: String; get() = "$value ${unit.name}"
	val abbreviatedDisplayString: String; get() = "$value ${unit.abbreviation}"
	operator fun unaryPlus(): U = unit(value)
	operator fun unaryMinus(): U = unit(-value)
	operator fun inc(): U = unit(value + 1)
	operator fun dec(): U = unit(value - 1)
	operator fun plus(other: U): U = plus(other.value)
	operator fun plus(number: Number): U = plus(number.toDouble())
	operator fun plus(otherValue: Double): U = unit(value + otherValue)
	operator fun minus(other: U): U = minus(other.value)
	operator fun minus(number: Number): U = minus(number.toDouble())
	operator fun minus(otherValue: Double): U = unit(value - otherValue)
	operator fun times(scalar: Double): U = unit(value * scalar)
	operator fun div(scalar: Double): U = unit(value / scalar)
	fun abs(): U = unit(Math.abs(value))
	fun round(): U = unit(Math.round(value).toDouble())
	fun ceil(): U = unit(Math.ceil(value).toDouble())
	fun floor(): U = unit(Math.floor(value).toDouble())
	override fun compareTo(other: U) = if (value > other.value) 1 else if (value < other.value) -1 else 0
}