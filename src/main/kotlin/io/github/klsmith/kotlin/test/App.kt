package io.github.klsmith.kotlin.test

import io.github.klsmith.kotlin.test.units.div
import io.github.klsmith.kotlin.test.units.of
import io.github.klsmith.kotlin.test.units.length.Pixels.Unit as px
import io.github.klsmith.kotlin.test.units.time.Seconds.Unit as s

fun main(args: Array<String>) {
	val pixels = 64 of px
	val seconds = 1 of s
	val speed = pixels / seconds
	println(pixels.abbreviatedDisplayString)
	println(seconds.abbreviatedDisplayString)
	println(speed.abbreviatedDisplayString)
	val differentPixels = 64 of px
	println("${pixels.abbreviatedDisplayString} === ${differentPixels.abbreviatedDisplayString} ? ${pixels === differentPixels}")
}