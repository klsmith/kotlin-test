package io.github.klsmith.kotlin.test

import io.github.klsmith.kotlin.test.units.Pixels
import io.github.klsmith.kotlin.test.units.PixelsPerSecond
import io.github.klsmith.kotlin.test.units.Seconds
import io.github.klsmith.kotlin.test.units.div
import io.github.klsmith.kotlin.test.units.of
import io.github.klsmith.kotlin.test.units.px
import io.github.klsmith.kotlin.test.units.*

fun main(args: Array<String>) {
	val pixels = 64 of px
	val seconds = 1 of s
	val speed = pixels / seconds
	println(pixels.abbreviatedDisplayString)
	println(seconds.abbreviatedDisplayString)
	println(speed.abbreviatedDisplayString)
	var differentPixels = 64 of px
	differentPixels++
	differentPixels -= 2
	println("${pixels.abbreviatedDisplayString} >= ${differentPixels.abbreviatedDisplayString} ? ${pixels >= differentPixels}")
	println()
	println()
	val nanoseconds = 128 of ns
	println(nanoseconds.abbreviatedDisplayString)
	val milliseconds = nanoseconds.asMilliseconds()
	println("is the same as ${nanoseconds.abbreviatedDisplayString}!")
	val secondsA = nanoseconds.asSeconds()
	println("is the same as ${secondsA.abbreviatedDisplayString}")
	val secondsB = milliseconds.asSeconds()
	println("${secondsA.abbreviatedDisplayString} === ${secondsB.abbreviatedDisplayString} ? ${secondsA === secondsB}")
	val newNanoseconds = secondsA.asNanoseconds()
	println("back to ${newNanoseconds.abbreviatedDisplayString}")
}