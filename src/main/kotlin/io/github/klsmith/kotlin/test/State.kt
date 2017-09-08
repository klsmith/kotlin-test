package io.github.klsmith.kotlin.test

interface State {

	val name: String

	fun update(delta: Float)

	fun handle(input: Input)

	fun render(delta: Float)

}