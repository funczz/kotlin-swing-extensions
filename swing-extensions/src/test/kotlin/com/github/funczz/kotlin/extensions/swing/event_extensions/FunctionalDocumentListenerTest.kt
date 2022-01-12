package com.github.funczz.kotlin.extensions.swing.event_extensions

import io.kotlintest.provided.start
import io.kotlintest.specs.StringSpec
import javax.swing.JFrame

internal class FunctionalDocumentListenerTest : StringSpec() {

    init {

        "デモ" {
            JFrame().start(FunctionalDocumentListenerPanel())
            while (true) {
                Thread.sleep(1L)
            }
        }

    }

}