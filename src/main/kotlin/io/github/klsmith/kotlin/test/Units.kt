package io.github.klsmith.kotlin.test

infix fun <V : Number, U : UnitValue<U>> V.of(unit: UnitType<U>) = unit(this)

interface UnitType<U : UnitValue<U>> {
	val name: String
	operator fun invoke(value: Number): U
}

interface UnitValue<U : UnitValue<U>> : Comparable<U> {
	val value: Double
	val unit: UnitType<U>
	operator fun unaryPlus(): UnitValue<U>
	operator fun unaryMinus(): UnitValue<U>
	operator fun inc(): UnitValue<U>
	operator fun dec(): UnitValue<U>
	operator fun plus(other: U): U
	operator fun minus(other: U): U
	operator fun times(scalar: Double): U
	operator fun div(scalar: Double): U
}
