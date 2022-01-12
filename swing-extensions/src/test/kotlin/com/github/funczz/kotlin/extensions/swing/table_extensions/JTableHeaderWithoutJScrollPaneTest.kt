package com.github.funczz.kotlin.extensions.swing.table_extensions

import io.kotlintest.provided.start
import io.kotlintest.specs.StringSpec
import javax.swing.JFrame

internal class JTableHeaderWithoutJScrollPaneTest : StringSpec() {

    init {

        "デモ" {
            JFrame().start(JTableHeaderWithoutJScrollPanePanel())
            while (true) {
                Thread.sleep(1L)
            }
        }

    }

}