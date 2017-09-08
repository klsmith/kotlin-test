package io.github.klsmith.kotlin.test

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class AppTest : StringSpec({

	"1 + 1 should be 2" {
		1 + 1 shouldBe 2
	}

	"2 + 2 should be 4" {
		2 + 2 shouldBe 4
	}

})