package com.github.funczz.kotlin.extensions.swing.event_extensions

import io.kotlintest.provided.start
import io.kotlintest.specs.StringSpec
import javax.swing.JFrame

internal class FunctionalMouseAdapterTest : StringSpec() {

    init {

        "デモ" {
            JFrame().start(FunctionalMouseAdapterPanel())
            while (true) {
                Thread.sleep(1L)
            }
        }

    }

}