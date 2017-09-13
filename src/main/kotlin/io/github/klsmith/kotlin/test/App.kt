package io.github.klsmith.kotlin.test

import io.github.klsmith.kotlin.test.units.Pixels
import io.github.klsmith.kotlin.test.units.PixelsPerSecond
import io.github.klsmith.kotlin.test.units.Seconds
import io.github.klsmith.kotlin.test.units.div
import io.github.klsmith.kotlin.test.units.of
import io.github.klsmith.kotlin.test.units.px
import io.github.klsmith.kotlin.test.units.s

fun main(args: Array<String>) {
	val pixels: Pixels = 64 of px
	val seconds: Seconds = 1 of s
	val speed: PixelsPerSecond = pixels / seconds
	println(pixels.abbreviatedDisplayString)
	println(seconds.abbreviatedDisplayString)
	println(speed.abbreviatedDisplayString)
	val differentPixels = 64 of px
	println("${pixels.abbreviatedDisplayString} === ${differentPixels.abbreviatedDisplayString} ? ${pixels === differentPixels}")
}