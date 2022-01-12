package com.github.funczz.kotlin.extensions.swing

import io.kotlintest.provided.start
import io.kotlintest.specs.StringSpec
import javax.swing.JFrame

internal class FunctionalSwingWorkerTest : StringSpec() {

    init {

        "デモ" {
            JFrame().start(FunctionalSwingWorkerPanel())
            while (true) {
                Thread.sleep(1L)
            }
        }

    }

}