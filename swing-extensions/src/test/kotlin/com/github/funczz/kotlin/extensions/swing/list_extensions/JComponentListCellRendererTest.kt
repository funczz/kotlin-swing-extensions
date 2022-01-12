package com.github.funczz.kotlin.extensions.swing.list_extensions

import io.kotlintest.provided.start
import io.kotlintest.specs.StringSpec
import javax.swing.JFrame

internal class JComponentListCellRendererTest : StringSpec() {

    init {

        "デモ" {
            //JFrame().start(ElementPanel(0))
            JFrame().start(JComponentListCellRendererPanel(selectionBackground = null))
            while (true) {
                Thread.sleep(1L)
            }
        }

    }

}