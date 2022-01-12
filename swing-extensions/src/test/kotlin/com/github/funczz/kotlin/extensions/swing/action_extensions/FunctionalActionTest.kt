package com.github.funczz.kotlin.extensions.swing.action_extensions

import io.kotlintest.provided.start
import io.kotlintest.specs.StringSpec
import javax.swing.JFrame

internal class FunctionalActionTest : StringSpec() {

    init {

        "デモ" {
            JFrame().start(FunctionalActionPanel())
            while (true) {
                Thread.sleep(1L)
            }
        }

    }
}