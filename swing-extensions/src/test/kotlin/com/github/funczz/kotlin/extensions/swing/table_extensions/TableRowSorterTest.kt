package com.github.funczz.kotlin.extensions.swing.table_extensions

import io.kotlintest.provided.start
import io.kotlintest.specs.StringSpec
import javax.swing.JFrame

internal class TableRowSorterTest : StringSpec() {

    init {

        "デモ" {
            JFrame().start(TableRowSorterPanel())
            while (true) {
                Thread.sleep(1L)
            }
        }

    }

}