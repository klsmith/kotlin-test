package io.github.klsmith.kotlin.test

data class Input(val type: InputType, val event: InputEvent)

enum class InputType {

	KEYBOARD_A, KEYBOARD_D, KEYBOARD_S, KEYBOARD_W

}

enum class InputEvent {

	PRESSED, RELEASED

}
