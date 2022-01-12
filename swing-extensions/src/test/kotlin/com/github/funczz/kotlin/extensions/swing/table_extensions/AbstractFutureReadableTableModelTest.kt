package com.github.funczz.kotlin.extensions.swing.table_extensions

import io.kotlintest.provided.start
import io.kotlintest.specs.StringSpec
import javax.swing.JFrame

internal class AbstractFutureReadableTableModelTest : StringSpec() {

    init {

        "デモ" {
            JFrame().start(AbstractFutureReadableTableModelPanel())
            while (true) {
                Thread.sleep(1L)
            }
        }

    }

}