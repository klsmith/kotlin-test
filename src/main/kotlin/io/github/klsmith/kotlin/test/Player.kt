package io.github.klsmith.kotlin.test

import io.github.klsmith.kotlin.test.InputEvent.PRESSED
import io.github.klsmith.kotlin.test.InputEvent.RELEASED
import io.github.klsmith.kotlin.test.InputType.KEYBOARD_A
import io.github.klsmith.kotlin.test.InputType.KEYBOARD_D
import io.github.klsmith.kotlin.test.units.of
import io.github.klsmith.kotlin.test.units.pps

private const val PLAYER_SPEED_PPS = 64F

class Player(x: Float = 0F, y: Float = 0F) {

	private val machine = PlayerStateMachine(x, y)

	val x; get() = machine.x
	val y; get() = machine.y

}

private class PlayerStateMachine(var x: Float, var y: Float) {

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

	fun update(delta: Float) {
		state.update(delta)
	}

	fun render(delta: Float) {
		state.render(delta)
	}

	fun handle(input: Input) {
		state.handle(input)
	}

}


private class Idle(val machine: PlayerStateMachine) : State {

	override val name = "Idle"

	override fun update(delta: Float) {}

	override fun render(delta: Float) {}

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

	override fun update(delta: Float) {
		machine.x -= PLAYER_SPEED_PPS * delta
	}

	override fun render(delta: Float) {}

	override fun handle(input: Input) {
		when (input) {
			Input(KEYBOARD_A, RELEASED) -> machine.idle()
		}
	}

}

private class MoveRight(val machine: PlayerStateMachine) : State {

	override val name = "MoveRight"

	override fun update(delta: Float) {
		machine.x += PLAYER_SPEED_PPS * delta
	}

	override fun render(delta: Float) {}

	override fun handle(input: Input) {
		when (input) {
			Input(KEYBOARD_D, RELEASED) -> machine.idle()
		}
	}

}
