package com.github.funczz.kotlin.extensions.swing.table_extensions

import io.kotlintest.provided.start
import io.kotlintest.specs.StringSpec
import javax.swing.JFrame

internal class JTableHeaderTest : StringSpec() {

    init {

        "デモ" {
            JFrame().start(JTableHeaderPanel())
            while (true) {
                Thread.sleep(1L)
            }
        }

    }

}