package io.github.klsmith.kotlin.test

import io.github.klsmith.kotlin.test.units.Milliseconds

interface State {

	val name: String

	fun update(delta: Milliseconds)

	fun handle(input: Input)

	fun render(delta: Milliseconds)

}