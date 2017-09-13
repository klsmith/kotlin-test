package io.github.klsmith.kotlin.test

import io.github.klsmith.kotlin.test.InputEvent.PRESSED
import io.github.klsmith.kotlin.test.InputEvent.RELEASED
import io.github.klsmith.kotlin.test.InputType.KEYBOARD_A
import io.github.klsmith.kotlin.test.InputType.KEYBOARD_D
import io.github.klsmith.kotlin.test.units.of
import io.github.klsmith.kotlin.test.units.*

class Player(x: Pixels = 0 of px, y: Pixels = 0 of px) {

	private val machine = PlayerStateMachine(x, y)

	val x; get() = machine.x
	val y; get() = machine.y

}

private class PlayerStateMachine(var x: Pixels, var y: Pixels) {
	val speed = 64 of pps

	private val idle = Idle(this)
	private val moveLeft = MoveLeft(this)
	private val moveRight = MoveRight(this)

	private var state: State = idle

	@Synchronized fun noStateChange() {}

	@Synchronized fun idle() {
		state = idle
	}

	@Synchronized fun moveLeft() {
		state = moveLeft
	}

	@Synchronized fun moveRight() {
		state = moveRight
	}

	fun update(delta: Milliseconds) {
		state.update(delta)
	}

	fun render(delta: Milliseconds) {
		state.render(delta)
	}

	fun handle(input: Input) {
		state.handle(input)
	}

}


private class Idle(val machine: PlayerStateMachine) : State {

	override val name = "Idle"

	override fun update(delta: Milliseconds) {}

	override fun render(delta: Milliseconds) {}

	override fun handle(input: Input) {
		val (type, event) = input
		if (PRESSED == event) {
			when (type) {
				KEYBOARD_A -> machine.moveLeft()
				KEYBOARD_D -> machine.moveRight()
				else -> Unit
			}
		}
	}

}


private class MoveLeft(val machine: PlayerStateMachine) : State {

	override val name = "MoveLeft"

	override fun update(delta: Milliseconds) {
		machine.x -= machine.speed.pixelsPer(delta)
	}

	override fun render(delta: Milliseconds) {}

	override fun handle(input: Input) {
		when (input) {
			Input(KEYBOARD_A, RELEASED) -> machine.idle()
		}
	}

}

private class MoveRight(val machine: PlayerStateMachine) : State {

	override val name = "MoveRight"

	override fun update(delta: Milliseconds) {
		machine.x += machine.speed.pixelsPer(delta)
	}

	override fun render(delta: Milliseconds) {}

	override fun handle(input: Input) {
		when (input) {
			Input(KEYBOARD_D, RELEASED) -> machine.idle()
		}
	}

}
